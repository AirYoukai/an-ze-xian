package com.anzexian.demo.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

public class TimmerTest extends TimerTask {

    public void run() {
        Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        System.out.println(sdf.format(new Date())+",执行定时任务");
    }
}
