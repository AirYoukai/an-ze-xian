package com.anzexian.demo.controller;


import com.anzexian.demo.entity.InsuranceOrder;
import com.anzexian.demo.entity.InsuranceService;
import com.anzexian.demo.entity.InsuranceWxpay;
import com.anzexian.demo.entity.UserManage;
import com.anzexian.demo.service.InsuranceOrderService;
import com.anzexian.demo.service.InsuranceServiceService;
import com.anzexian.demo.service.InsuranceWxpayService;
import com.anzexian.demo.service.UserManageService;
import com.anzexian.demo.util.ExportPrintUtils;
import com.anzexian.demo.util.wxPaySDKTencent.MyConfig;
import com.anzexian.demo.util.wxPaySDKTencent.WXPay;
import com.anzexian.demo.util.wxPaySDKTencent.WXPayUtil;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.util.*;

import static com.anzexian.demo.util.Constant.*;
import static com.anzexian.demo.util.ExportPrintUtils.getReturnFile;
import static com.anzexian.demo.util.wxPaySDKTencent.WXPayConstants.FAIL;

@Controller
@RequestMapping("/insuranceWxpay")
public class InsuranceWxpayController {
    @Autowired
    private InsuranceWxpayService insuranceWxpayService;
    @Autowired
    private InsuranceOrderService insuranceOrderService;
    //    @Autowired
//    private InsuranceApplicantService insuranceApplicantService;
//    @Autowired
//    private InsuranceInsuredService insuranceInsuredService;
    @Autowired
    private InsuranceServiceService insuranceServiceService;
    @Autowired
    private UserManageService userManageService;

    @RequestMapping("/toWxpayList")
    public String toWxpayList() {
        return "insurance/wxpay_list";
    }

