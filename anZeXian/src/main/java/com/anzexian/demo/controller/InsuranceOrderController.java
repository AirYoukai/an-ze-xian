package com.anzexian.demo.controller;

import com.anzexian.demo.entity.InsuranceCompany;
import com.anzexian.demo.entity.InsuranceNews;
import com.anzexian.demo.entity.InsuranceOrder;
import com.anzexian.demo.entity.UserManage;
import com.anzexian.demo.service.InsuranceOrderService;
import com.anzexian.demo.service.InsuranceServiceService;
import com.anzexian.demo.service.UserManageService;
import com.anzexian.demo.util.ExportPrintUtils;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import static com.anzexian.demo.util.ExportPrintUtils.getReturnFile;

//import com.anzexian.demo.util.BaseResponse;
//import com.miao.common.utils.ResultInfo;
//import com.miao.common.utils.StringUtil;
//import org.apache.commons.lang.RandomStringUtils;
//import org.apache.http.impl.client.HttpClients;

@Controller
@RequestMapping("/insuranceOrder")
public class InsuranceOrderController {
    @Autowired
    private InsuranceOrderService insuranceOrderService;
    @Autowired
    private InsuranceServiceService insuranceServiceService;
    @Autowired
    private UserManageService userManageService;
//    @Autowired
//    private InsuranceApplicantService insuranceApplicantService;
//    @Autowired
//    private InsuranceInsuredService insuranceInsuredService;

    @RequestMapping("/toOrderList")
    public String toOrderList() {
        return "insurance/order_list";
    }

    @RequestMapping("/toOrderBusiness")
    public String toOrderBusiness(HttpServletRequest httpServletRequest) {
        UserManage curUser = new UserManage();
        HttpSession session = httpServletRequest.getSession(true);
        if (session.getAttribute("curUser") != null) {
            curUser = (UserManage) session.getAttribute("curUser");
            if (curUser.getUserRole() == 0 || curUser.getUserRole() == 1)//员工或老板才有资格去处理理赔业务
                return "insurance/order_business";
            else
                return "common/role_exception";
        }
        return "common/logout";
    }


//    public static int getCompanyId(String companyId){
//        return 0;
//    }


    @RequestMapping("/selectLike")
    @ResponseBody
    public PageInfo selectLike(
            @RequestParam(value = "serviceName", required = false) String serviceName,
            @RequestParam(value = "companyId", required = false) String companyId,
            @RequestParam(value = "industry", required = false) String industry,
            @RequestParam(value = "isActive", required = false) String isActive,
            @RequestParam(value = "expireTimeFrom", required = false) String expireTimeFrom,
            @RequestParam(value = "expireTimeTo", required = false) String expireTimeTo,
            @RequestParam(value = "createTimeFrom", required = false) String createTimeFrom,
            @RequestParam(value = "createTimeTo", required = false) String createTimeTo,
            @RequestParam(value = "pageSize", required = false) String pageSize,
            @RequestParam(value = "pageNum", required = false) String pageNum,
            @RequestParam(value = "orderByOne", required = false) String orderByOne,
            @RequestParam(value = "orderByTwo", required = false) String orderByTwo,
            @RequestParam(value = "orderByThree", required = false) String orderByThree
    ) {
        InsuranceOrder insuranceOrder = new InsuranceOrder();
        try {
//            insuranceOrder.setIndustry(industry);
            if (companyId != null && !"".equals(companyId))
                insuranceOrder.setCompanyId(Integer.parseInt(companyId));
            if (serviceName != null && !"".equals(serviceName))
                insuranceOrder.setServiceName(serviceName);
            if (industry != null && !"".equals(industry))
                insuranceOrder.setIndustry(industry);

            if (isActive == null || "".equals(isActive)) insuranceOrder.setIsActive(true);
            else insuranceOrder.setIsActive(Boolean.valueOf(isActive));

            if (expireTimeFrom != null && !"".equals(expireTimeFrom))
                insuranceOrder.setExpireTimeFrom(expireTimeFrom + " 00:00:00");
            if (expireTimeTo != null && !"".equals(expireTimeTo))
                insuranceOrder.setExpireTimeTo(expireTimeTo + " 00:00:00");
            
            if (createTimeFrom != null && !"".equals(createTimeFrom))
                insuranceOrder.setCreateTimeFrom(createTimeFrom + " 00:00:00");
            if (createTimeTo != null && !"".equals(createTimeTo))
                insuranceOrder.setCreateTimeTo(createTimeTo + " 00:00:00");
            insuranceOrder.setOrderByOne(orderByOne);
            insuranceOrder.setOrderByTwo(orderByTwo);
            insuranceOrder.setOrderByThree(orderByThree);
        } catch (NullPointerException e) {
            System.out.println("Null pointer in selectLike in Order controller");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("NumberFormat problem in selectLike in Order controller");
            e.printStackTrace();
        }
        PageInfo res = insuranceOrderService.selectLike(insuranceOrder, pageNum, pageSize);
        return res;
    }

