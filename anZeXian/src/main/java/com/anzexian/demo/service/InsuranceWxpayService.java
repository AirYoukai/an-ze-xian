package com.anzexian.demo.service;

import com.anzexian.demo.entity.InsuranceWxpay;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface InsuranceWxpayService {
    PageInfo getALl();
    PageInfo list(String pageNum, String pageSize);
    PageInfo selectLike(InsuranceWxpay insuranceWxpay, String pageNum, String pageSize);
//    boolean updateById(InsuranceWxpay insuranceWxpay);
//    boolean deleteById(String id);
    InsuranceWxpay selectById(String id);
    int insertAtUnifiedorder(InsuranceWxpay insuranceWxpay);
    void setAfterPaySucceed(InsuranceWxpay insuranceWxpay);

    Boolean updateById(InsuranceWxpay insuranceWxpay);

    void checkPaySucceed();

    List<InsuranceWxpay> getOrderWaiting(String opneId) ;

//    void checkPaySucceed();
//    void insertLotsOfData();
}