    @RequestMapping("/selectLike")
    @ResponseBody
    public PageInfo selectLike(
            @RequestParam(value = "pageSize", required = false) String pageSize,
            @RequestParam(value = "pageNum", required = false) String pageNum,
            @RequestParam(value = "openId", required = false) String openId,
            @RequestParam(value = "appId", required = false) String appId,
            @RequestParam(value = "mchId", required = false) String mchId,
            @RequestParam(value = "nonceStr", required = false) String nonceStr,
            @RequestParam(value = "body", required = false) String body,
            @RequestParam(value = "outTradeNo", required = false) String outTradeNo,
            @RequestParam(value = "totalFee", required = false) String totalFee,
            @RequestParam(value = "spbillCreateIp", required = false) String spbillCreateIp,
            @RequestParam(value = "notifyUrl", required = false) String notifyUrl,
            @RequestParam(value = "tradeType", required = false) String tradeType,
            @RequestParam(value = "returnCode", required = false) String returnCode,
            @RequestParam(value = "resultCode", required = false) String resultCode,
            @RequestParam(value = "prepayId", required = false) String prepayId,
            @RequestParam(value = "signType", required = false) String signType,
            @RequestParam(value = "timeStamp", required = false) String timeStamp,
            @RequestParam(value = "paySign", required = false) String paySign,
//            @RequestParam(value = "unifiedorderSucceed", required = false) String unifiedorderSucceed,
//            @RequestParam(value = "paySucceed", required = false) String paySucceed,

            @RequestParam(value = "createTimeFrom", required = false) String createTimeFrom,
            @RequestParam(value = "createTimeTo", required = false) String createTimeTo,
            @RequestParam(value = "payTimeFrom", required = false) String payTimeFrom,
            @RequestParam(value = "payTimeTo", required = false) String payTimeTo,
            @RequestParam(value = "unifiedorderTimeFrom", required = false) String unifiedorderTimeFrom,
            @RequestParam(value = "unifiedorderTimeTo", required = false) String unifiedorderTimeTo,
            @RequestParam(value = "orderByOne", required = false) String orderByOne,
            @RequestParam(value = "orderByTwo", required = false) String orderByTwo,
            @RequestParam(value = "orderByThree", required = false) String orderByThree
    ) {
        InsuranceWxpay insuranceWxpay = new InsuranceWxpay();
        try {
            insuranceWxpay.setOpenId(openId);
            insuranceWxpay.setAppId(appId);
            insuranceWxpay.setMchId(mchId);
            insuranceWxpay.setNonceStr(nonceStr);
            insuranceWxpay.setBody(body);
            insuranceWxpay.setOutTradeNo(outTradeNo);
            insuranceWxpay.setTotalFee(totalFee);
            insuranceWxpay.setSpbillCreateIp(spbillCreateIp);
            insuranceWxpay.setNotifyUrl(notifyUrl);
            insuranceWxpay.setTradeType(tradeType);
            insuranceWxpay.setReturnCode(returnCode);
            insuranceWxpay.setResultCode(resultCode);
            insuranceWxpay.setPrepayId(prepayId);
            insuranceWxpay.setSignType(signType);
            insuranceWxpay.setTimeStamp(timeStamp);
            insuranceWxpay.setPaySign(paySign);

            if (payTimeFrom != null && !"".equals(payTimeFrom))
                insuranceWxpay.setPayTimeFrom(payTimeFrom + " 00:00:00");
            if (payTimeTo != null && !"".equals(payTimeTo))
                insuranceWxpay.setPayTimeTo(payTimeTo + " 00:00:00");

            if (unifiedorderTimeFrom != null && !"".equals(unifiedorderTimeFrom))
                insuranceWxpay.setUnifiedorderTimeFrom(unifiedorderTimeFrom + " 00:00:00");
            if (unifiedorderTimeTo != null && !"".equals(unifiedorderTimeTo))
                insuranceWxpay.setUnifiedorderTimeTo(unifiedorderTimeTo + " 00:00:00");
            
            if (createTimeFrom != null && !"".equals(createTimeFrom))
                insuranceWxpay.setCreateTimeFrom(createTimeFrom + " 00:00:00");
            if (createTimeTo != null && !"".equals(createTimeTo))
                insuranceWxpay.setCreateTimeTo(createTimeTo + " 00:00:00");

            
            insuranceWxpay.setOrderByOne(orderByOne);
            insuranceWxpay.setOrderByTwo(orderByTwo);
            insuranceWxpay.setOrderByThree(orderByThree);
//            insuranceWxpay.setUnifiedorderSucceed(Boolean.valueOf(unifiedorderSucceed));
//            insuranceWxpay.setPaySucceed(Boolean.valueOf(paySucceed));
        } catch (NullPointerException e) {
            System.out.println("Null pointer in selectLike in Wxpay controller");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("NumberFormat problem in selectLike in Wxpay controller");
            e.printStackTrace();
        }
        PageInfo res = insuranceWxpayService.selectLike(insuranceWxpay, pageNum, pageSize);
        return res;
    }


    @RequestMapping("/selectById")
    @ResponseBody
    public InsuranceWxpay selectById(@RequestParam(value = "id") String id) {
        return insuranceWxpayService.selectById(id);
    }

//    @RequestMapping("/deleteById")
//    @ResponseBody
//    public String deleteById(@RequestParam(value = "id") String id) {
//        return insuranceWxpayService.deleteById(id) + "";
//    }

