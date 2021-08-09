package com.anzexian.demo.util;

public class WeixinPhoneDecryptInfo {

    private String phoneNumber;
    private String purePhoneNumber;
    private int countryCode;
    private String weixinWaterMark;
    private WaterMark watermark;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPurePhoneNumber() {
        return purePhoneNumber;
    }

    public void setPurePhoneNumber(String purePhoneNumber) {
        this.purePhoneNumber = purePhoneNumber;
    }

    public int getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(int countryCode) {
        this.countryCode = countryCode;
    }

    public String getWeixinWaterMark() {
        return weixinWaterMark;
    }

    public void setWeixinWaterMark(String weixinWaterMark) {
        this.weixinWaterMark = weixinWaterMark;
    }

    public WaterMark getWatermark() {
        return watermark;
    }

    public void setWatermark(WaterMark watermark) {
        this.watermark = watermark;
    }

    public WeixinPhoneDecryptInfo(String phoneNumber, String purePhoneNumber, int countryCode, String weixinWaterMark, WaterMark watermark) {
        this.phoneNumber = phoneNumber;
        this.purePhoneNumber = purePhoneNumber;
        this.countryCode = countryCode;
        this.weixinWaterMark = weixinWaterMark;
        this.watermark = watermark;
    }

    public WeixinPhoneDecryptInfo() {
    }

    @Override
    public String toString() {
        return "WeixinPhoneDecryptInfo{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", purePhoneNumber='" + purePhoneNumber + '\'' +
                ", countryCode=" + countryCode +
                ", weixinWaterMark='" + weixinWaterMark + '\'' +
                ", watermark=" + watermark +
                '}';
    }
}
