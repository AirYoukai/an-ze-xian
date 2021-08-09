package com.anzexian.demo.entity;

import com.anzexian.demo.entity.extend.InsuranceOrderExtend;

import java.time.LocalDateTime;

public class InsuranceOrder extends InsuranceOrderExtend {
    private Integer id;

    private Integer applicantId;

    private Integer insuredId;

    private Integer serviceId;

    private Integer wxpayId;

    private Integer buyerId;

    private Boolean isActive;

    private Boolean isDeleted;

    private LocalDateTime createTime;

    private LocalDateTime expireTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(Integer applicantId) {
        this.applicantId = applicantId;
    }

    public Integer getInsuredId() {
        return insuredId;
    }

    public void setInsuredId(Integer insuredId) {
        this.insuredId = insuredId;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public Integer getWxpayId() {
        return wxpayId;
    }

    public void setWxpayId(Integer wxpayId) {
        this.wxpayId = wxpayId;
    }

    public Integer getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Integer buyerId) {
        this.buyerId = buyerId;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(LocalDateTime expireTime) {
        this.expireTime = expireTime;
    }
}