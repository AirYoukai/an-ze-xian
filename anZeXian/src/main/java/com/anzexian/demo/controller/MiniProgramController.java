package com.anzexian.demo.controller;

import com.alibaba.fastjson.JSONObject;
//import org.apache.http.HttpRequest;
//import com.sun.deploy.net.HttpRequest;
import com.anzexian.demo.util.HttpRequest;
import com.anzexian.demo.util.SubscribeMessageTest;
import com.anzexian.demo.util.TemplateData;
import com.mashape.unirest.http.JsonNode;
import org.apache.http.HttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.misc.Contended;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.Map;

import static com.anzexian.demo.util.Constant.APP_ID;
import static com.anzexian.demo.util.Constant.MINIPRO_SECRET_KEY;

@Controller
@RequestMapping("/miniProgram")
public class MiniProgramController {

    @RequestMapping("/tryRequestMessage")
    @ResponseBody
    public Boolean tryRequestMessage(HttpServletRequest request, HttpServletResponse response) {
        // 小程序唯一标识 (在微信小程序管理后台获取)
        response.setContentType("text/html;charset=utf-8");
        /*设置响应头允许ajax跨域访问*/
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* 星号表示所有的异域请求都可以接受， */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        //获取微信小程序get的参数值并打印
        String openId = request.getParameter("openId");
        String templateId = request.getParameter("templateId");
        String page = request.getParameter("page");
//        HttpSession session = request.getSession(true);
//        session.setAttribute("openId", openId);
//        session.setAttribute("templateId", templateId);
//        session.setAttribute("page", page);
//        String wxspAppid = APP_ID;
//        // 小程序的 app secret (在微信小程序管理后台获取)
//        String wxspSecret = MINIPRO_SECRET_KEY;
//        // 授权（必填）
//        String grant_type2 = "client_credential";
////	    		  1、向微信服务器 使用登录凭证 code 获取 session_key 和 openid
//        // 请求参数
//        String params2 = "appid=" + wxspAppid + "&secret=" + wxspSecret + "&grant_type=" + grant_type2;
//        // 发送请求
//        String sr2 = HttpRequest.sendGet("https://api.weixin.qq.com/cgi-bin/token", params2);//
//        // 解析相应内容（转换成json对象）
//        JSONObject json2 = JSONObject.parseObject(sr2);
//        System.out.println("json2==" + json2.toJSONString());
//        String access_token = json2.get("access_token").toString();
//        System.out.println("access_token ==" + access_token );
//        Map<String, TemplateData> map = new HashMap<>();
////        任务名称
////        责任人
////        当前环节
//        map.put("thing1", new TemplateData("理赔业务-待审核"));
//        map.put("thing2", new TemplateData("你"));
//        map.put("thing6", new TemplateData("待审核"));
////        String accessToken,String touser, String templateId, String page, Map<String, TemplateData > map
//        Boolean flag=false;
//        try{
//            JsonNode res=SubscribeMessageTest.subscribeMessage(access_token,openId,templateId,page,map);
//            if("ok".equals(res.getObject().getString("errmsg")))flag=true;
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        return true;
    }

//    public static int getCompanyId(String companyId){
//        return 0;
//    }
}