    @RequestMapping("/selectByOpenId")
    @ResponseBody
    public List<InsuranceOrder> selectByOpenId(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("===========selectByOpenId in InsuranceOrder entered!=============");
        response.setContentType("text/html;charset=utf-8");
        /*设置响应头允许ajax跨域访问*/
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* 星号表示所有的异域请求都可以接受， */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        //获取微信小程序get的参数值并打印
        String openId = request.getParameter("openId");
        List<InsuranceOrder> insuranceOrderList = new ArrayList<>();
        try {
            UserManage userManage = new UserManage();
            userManage = userManageService.selectByUserName(openId);
            insuranceOrderList = insuranceOrderService.selectByBuyerId(userManage.getId());
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
//        return insuranceOrderService.selectById(id);
        return insuranceOrderList;
    }

    @RequestMapping("/selectById")
    @ResponseBody
    public InsuranceOrder selectById(@RequestParam(value = "id", required = false) String id) {
        return insuranceOrderService.selectById(id);
    }

    @RequestMapping("/deleteById")
    @ResponseBody
    public String deleteById(@RequestParam(value = "id", required = false) String id) {
        return insuranceOrderService.deleteById(id) + "";
    }

    @RequestMapping("/updateAjax")
    @ResponseBody
    public Boolean updateAjax(@RequestParam(value = "id", required = false) String id,
                              @RequestParam(value = "isActive", required = false) String isActive,
                              @RequestParam(value = "expireTime", required = false) String expireTime
    ) {
        InsuranceOrder insuranceOrder = new InsuranceOrder();
        try {
            insuranceOrder.setId(Integer.parseInt(id));
            if(isActive!=null && !"".equals(isActive))
                insuranceOrder.setIsActive(Boolean.valueOf(isActive));
            if (expireTime != null && !"".equals(expireTime))
                insuranceOrder.setExpireTime(LocalDateTime.parse(expireTime + " 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (DateTimeParseException e) {
            System.out.println("DateTimeParseException in add");
            e.printStackTrace();
        }
        return insuranceOrderService.updateById(insuranceOrder);
    }

    @RequestMapping("/exportData")
    public ResponseEntity<byte[]> exportData(
//            @RequestParam(value = "serviceName", required = false) String serviceName,
            @RequestParam(value = "companyId", required = false) String companyId,
            @RequestParam(value = "industry", required = false) String industry,
            @RequestParam(value = "isActive", required = false) String isActive,
            @RequestParam(value = "expireTimeFrom", required = false) String expireTimeFrom,
            @RequestParam(value = "expireTimeTo", required = false) String expireTimeTo,
            @RequestParam(value = "createTimeFrom", required = false) String createTimeFrom,
            @RequestParam(value = "createTimeTo", required = false) String createTimeTo,
            @RequestParam(value = "pageSize", required = false) String pageSize,
            @RequestParam(value = "pageNum", required = false) String pageNum,
            @RequestParam(value = "orderByOne", required = false) String orderByOne,
            @RequestParam(value = "orderByTwo", required = false) String orderByTwo,
            @RequestParam(value = "orderByThree", required = false) String orderByThree
    ) throws IOException {
        PageInfo res = insuranceOrderService.getAll();
        String[] rowsName = new String[]{"ID", "套餐名称", "承保人", "适用行业", "是否过期",
                "到期时间", "创建时间"};
        return getReturnFile(ExportPrintUtils.createInsuranceOrderExcel("订单列表", rowsName, res.getList()), "订单列表.xls");
    }

    @RequestMapping("/setNotActive")
    @ResponseBody
    public Boolean setNotActive(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        /*设置响应头允许ajax跨域访问*/
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* 星号表示所有的异域请求都可以接受， */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        //获取微信小程序get的参数值并打印
        String orderId = request.getParameter("orderId");
        InsuranceOrder curOrder = new InsuranceOrder();
        curOrder.setId(Integer.parseInt(orderId));
        curOrder.setIsActive(false);
        return insuranceOrderService.updateById(curOrder);
    }

}