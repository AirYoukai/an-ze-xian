package com.anzexian.demo.util;

import java.util.Random;

public interface Constant {
    Integer USER_ROLE_COMMON_CLIENT=3;//普通客户
    Integer USER_ROLE_CLIENT=2;//会员客户
    Integer USER_ROLE_STAFF=1;//员工
    Integer USER_ROLE_BOSS=0;//老板
    Integer USER_ROLE_MANAGER=-1;//系统管理员
    Integer CUR_POS_CLIENT_RES=3;//用户收到结果
    Integer CUR_POS_STAFF_PAYBACK=2;//等待员工赔款
    Integer CUR_POS_MANAGER_REVIEW=1;//等待老板审核
    Integer CUR_POS_STAFF_REVIEW=0;//等待员工审核
    String TO_CREATE_OUT_TRADE_NO="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_-*";
    String APP_ID="wxe665f52060db5e0b";
    String MCH_ID="1316186701";
    String MINIPRO_SECRET_KEY="4b8d819cbfa15deb3e69f1c056c45c19";//小程序的key
    String WXPAY_KEY="ylxpay20210406000000000000000000";
    String STATUS_WAITING="WAITING";
    String STATUS_DENIED="DENIED";
    String STATUS_AGREED="AGREED";
    String STATUS_PAYEDBACK="PAYEDBACK";

    public static String getRandomString(String originStr,int length) {
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(originStr.length());
            sb.append(originStr.charAt(number));
        }
        return sb.toString();
    }
}
