package com.anzexian.demo.entity.extend;

//import com.anzexian.demo.entity.InsuranceApplicant;
//import com.anzexian.demo.entity.InsuranceInsured;
import com.anzexian.demo.entity.InsuranceService;
import com.anzexian.demo.entity.InsuranceWxpay;
import com.anzexian.demo.entity.UserManage;

import java.util.List;

public class InsuranceOrderExtend {
//    private InsuranceApplicant insuranceApplicant;//通过外键查询到的InsuranceApplicant
//    private InsuranceInsured insuranceInsured;//通过外键查询到的InsuranceInsured
    private InsuranceService insuranceService;//通过外键查询到的InsuranceService
    private InsuranceWxpay insuranceWxpay;//通过外键查询到的InsuranceWxpay
    private UserManage userManage;
    private String createTimeFrom;
    private String createTimeTo;
    private String expireTimeFrom;
    private String expireTimeTo;
    private String orderByOne;
    private String orderByTwo;
    private String orderByThree;
//    private List<Integer> serviceIdByCompanyId;
//    private List<Integer> serviceIdByIndustry;
    private int companyId;//查询用
    private String industry;//查询用
    private String serviceName;//查询用

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }


    public UserManage getUserManage() {
        return userManage;
    }

    public void setUserManage(UserManage userManage) {
        this.userManage = userManage;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }


//    public List<Integer> getServiceIdByCompanyId() {
//        return serviceIdByCompanyId;
//    }
//
//    public void setServiceIdByCompanyId(List<Integer> serviceIdByCompanyId) {
//        this.serviceIdByCompanyId = serviceIdByCompanyId;
//    }
//
//    public List<Integer> getServiceIdByIndustry() {
//        return serviceIdByIndustry;
//    }
//
//    public void setServiceIdByIndustry(List<Integer> serviceIdByIndustry) {
//        this.serviceIdByIndustry = serviceIdByIndustry;
//    }

    public String getExpireTimeFrom() {
        return expireTimeFrom;
    }

    public void setExpireTimeFrom(String expireTimeFrom) {
        this.expireTimeFrom = expireTimeFrom;
    }

    public String getExpireTimeTo() {
        return expireTimeTo;
    }

    public void setExpireTimeTo(String expireTimeTo) {
        this.expireTimeTo = expireTimeTo;
    }

    public String getOrderByOne() {
        return orderByOne;
    }

    public void setOrderByOne(String orderByOne) {
        this.orderByOne = orderByOne;
    }

    public String getOrderByTwo() {
        return orderByTwo;
    }

    public void setOrderByTwo(String orderByTwo) {
        this.orderByTwo = orderByTwo;
    }

    public String getOrderByThree() {
        return orderByThree;
    }

    public void setOrderByThree(String orderByThree) {
        this.orderByThree = orderByThree;
    }


    public String getCreateTimeFrom() {
        return createTimeFrom;
    }

    public void setCreateTimeFrom(String createCreateTimeFrom) {
        this.createTimeFrom = createCreateTimeFrom;
    }

    public String getCreateTimeTo() {
        return createTimeTo;
    }

    public void setCreateTimeTo(String createCreateTimeTo) {
        this.createTimeTo = createCreateTimeTo;
    }

    public InsuranceService getInsuranceService() {
        return insuranceService;
    }

    public void setInsuranceService(InsuranceService insuranceService) {
        this.insuranceService = insuranceService;
    }

    public InsuranceWxpay getInsuranceWxpay() {
        return insuranceWxpay;
    }

    public void setInsuranceWxpay(InsuranceWxpay insuranceWxpay) {
        this.insuranceWxpay = insuranceWxpay;
    }
}
