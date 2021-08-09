package com.anzexian.demo.entity;

import com.anzexian.demo.entity.extend.InsuranceServiceExtend;

import java.time.LocalDateTime;

public class InsuranceService extends InsuranceServiceExtend {
    private Integer id;

    private String serviceName;

    private Integer servicePremium;

    private Integer servicePrice;

    private Integer companyId;

    private Integer serviceDuration;

    private String claimMethod;

    private String industry;

    private String contactPhone;

    private String contactName;

    private Boolean isDeleted;

    private LocalDateTime createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName == null ? null : serviceName.trim();
    }

    public Integer getServicePremium() {
        return servicePremium;
    }

    public void setServicePremium(Integer servicePremium) {
        this.servicePremium = servicePremium;
    }

    public Integer getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(Integer servicePrice) {
        this.servicePrice = servicePrice;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getServiceDuration() {
        return serviceDuration;
    }

    public void setServiceDuration(Integer serviceDuration) {
        this.serviceDuration = serviceDuration;
    }

    public String getClaimMethod() {
        return claimMethod;
    }

    public void setClaimMethod(String claimMethod) {
        this.claimMethod = claimMethod == null ? null : claimMethod.trim();
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry == null ? null : industry.trim();
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone == null ? null : contactPhone.trim();
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName == null ? null : contactName.trim();
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
}