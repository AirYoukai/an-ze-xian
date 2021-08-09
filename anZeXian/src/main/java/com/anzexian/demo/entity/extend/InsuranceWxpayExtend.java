package com.anzexian.demo.entity.extend;

import java.time.LocalDateTime;

public class InsuranceWxpayExtend {
    private String createTimeFrom;
    private String createTimeTo;
    private String unifiedorderTimeFrom;
    private String unifiedorderTimeTo;
    private String payTimeFrom;
    private String payTimeTo;

    private String orderByOne;
    private String orderByTwo;
    private String orderByThree;
    public String getUnifiedorderTimeFrom() {
        return unifiedorderTimeFrom;
    }

    public void setUnifiedorderTimeFrom(String unifiedorderTimeFrom) {
        this.unifiedorderTimeFrom = unifiedorderTimeFrom;
    }

    public String getUnifiedorderTimeTo() {
        return unifiedorderTimeTo;
    }

    public void setUnifiedorderTimeTo(String unifiedorderTimeTo) {
        this.unifiedorderTimeTo = unifiedorderTimeTo;
    }

    public String getPayTimeFrom() {
        return payTimeFrom;
    }

    public void setPayTimeFrom(String payTimeFrom) {
        this.payTimeFrom = payTimeFrom;
    }

    public String getPayTimeTo() {
        return payTimeTo;
    }

    public void setPayTimeTo(String payTimeTo) {
        this.payTimeTo = payTimeTo;
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
