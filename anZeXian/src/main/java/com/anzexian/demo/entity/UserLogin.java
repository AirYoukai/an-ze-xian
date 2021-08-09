package com.anzexian.demo.entity;

import java.time.LocalDateTime;

public class UserLogin {
    private Integer id;

    private Boolean isDeleted;

    private LocalDateTime createTime;

    private String loginCode;

    private Integer scannerId;

    private Boolean haslogin;

    private Boolean isScanned;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getLoginCode() {
        return loginCode;
    }

    public void setLoginCode(String loginCode) {
        this.loginCode = loginCode == null ? null : loginCode.trim();
    }

    public Integer getScannerId() {
        return scannerId;
    }

    public void setScannerId(Integer scannerId) {
        this.scannerId = scannerId;
    }

    public Boolean getHaslogin() {
        return haslogin;
    }

    public void setHaslogin(Boolean haslogin) {
        this.haslogin = haslogin;
    }

    public Boolean getIsScanned() {
        return isScanned;
    }

    public void setIsScanned(Boolean isScanned) {
        this.isScanned = isScanned;
    }
}