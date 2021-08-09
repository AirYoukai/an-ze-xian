package com.anzexian.demo.entity;

import com.anzexian.demo.entity.extend.InsuranceClaimExtend;

import java.time.LocalDateTime;

public class InsuranceClaim extends InsuranceClaimExtend {
    private Integer id;

    private String statusManager;

    private String statusStaff;

    private Integer wxpayId;

    private Integer claimantId;

    private Integer payerId;

    private Integer reviewManagerId;

    private Integer reviewStaffId;

    private Integer orderId;

    private String proofFilePath;

    private Integer curPos;

    private LocalDateTime reviewManagerTime;

    private LocalDateTime reviewStaffTime;

    private LocalDateTime paybackTime;

    private Boolean isDeleted;

    private LocalDateTime createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatusManager() {
        return statusManager;
    }

    public void setStatusManager(String statusManager) {
        this.statusManager = statusManager == null ? null : statusManager.trim();
    }

    public String getStatusStaff() {
        return statusStaff;
    }

    public void setStatusStaff(String statusStaff) {
        this.statusStaff = statusStaff == null ? null : statusStaff.trim();
    }

    public Integer getWxpayId() {
        return wxpayId;
    }

    public void setWxpayId(Integer wxpayId) {
        this.wxpayId = wxpayId;
    }

    public Integer getClaimantId() {
        return claimantId;
    }

    public void setClaimantId(Integer claimantId) {
        this.claimantId = claimantId;
    }

    public Integer getPayerId() {
        return payerId;
    }

    public void setPayerId(Integer payerId) {
        this.payerId = payerId;
    }

    public Integer getReviewManagerId() {
        return reviewManagerId;
    }

    public void setReviewManagerId(Integer reviewManagerId) {
        this.reviewManagerId = reviewManagerId;
    }

    public Integer getReviewStaffId() {
        return reviewStaffId;
    }

    public void setReviewStaffId(Integer reviewStaffId) {
        this.reviewStaffId = reviewStaffId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getProofFilePath() {
        return proofFilePath;
    }

    public void setProofFilePath(String proofFilePath) {
        this.proofFilePath = proofFilePath == null ? null : proofFilePath.trim();
    }

    public Integer getCurPos() {
        return curPos;
    }

    public void setCurPos(Integer curPos) {
        this.curPos = curPos;
    }

    public LocalDateTime getReviewManagerTime() {
        return reviewManagerTime;
    }

    public void setReviewManagerTime(LocalDateTime reviewManagerTime) {
        this.reviewManagerTime = reviewManagerTime;
    }

    public LocalDateTime getReviewStaffTime() {
        return reviewStaffTime;
    }

    public void setReviewStaffTime(LocalDateTime reviewStaffTime) {
        this.reviewStaffTime = reviewStaffTime;
    }

    public LocalDateTime getPaybackTime() {
        return paybackTime;
    }

    public void setPaybackTime(LocalDateTime paybackTime) {
        this.paybackTime = paybackTime;
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