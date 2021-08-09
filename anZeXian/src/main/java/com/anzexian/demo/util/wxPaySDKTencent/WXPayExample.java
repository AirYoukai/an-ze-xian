package com.anzexian.demo.util.wxPaySDKTencent;

import java.util.HashMap;
import java.util.Map;

public class WXPayExample {
    public static void main(String[] args) throws Exception {
        MyConfig config = new MyConfig();
        WXPay wxpay = new WXPay(config);
        Map<String, String> data = new HashMap<String, String>();
        data.put("out_trade_no", "LNGNnyyKLtVa6I9ykUUksriyooMT0FpL");
        try {
            Map<String, String> resp = wxpay.orderQuery(data);
            System.out.println(resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Map<String, String> queryOrder(String outTradeNo) throws Exception {
        MyConfig config = new MyConfig();
        WXPay wxpay = new WXPay(config);
        Map<String, String> data = new HashMap<String, String>();
        data.put("out_trade_no", outTradeNo);
        Map<String, String> resp = new HashMap<>();
        try {
            resp = wxpay.orderQuery(data);
//            System.out.println(resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

//    public static void main(String[] args) throws Exception {
//        MyConfig config = new MyConfig();
//        WXPay wxpay = new WXPay(config);
//        Map<String, String> data = new HashMap<String, String>();
//        data.put("body", "腾讯充值中心-QQ会员充值");
//        data.put("out_trade_no", "2016090910595580000012");
//        data.put("device_info", "");
//        data.put("fee_type", "CNY");
//        data.put("total_fee", "1");
//        data.put("spbill_create_ip", "123.12.12.123");
//        data.put("notify_url", "http://www.example.com/wxpay/notify");
//        data.put("trade_type", "NATIVE");  // 此处指定为扫码支付
//        data.put("product_id", "12");
//        try {
//            Map<String, String> resp = wxpay.unifiedOrder(data);
//            System.out.println(resp);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
