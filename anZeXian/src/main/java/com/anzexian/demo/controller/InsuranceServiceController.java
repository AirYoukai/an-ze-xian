package com.anzexian.demo.controller;

import com.anzexian.demo.entity.InsuranceCompany;
import com.anzexian.demo.entity.InsuranceService;
import com.anzexian.demo.service.InsuranceCompanyService;
import com.anzexian.demo.service.InsuranceServiceService;
import com.anzexian.demo.util.ExportPrintUtils;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.anzexian.demo.util.ExportPrintUtils.getReturnFile;

@Controller
@RequestMapping("/insuranceService")
public class InsuranceServiceController {
    @Autowired
    private InsuranceServiceService insuranceServiceService;
    @Autowired
    private InsuranceCompanyService insuranceCompanyService;

    @RequestMapping("/toServiceList")
    public String toServiceList() {
        return "insurance/service_list";
    }

    @RequestMapping("/getAll")
    @ResponseBody
    public List<InsuranceService> getAll(
    ) {
        List<InsuranceService> insuranceServiceList = new ArrayList<>();
        insuranceServiceList=insuranceServiceService.getAll().getList();
        return insuranceServiceList;
    }

    @RequestMapping("/getAllCompany")
    @ResponseBody
    public List<InsuranceCompany> getAllCompany() {
        List<InsuranceCompany> allCompanyList = new ArrayList<>();
        try {
            allCompanyList=insuranceCompanyService.getAllCompany();
        }catch (Exception e){
            e.printStackTrace();
        }
        return allCompanyList;
    }

    @RequestMapping("/selectLike")
    @ResponseBody
    public PageInfo selectLike(
            @RequestParam(value = "pageSize", required = false) String pageSize,
            @RequestParam(value = "pageNum", required = false) String pageNum,
            @RequestParam(value = "serviceName", required = false) String serviceName,
            @RequestParam(value = "servicePremium", required = false) String servicePremium,
            @RequestParam(value = "servicePrice", required = false) String servicePrice,
            @RequestParam(value = "serviceDuration", required = false) String serviceDuration,
            @RequestParam(value = "industry", required = false) String industry,
            @RequestParam(value = "contactName", required = false) String contactName,
            @RequestParam(value = "claimMethod", required = false) String claimMethod,
            @RequestParam(value = "timeFrom", required = false) String timeFrom,
            @RequestParam(value = "timeTo", required = false) String timeTo,
            @RequestParam(value = "orderByOne", required = false) String orderByOne,
            @RequestParam(value = "orderByTwo", required = false) String orderByTwo,
            @RequestParam(value = "orderByThree", required = false) String orderByThree
    ) {
        InsuranceService insuranceService = new InsuranceService();
        try {
            insuranceService.setServiceName(serviceName);
            if (servicePremium != null && !"".equals(servicePremium))
                insuranceService.setServicePremium(Integer.parseInt(servicePremium));
            if (servicePrice != null && !"".equals(servicePrice))
                insuranceService.setServicePrice(Integer.parseInt(servicePrice));
            if (serviceDuration != null && !"".equals(serviceDuration))
                insuranceService.setServiceDuration(Integer.parseInt(serviceDuration));

            if (industry != null && !"".equals(industry))
                insuranceService.setIndustry(industry);
            if (contactName != null && !"".equals(contactName))
                insuranceService.setContactName(contactName);
            if (claimMethod != null && !"".equals(claimMethod))
                insuranceService.setClaimMethod(claimMethod);
            if (timeFrom != null && !"".equals(timeFrom))
                insuranceService.setCreateTimeFrom(timeFrom + " 00:00:00");
            if (timeTo != null && !"".equals(timeTo))
                insuranceService.setCreateTimeTo(timeTo + " 00:00:00");

            insuranceService.setOrderByOne(orderByOne);
            insuranceService.setOrderByTwo(orderByTwo);
            insuranceService.setOrderByThree(orderByThree);
        } catch (NullPointerException e) {
            System.out.println("Null pointer in selectLike in Service controller");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("NumberFormat problem in selectLike in Service controller");
            e.printStackTrace();
        }
        PageInfo res = insuranceServiceService.selectLike(insuranceService, pageNum, pageSize);
        return res;
    }



    @RequestMapping("/selectById")
    @ResponseBody
    public InsuranceService selectById(@RequestParam(value = "id") String id) {
        return insuranceServiceService.selectById(id);
    }

//    @RequestMapping("/deleteById")
//    @ResponseBody
//    public String deleteById(@RequestParam(value = "id") String id) {
//        return insuranceServiceService.deleteById(id) + "";
//    }


