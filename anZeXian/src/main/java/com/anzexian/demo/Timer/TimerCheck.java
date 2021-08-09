package com.anzexian.demo.Timer;

import com.anzexian.demo.service.InsuranceClaimService;
import com.anzexian.demo.service.InsuranceWxpayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@EnableScheduling
@Component
public class TimerCheck {
    @Autowired
    InsuranceWxpayService insuranceWxpayService;
    @Autowired
    InsuranceClaimService insuranceClaimService;

    @Scheduled(fixedRate =5*60*1000)
    public void checkStatus(){
        insuranceWxpayService.checkPaySucceed();
    }
}
