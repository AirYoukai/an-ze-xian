package com.anzexian.demo.util;

public class WaterMark {
    private Long timestamp;// 时间戳做转换的时候，记得先乘以1000，再通过simpledateformat完成date类型转换
    private String appid;

    @Override
    public String toString() {
        return "WaterMark{" +
                "timestamp=" + timestamp +
                ", appid='" + appid + '\'' +
                '}';
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public WaterMark(Long timestamp, String appid) {
        this.timestamp = timestamp;
        this.appid = appid;
    }

    public WaterMark() {
    }
}
