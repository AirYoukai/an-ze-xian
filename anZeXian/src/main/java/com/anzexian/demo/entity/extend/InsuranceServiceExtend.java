package com.anzexian.demo.entity.extend;

import com.anzexian.demo.entity.InsuranceCompany;

public class InsuranceServiceExtend {
    private InsuranceCompany insuranceCompany;
    private String createTimeFrom;
    private String createTimeTo;
    private String orderByOne;
    private String orderByTwo;
    private String orderByThree;

    public InsuranceCompany getInsuranceCompany() {
        return insuranceCompany;
    }

    public void setInsuranceCompany(InsuranceCompany insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
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
}