    @RequestMapping("/updateAjax")
    @ResponseBody
    public Boolean updateAjax(@RequestParam(value = "id", required = false) String id,
                              @RequestParam(value = "openId", required = false) String openId,
                              @RequestParam(value = "appId", required = false) String appId,
                              @RequestParam(value = "mchId", required = false) String mchId,
                              @RequestParam(value = "nonceStr", required = false) String nonceStr,
                              @RequestParam(value = "body", required = false) String body,
                              @RequestParam(value = "outTradeNo", required = false) String outTradeNo,
                              @RequestParam(value = "totalFee", required = false) String totalFee,
                              @RequestParam(value = "spbillCreateIp", required = false) String spbillCreateIp,
                              @RequestParam(value = "notifyUrl", required = false) String notifyUrl,
                              @RequestParam(value = "tradeType", required = false) String tradeType,
                              @RequestParam(value = "returnCode", required = false) String returnCode,
                              @RequestParam(value = "resultCode", required = false) String resultCode,
                              @RequestParam(value = "prepayId", required = false) String prepayId,
                              @RequestParam(value = "signType", required = false) String signType,
                              @RequestParam(value = "timeStamp", required = false) String timeStamp,
                              @RequestParam(value = "paySign", required = false) String paySign

//                              @RequestParam(value = "unifiedorderSucceed", required = false) String unifiedorderSucceed,
//                              @RequestParam(value = "paySucceed", required = false) String paySucceed,
    ) {
        InsuranceWxpay insuranceWxpay = new InsuranceWxpay();
        try {
            insuranceWxpay.setId(Integer.parseInt(id));
            insuranceWxpay.setOpenId("".equals(openId) ? null : openId);
            insuranceWxpay.setAppId("".equals(appId) ? null : appId);
            insuranceWxpay.setMchId("".equals(mchId) ? null : mchId);
            insuranceWxpay.setNonceStr("".equals(nonceStr) ? null : nonceStr);
            insuranceWxpay.setBody("".equals(body) ? null : body);
            insuranceWxpay.setOutTradeNo("".equals(outTradeNo) ? null : outTradeNo);
            insuranceWxpay.setTotalFee("".equals(totalFee) ? null : totalFee);
            insuranceWxpay.setSpbillCreateIp("".equals(spbillCreateIp) ? null : spbillCreateIp);
            insuranceWxpay.setNotifyUrl("".equals(notifyUrl) ? null : notifyUrl);
            insuranceWxpay.setTradeType("".equals(tradeType) ? null : tradeType);
            insuranceWxpay.setReturnCode("".equals(returnCode) ? null : returnCode);
            insuranceWxpay.setResultCode("".equals(resultCode) ? null : resultCode);
            insuranceWxpay.setPrepayId("".equals(prepayId) ? null : prepayId);
            insuranceWxpay.setSignType("".equals(signType) ? null : signType);
            insuranceWxpay.setTimeStamp("".equals(timeStamp) ? null : timeStamp);
            insuranceWxpay.setPaySign("".equals(paySign) ? null : paySign);

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return insuranceWxpayService.updateById(insuranceWxpay);
    }

    @RequestMapping("/exportData")
    public ResponseEntity<byte[]> exportData() throws IOException {
        PageInfo res = insuranceWxpayService.getALl();
        String[] rowsName = new String[]{"ID", "唯一用户标识", "公众账号ID", "商户号", "随机字符串",
                "商品描述", "商户订单号", "标价金额", "终端IP", "通知地址", "交易类型", "返回状态码",
                "返回信息", "预支付ID", "签名类型", "时间戳", "支付签名", "下单结果", "支付结果", " 下单时间",
                "支付时间", "创建时间"};
        return getReturnFile(ExportPrintUtils.createInsuranceWxpayExcel("支付列表", rowsName, res.getList()), "支付列表.xls");
    }

//////////////////////////////////////////////下面开始都是小程序//////////////////////////////////////

    @RequestMapping("/doUnifiedOrder")
    @ResponseBody
    public Map doUnifiedOrder(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        /*设置响应头允许ajax跨域访问*/
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* 星号表示所有的异域请求都可以接受， */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        //获取微信小程序传递的参数值
        String openId = request.getParameter("openId");
        String serviceId=request.getParameter("serviceId");

        System.out.println("doUnifiedOrder entered");
        InsuranceService insuranceService = new InsuranceService();
        //商品描述
        //支付金额，需要转成字符串类型，否则后面的签名会失败
        InsuranceService tmp = new InsuranceService();
        tmp=insuranceServiceService.selectById(serviceId);
        String total_fee=String.valueOf(tmp.getServicePrice());
        String body = tmp.getServiceName();
        try{
            insuranceService=insuranceServiceService.selectById(serviceId);
            body=insuranceService.getServiceName();
            total_fee=insuranceService.getServicePrice()+"";
        }catch (NullPointerException e){
            e.printStackTrace();
        }

        MyConfig config = null;
        WXPay wxpay = null;
        try {
            config = new MyConfig();
            wxpay = new WXPay(config);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //生成的随机字符串
        String nonce_str = WXPayUtil.generateNonceStr();
        //获取客户端的ip地址
        //获取本机的ip地址
        InetAddress addr = null;
        try {
            addr = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        String spbill_create_ip = addr.getHostAddress();
        //商户订单号
        String out_trade_no = WXPayUtil.generateNonceStr();
        //统一下单接口参数
        HashMap<String, String> data = new HashMap<String, String>();
        data.put("appid", APP_ID);
        data.put("mch_id", MCH_ID);
        data.put("nonce_str", nonce_str);
        data.put("body", body);
        data.put("out_trade_no", out_trade_no);
        data.put("total_fee", total_fee);
        data.put("spbill_create_ip", spbill_create_ip);
        data.put("notify_url", "https://mail.qq.com/cgi-bin/loginpage");
        data.put("trade_type", "JSAPI");
        data.put("openid", openId);
        InsuranceWxpay insuranceWxpay=setInsuranceWxpayParamBeforeOrder(new InsuranceWxpay(),data);
        Map resultMap = new HashMap();
        try {
            Map<String, String> rMap = wxpay.unifiedOrder(data);
            System.out.println("统一下单接口返回: " + rMap);
            String return_code = (String) rMap.get("return_code");
            String result_code = (String) rMap.get("result_code");
            insuranceWxpay.setUnifiedorderTime(LocalDateTime.now());//下单时间
            insuranceWxpay.setReturnCode(return_code);
            insuranceWxpay.setResultCode(result_code);
            if ("SUCCESS".equals(return_code) && return_code.equals(result_code)) {
                String nonceStr = WXPayUtil.generateNonceStr();
                resultMap.put("nonceStr", nonceStr);
                Long timeStamp = System.currentTimeMillis() / 1000;
                String prepayid = rMap.get("prepay_id");
                resultMap.put("package", "prepay_id=" + prepayid);
                resultMap.put("signType", "MD5");
//                //这边要将返回的时间戳转化成字符串，不然小程序端调用wx.requestPayment方法会报签名错误
                resultMap.put("timeStamp", timeStamp + "");
                //再次签名，这个签名用于小程序端调用wx.requesetPayment方法
                resultMap.put("appId", APP_ID);
                String sign = WXPayUtil.generateSignature(resultMap, WXPAY_KEY);
                resultMap.put("paySign", sign);
                System.out.println("生成的签名paySign : " + sign);
//                response.setData(resultMap);
                insuranceWxpay.setPrepayId(prepayid);
                insuranceWxpay.setSignType("MD5");
                insuranceWxpay.setTimeStamp(timeStamp + "");
                insuranceWxpay.setPaySign(sign);
                insuranceWxpay.setUnifiedorderSucceed(true);
            } else {
//                resultMap.put("result_code", FAIL);
                //下单失败的返回给前端的消息
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("result_code", FAIL);
        }
        insuranceWxpay.setCreateTime(LocalDateTime.now());
        resultMap.put("id",insuranceWxpayService.insertAtUnifiedorder(insuranceWxpay));
        return resultMap;
    }

    @RequestMapping("/paySucceed")
    @ResponseBody
    public Boolean paySucceed(HttpServletRequest request, HttpServletResponse response)
    {
        response.setContentType("text/html;charset=utf-8");
        /*设置响应头允许ajax跨域访问*/
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* 星号表示所有的异域请求都可以接受， */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        String wxpayId = request.getParameter("wxpayId");
        String serviceId=request.getParameter("serviceId");
        String openId = request.getParameter("openId");

        InsuranceWxpay insuranceWxpay = new InsuranceWxpay();
        insuranceWxpay.setId(Integer.parseInt(wxpayId));
        insuranceWxpay.setPaySucceed(true);
        insuranceWxpay.setPayTime(LocalDateTime.now());
        insuranceWxpayService.setAfterPaySucceed(insuranceWxpay);
//        JSONObject applicant = JSONObject.parseObject(request.getParameter("applicant"));
//        JSONObject insured = JSONObject.parseObject(request.getParameter("insured"));
//        InsuranceApplicant insuranceApplicant = JSON.parseObject(request.getParameter("applicant"), InsuranceApplicant.class);
//        InsuranceInsured insuranceInsured = JSON.parseObject(request.getParameter("insured"), InsuranceInsured.class);
//        System.out.println("applicant:" + insuranceApplicant);
//        System.out.println("insured:" + insuranceInsured);
        //插入订单
        UserManage userManage = new UserManage();
        try {
            userManage=userManageService.selectByUserName(openId);
        }catch (NullPointerException e){
            e.printStackTrace();
        }
        InsuranceService insuranceService=new InsuranceService();
        insuranceService=insuranceServiceService.selectById(serviceId);
        InsuranceOrder insuranceOrder = new InsuranceOrder();
        insuranceOrder.setBuyerId(userManage.getId());
        insuranceOrder.setCreateTime(LocalDateTime.now());
        insuranceOrder.setWxpayId(new Integer(wxpayId));
        insuranceOrder.setServiceId(Integer.parseInt(serviceId));
        insuranceOrder.setExpireTime(LocalDateTime.now().plusMonths(insuranceService.getServiceDuration()));//到期时间是当前时间加上保质期
        insuranceOrderService.insertAfterPaySucceed(insuranceOrder);
        return true;
    }

    @RequestMapping("/getOrderWaiting")
    @ResponseBody
    public List<InsuranceWxpay> getOrderWaiting(HttpServletRequest request, HttpServletResponse response)
    {
        response.setContentType("text/html;charset=utf-8");
        /*设置响应头允许ajax跨域访问*/
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* 星号表示所有的异域请求都可以接受， */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        String openId = request.getParameter("openId");

        List<InsuranceWxpay> ordersWaiting = new ArrayList<>();
        MyConfig config = null;
        WXPay wxpay = null;
        try {
            config = new MyConfig();
            wxpay = new WXPay(config);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            ordersWaiting=insuranceWxpayService.getOrderWaiting(openId);
            for(int i=0;i<ordersWaiting.size();i++){
                InsuranceWxpay tmp=new InsuranceWxpay();
                tmp=ordersWaiting.get(i);
                tmp.setUnifiedorderTime(tmp.getUnifiedorderTime().plusHours(2));
                HashMap<String, String> data = new HashMap<String, String>();
                data.put("appid", tmp.getAppId());
                data.put("mch_id", tmp.getMchId());
                data.put("nonce_str", tmp.getNonceStr());
                data.put("body", tmp.getBody());
                data.put("out_trade_no", tmp.getOutTradeNo());
                data.put("total_fee", tmp.getTotalFee());
                data.put("spbill_create_ip", tmp.getSpbillCreateIp());
                data.put("notify_url", tmp.getNotifyUrl());
                data.put("trade_type",tmp.getTradeType());
                data.put("openid",openId);
                Map resultMap = new HashMap();
                try {
                    Map<String, String> rMap = wxpay.unifiedOrder(data);
                    System.out.println("统一下单接口返回: " + rMap);
                    String return_code = (String) rMap.get("return_code");
                    String result_code = (String) rMap.get("result_code");
                    if ("SUCCESS".equals(return_code) && return_code.equals(result_code)) {
                        String prepayid = rMap.get("prepay_id");
                        resultMap.put("package", "prepay_id=" + prepayid);
                        resultMap.put("signType", "MD5");
                        Long timeStamp = System.currentTimeMillis() / 1000;
                        resultMap.put("timeStamp", timeStamp+"");
                        String nonceStr = WXPayUtil.generateNonceStr();
                        resultMap.put("nonceStr", nonceStr);
                        //再次签名，这个签名用于小程序端调用wx.requesetPayment方法
                        resultMap.put("appId", tmp.getAppId());
                        String paySign = WXPayUtil.generateSignature(resultMap, WXPAY_KEY);//生成paySign
                        System.out.println("生成的签名paySign : " + paySign);
                        tmp.setNonceStr(nonceStr);
                        tmp.setTimeStamp(timeStamp+"");
                        tmp.setPrepayId(prepayid);
                        tmp.setSignType("MD5");
                        tmp.setPaySign(paySign);
                        ordersWaiting.set(i,tmp);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    resultMap.put("result_code", FAIL);
                }
            }
        }catch (NullPointerException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return ordersWaiting;
    }

    @RequestMapping("/payAgainSucceed")
    @ResponseBody
    public Boolean payAgainSucceed(HttpServletRequest request, HttpServletResponse response)
    {
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        String wxpayId = request.getParameter("wxpayId");
        String timeStamp=request.getParameter("timeStamp");
        String nonceStr = request.getParameter("nonceStr");
        String prepayid = request.getParameter("prepayid");
        String signType=request.getParameter("signType");
        String paySign = request.getParameter("paySign");
        InsuranceWxpay originOrder=insuranceWxpayService.selectById(wxpayId);//原来的订单
        UserManage buyer = new UserManage();
        try {
            buyer=userManageService.selectByUserName(originOrder.getOpenId());
        }catch (NullPointerException e){
            e.printStackTrace();
        }
        InsuranceService buyedService=new InsuranceService();
        buyedService=insuranceServiceService.selectByServiceName(originOrder.getBody());

        InsuranceWxpay payAgainOrder = new InsuranceWxpay();//重复支付成功的订单
        payAgainOrder.setId(Integer.parseInt(wxpayId));
        payAgainOrder.setPaySucceed(true);
        payAgainOrder.setTimeStamp(timeStamp);
        payAgainOrder.setNonceStr(nonceStr);
        payAgainOrder.setPrepayId(prepayid);
        payAgainOrder.setSignType(signType);
        payAgainOrder.setPaySign(paySign);
        payAgainOrder.setPayTime(LocalDateTime.now());
        insuranceWxpayService.setAfterPaySucceed(payAgainOrder);
        //插入订单
        InsuranceOrder newOrder = new InsuranceOrder();
        newOrder.setBuyerId(buyer.getId());
        newOrder.setCreateTime(LocalDateTime.now());
        newOrder.setWxpayId(new Integer(wxpayId));
        newOrder.setServiceId(buyedService.getId());
        newOrder.setExpireTime(LocalDateTime.now().plusMonths(buyedService.getServiceDuration()));//到期时间是当前时间加上保质期
        insuranceOrderService.insertAfterPaySucceed(newOrder);
        return true;
    }

    public InsuranceWxpay setInsuranceWxpayParamBeforeOrder(InsuranceWxpay insuranceWxpay, HashMap<String, String> data) {
        try {
            insuranceWxpay.setAppId(data.get("appid"));
            insuranceWxpay.setMchId(data.get("mch_id"));
            insuranceWxpay.setNonceStr(data.get("nonce_str"));
            insuranceWxpay.setBody(data.get("body"));
            insuranceWxpay.setOutTradeNo(data.get("out_trade_no"));
            insuranceWxpay.setTotalFee(data.get("total_fee"));
            insuranceWxpay.setSpbillCreateIp(data.get("spbill_create_ip"));
            insuranceWxpay.setNotifyUrl(data.get("notify_url"));
            insuranceWxpay.setTradeType(data.get("trade_type"));
            insuranceWxpay.setOpenId(data.get("openid"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return insuranceWxpay;
    }



//    public void init(){
//        Timer timer = new Timer();
//        timer.schedule(new TimerTask() {
//            public void run() {
//                insuranceWxpayService.checkPaySucceed();
//            }
//        }, 1000*10, 1000*10);
//    }
}