    @RequestMapping("/addData")
    @ResponseBody
    public Boolean addData(
                              @RequestParam(value = "serviceName", required = false) String serviceName,
                              @RequestParam(value = "servicePremium", required = false) String servicePremium,
                              @RequestParam(value = "servicePrice", required = false) String servicePrice,
                              @RequestParam(value = "serviceDuration", required = false) String serviceDuration,
                              @RequestParam(value = "industry", required = false) String industry,
                              @RequestParam(value = "contactName", required = false) String contactName,
                              @RequestParam(value = "claimMethod", required = false) String claimMethod,
                                 @RequestParam(value = "companyName", required = false) String companyName

    ) {
        InsuranceService insuranceService = new InsuranceService();
        try {
            insuranceService.setServiceName(serviceName);
            if (servicePremium != null && !"".equals(servicePremium))
                insuranceService.setServicePremium(Integer.parseInt(servicePremium));
            if (servicePrice != null && !"".equals(servicePrice))
                insuranceService.setServicePrice(Integer.parseInt(servicePrice));
            if (serviceDuration != null && !"".equals(serviceDuration))
                insuranceService.setServiceDuration(Integer.parseInt(serviceDuration));
            if (industry != null && !"".equals(industry))
                insuranceService.setIndustry(industry);
            if (contactName != null && !"".equals(contactName))
                insuranceService.setContactName(contactName);
            if (claimMethod != null && !"".equals(claimMethod))
                insuranceService.setClaimMethod(claimMethod);
            insuranceService.setCreateTime(LocalDateTime.now());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        try {
            int companyId=insuranceCompanyService.getCompanyId(companyName);
            if(companyId==-1){
                companyId=insuranceCompanyService.insertNewCompany(companyName);
            }
            insuranceService.setCompanyId(companyId);
        }catch (NullPointerException e){
            e.printStackTrace();
        }
        return insuranceServiceService.insert(insuranceService);
    }

    @RequestMapping("/updateAjax")
    @ResponseBody
    public Boolean updateAjax(@RequestParam(value = "id", required = false) String id,
                              @RequestParam(value = "serviceName", required = false) String serviceName,
                              @RequestParam(value = "servicePremium", required = false) String servicePremium,
                              @RequestParam(value = "servicePrice", required = false) String servicePrice,
                              @RequestParam(value = "serviceDuration", required = false) String serviceDuration,
                              @RequestParam(value = "industry", required = false) String industry,
                              @RequestParam(value = "contactName", required = false) String contactName,
                              @RequestParam(value = "claimMethod", required = false) String claimMethod
    ) {
        InsuranceService insuranceService = new InsuranceService();
        try {
            insuranceService.setId(Integer.parseInt(id));
            insuranceService.setServiceName(serviceName);
            if (servicePremium != null && !"".equals(servicePremium))
                insuranceService.setServicePremium(Integer.parseInt(servicePremium));
            if (servicePrice != null && !"".equals(servicePrice))
                insuranceService.setServicePrice(Integer.parseInt(servicePrice));
            if (serviceDuration != null && !"".equals(serviceDuration))
                insuranceService.setServiceDuration(Integer.parseInt(serviceDuration));
            if (industry != null && !"".equals(industry))
                insuranceService.setIndustry(industry);
            if (contactName != null && !"".equals(contactName))
                insuranceService.setContactName(contactName);
            if (claimMethod != null && !"".equals(claimMethod))
                insuranceService.setClaimMethod(claimMethod);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return insuranceServiceService.updateById(insuranceService);
    }

    @RequestMapping("/exportData")
    public ResponseEntity<byte[]> exportData(
            @RequestParam(value = "serviceName", required = false) String serviceName,
            @RequestParam(value = "servicePremium", required = false) String servicePremium,
            @RequestParam(value = "servicePrice", required = false) String servicePrice,
            @RequestParam(value = "serviceDuration", required = false) String serviceDuration,
            @RequestParam(value = "industry", required = false) String industry,
            @RequestParam(value = "contactName", required = false) String contactName,
            @RequestParam(value = "claimMethod", required = false) String claimMethod,

            @RequestParam(value = "pageSize", required = false) String pageSize,
            @RequestParam(value = "pageNum", required = false) String pageNum,
            @RequestParam(value = "timeFrom", required = false) String timeFrom,
            @RequestParam(value = "timeTo", required = false) String timeTo,
            @RequestParam(value = "orderByOne", required = false) String orderByOne,
            @RequestParam(value = "orderByTwo", required = false) String orderByTwo,
            @RequestParam(value = "orderByThree", required = false) String orderByThree
    ) throws IOException {
//        PageInfo res = insuranceServiceService.selectLike(insuranceService, pageNum, pageSize);
        PageInfo res = insuranceServiceService.getAll();
        String[] rowsName = new String[]{"ID", "套餐名称", "保险金额（元）", "购买价格（元）", "生效时长（月）"
                ,"适用行业","联系人","理赔方式",
                "创建时间"};
        return getReturnFile(ExportPrintUtils.createInsuranceServiceExcel("套餐列表", rowsName, res.getList()), "套餐列表.xls");
    }

    @RequestMapping("/deleteById")
    @ResponseBody
    public Boolean deleteById(@RequestParam(value = "id") String id) {
        return insuranceServiceService.deleteById(id);
    }

}
