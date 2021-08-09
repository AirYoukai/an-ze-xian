package com.anzexian.demo.util;

import com.alibaba.fastjson.JSONObject;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.HashMap;
import java.util.Map;

public class SubscribeMessageTest {
    /**
     * 发送订阅消息sendTemplateMessage
     * 小程序订阅消息,发送服务通知
     *
     * @param touser     接收者（用户）的 openid
     * @param templateId 所需下发的模板消息的id
     * @param page       点击模板卡片后的跳转页面，仅限本小程序内的页面。支持带参数,（示例index?foo=bar）。该字段不填则模板无跳转。
     */
    public static JsonNode subscribeMessage(String accessToken,String touser, String templateId, String page, Map<String, TemplateData> map) {
//        String accessToken = GetTokenUtil.getAccessToken();
//        log.info("##accessToken:  " + accessToken);
//        String accessToken ="44_6BWAnmQ-A3eZ8_vReKM9tRHfSMaptAl2jPbrwjC7mYt72r91fouBcWvfZ7jZAEU_Hi0xEr1dOo2TSItL0s0IDPg4ScqgaOdGfpv6aJuhs7sDC6RGbT05IwW2dzwaTrwE-oZN3g4f5nfNbVX9OUTfAFAFLK";
        SubscribeMessage subscribeMessage = new SubscribeMessage();
        //拼接数据
        subscribeMessage.setAccess_token(accessToken);
        subscribeMessage.setTouser(touser);
        subscribeMessage.setTemplate_id(templateId);
        subscribeMessage.setPage(page);
        subscribeMessage.setData(map);
        String json = JSONObject.toJSONString(subscribeMessage);
//       System.out.println("##订阅发送JSON数据请求:  " + json);
//        String ret = UrlUtils.sendPost(Wechat.SUBSCRIBEMESSAGE + accessToken, json);
        //如果不想找sendPost，可以借用Unirest 来发送 2选1 引的jar放在最下方了
        JsonNode ret = null;
        String SEND_TEMPLATE_MESSAGE = " https://api.weixin.qq.com/cgi-bin/message/subscribe/send?access_token=";
//        String SEND_TEMPLATE_MESSAGE = "https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token=";
        try {
            ret = Unirest.post(SEND_TEMPLATE_MESSAGE + accessToken).body(json).asJson().getBody();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
//        System.out.println("##订阅发送JSON数据返回:  " + ret);
//        System.out.println(ret);
        return ret;
    }
    public static void main(String[] args) {
        Map<String, TemplateData> map = new HashMap<>();
//        任务名称
//        责任人
//        当前环节
        map.put("thing1", new TemplateData("理赔业务"));
        map.put("thing2", new TemplateData("你"));
        map.put("thing6", new TemplateData("待审核"));
        String accessToken ="44_6BWAnmQ-A3eZ8_vReKM9tRHfSMaptAl2jPbrwjC7mYt72r91fouBcWvfZ7jZAEU_Hi0xEr1dOo2TSItL0s0IDPg4ScqgaOdGfpv6aJuhs7sDC6RGbT05IwW2dzwaTrwE-oZN3g4f5nfNbVX9OUTfAFAFLK";
        subscribeMessage(accessToken,"oIdQE5WG4OGiyt3MnAFrLgk2heCE", "rpOdYba1dozS3QboRMmm2-4Yaguk8wrKYpLtrQbj0aI", "pages/apply/apply_map/apply_map", map);
    }

}
