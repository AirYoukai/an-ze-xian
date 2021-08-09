package com.anzexian.demo.util.wxPaySDKTencent;


import com.anzexian.demo.util.Constant;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * @Description: 微信支付配置类
 * @Author: hm
 * @CreateDate: 2018/12/10 17:19.
 * @UpdateDate: 2018/12/10 17:19.
 * @Version: 1.0
 */
public class MyConfig extends WXPayConfig {

    private byte[] certData;
    public MyConfig() throws Exception {
//        String certPath = "classpath:apiclient_cert.p12";
//        File file = new File(certPath);
//        InputStream certStream = new FileInputStream(file);
//        this.certData = new byte[(int) file.length()];
//        certStream.read(this.certData);
//        certStream.close();
    }

    @Override
    public String getAppID() {
        return Constant.APP_ID;
    }

    @Override
    public String getMchID() {
        return Constant.MCH_ID;
    }

    @Override
    public String getKey() {
        return Constant.WXPAY_KEY;
    }

    @Override
    public InputStream getCertStream() {
        ByteArrayInputStream certBis = new ByteArrayInputStream(this.certData);
        return certBis;
    }

    @Override
    public int getHttpConnectTimeoutMs() {
        return 8000;
    }

    @Override
    public int getHttpReadTimeoutMs() {
        return 10000;
    }

    @Override
    IWXPayDomain getWXPayDomain() {
        return new IWXPayDomain() {
            @Override
            public void report(String domain, long elapsedTimeMillis, Exception ex) {
            }

            @Override
            public DomainInfo getDomain(WXPayConfig config) {
                return new DomainInfo("api.mch.weixin.qq.com", false);
            }
        };
    }
}
