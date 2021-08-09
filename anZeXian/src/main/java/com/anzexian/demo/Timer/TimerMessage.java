package com.anzexian.demo.Timer;

import com.alibaba.fastjson.JSONObject;
import com.anzexian.demo.entity.InsuranceClaim;
import com.anzexian.demo.entity.UserManage;
import com.anzexian.demo.service.InsuranceClaimService;
import com.anzexian.demo.service.InsuranceOrderService;
import com.anzexian.demo.service.UserManageService;
import com.anzexian.demo.util.HttpRequest;
import com.anzexian.demo.util.SubscribeMessageTest;
import com.anzexian.demo.util.TemplateData;
import com.mashape.unirest.http.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.anzexian.demo.util.Constant.APP_ID;
import static com.anzexian.demo.util.Constant.MINIPRO_SECRET_KEY;

@EnableScheduling
@Component
public class TimerMessage {
    @Autowired
    InsuranceClaimService insuranceClaimService;
    @Autowired
    UserManageService userManageService;
    @Autowired
    InsuranceOrderService insuranceOrderService;

    private static String grant_type2 = "client_credential";
    private static String page="/pages/apply/apply_map/apply_map";
    private static String templateId="rpOdYba1dozS3QboRMmm2-4Yaguk8wrKYpLtrQbj0aI";

    @Scheduled(fixedRate =1*60*1000)
    public void requestMessage(){
        // 请求参数
        String params2 = "appid=" + APP_ID + "&secret=" + MINIPRO_SECRET_KEY + "&grant_type=" + grant_type2;
        // 发送请求
        String sr2 = HttpRequest.sendGet("https://api.weixin.qq.com/cgi-bin/token", params2);//
        // 解析相应内容（转换成json对象）
        JSONObject json2 = JSONObject.parseObject(sr2);
        String access_token = json2.get("access_token").toString();
        if(insuranceOrderService.hasOrderNotActive()){
            //本质上要取的是被用户手动撤销的单，自动过期的不算，自动过期的压根不会有撤保功能
            //催员工即可
            Map<String, TemplateData> map = new HashMap<>();
            List<UserManage> staffList = new ArrayList();//打工人们
            try {
                staffList=userManageService.getAllStaffs();
                for(int i=0;i<staffList.size();i++){
                    UserManage tmp=staffList.get(i);
                    map.put("thing1", new TemplateData("撤保业务"));//        任务名称
                    map.put("thing2", new TemplateData(tmp.getUserRealName()));//        责任人
                    map.put("thing6", new TemplateData("待确认通过"));//        当前环节
                    JsonNode res= SubscribeMessageTest.subscribeMessage(access_token,tmp.getOpenId(),templateId,page,map);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        if(insuranceClaimService.hasClaimsForStaff()){//如果有任务要催员工，包括付款和审核
            Map<String, TemplateData> map = new HashMap<>();
            List<UserManage> staffList = new ArrayList();//打工人们
            try {
                staffList=userManageService.getAllStaffs();
                for(int i=0;i<staffList.size();i++){
                    UserManage tmp=staffList.get(i);
                    map.put("thing1", new TemplateData("理赔业务"));//        任务名称
                    map.put("thing2", new TemplateData(tmp.getUserRealName()));//        责任人
                    map.put("thing6", new TemplateData("待审核/待赔款"));//        当前环节
                    JsonNode res= SubscribeMessageTest.subscribeMessage(access_token,tmp.getOpenId(),templateId,page,map);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        if(insuranceClaimService.hasClaimsForManager()){//如果有任务要催领导
            Map<String, TemplateData> map = new HashMap<>();
            List<UserManage> managerList = new ArrayList();//领导们
            try {
                managerList=userManageService.getAllManagers();
                for(int i=0;i<managerList.size();i++){
                    UserManage tmp=managerList.get(i);
                    map.put("thing1", new TemplateData("理赔业务"));//        任务名称
                    map.put("thing2", new TemplateData(tmp.getUserRealName()));//        责任人
                    map.put("thing6", new TemplateData("待审核"));//        当前环节
                    JsonNode res= SubscribeMessageTest.subscribeMessage(access_token,tmp.getOpenId(),templateId,page,map);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
