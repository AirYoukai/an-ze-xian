package com.anzexian.demo.entity.extend;

import com.anzexian.demo.entity.InsuranceOrder;
import com.anzexian.demo.entity.InsuranceWxpay;
import com.anzexian.demo.entity.UserManage;

import java.util.List;

public class InsuranceClaimExtend {
    private String createTimeFrom;
    private String createTimeTo;
    private String orderByOne;
    private String orderByTwo;
    private String orderByThree;
    private List<Integer> curPosList;

    InsuranceWxpay insuranceWxpayPayback;
    InsuranceOrder insuranceOrder;
    UserManage userManageReviewStaff;
    UserManage userManageReviewManager;
    UserManage userManagePayer;
    UserManage userManageClaimant;

    public InsuranceWxpay getInsuranceWxpayPayback() {
        return insuranceWxpayPayback;
    }

    public void setInsuranceWxpayPayback(InsuranceWxpay insuranceWxpayPayback) {
        this.insuranceWxpayPayback = insuranceWxpayPayback;
    }

    public InsuranceOrder getInsuranceOrder() {
        return insuranceOrder;
    }

    public void setInsuranceOrder(InsuranceOrder insuranceOrder) {
        this.insuranceOrder = insuranceOrder;
    }

    public UserManage getUserManageReviewStaff() {
        return userManageReviewStaff;
    }

    public void setUserManageReviewStaff(UserManage userManageReviewStaff) {
        this.userManageReviewStaff = userManageReviewStaff;
    }

    public UserManage getUserManageReviewManager() {
        return userManageReviewManager;
    }

    public void setUserManageReviewManager(UserManage userManageReviewManager) {
        this.userManageReviewManager = userManageReviewManager;
    }

    public UserManage getUserManagePayer() {
        return userManagePayer;
    }

    public void setUserManagePayer(UserManage userManagePayer) {
        this.userManagePayer = userManagePayer;
    }

    public UserManage getUserManageClaimant() {
        return userManageClaimant;
    }

    public void setUserManageClaimant(UserManage userManageClaimant) {
        this.userManageClaimant = userManageClaimant;
    }

    public List<Integer> getCurPosList() {
        return curPosList;
    }

    public void setCurPosList(List<Integer> curPosList) {
        this.curPosList = curPosList;
    }

    public String getCreateTimeFrom() {
        return createTimeFrom;
    }

    public void setCreateTimeFrom(String createTimeFrom) {
        this.createTimeFrom = createTimeFrom;
    }

    public String getCreateTimeTo() {
        return createTimeTo;
    }

    public void setCreateTimeTo(String createTimeTo) {
        this.createTimeTo = createTimeTo;
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
}
