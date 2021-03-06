package com.anzexian.demo.service;

import com.anzexian.demo.entity.InsuranceClaim;
import com.anzexian.demo.entity.InsuranceWxpay;
import com.anzexian.demo.entity.InsuranceWxpayExample;
import com.anzexian.demo.mapper.InsuranceWxpayMapper;
import com.anzexian.demo.util.wxPaySDKTencent.WXPayExample;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InsuranceWxpayServiceImpl implements InsuranceWxpayService {
    @Autowired
    private InsuranceWxpayMapper insuranceWxpayMapper;
    @Autowired
    private InsuranceClaimService insuranceClaimService;
    @Autowired
    private InsuranceOrderService insuranceOrderService;
    @Autowired
    private UserManageService userManageService;
    @Autowired
    private InsuranceServiceService insuranceServiceService;

    @Override
    public PageInfo getALl() {
        List<InsuranceWxpay> insuranceWxpayList = new ArrayList<>();
        InsuranceWxpayExample example = new InsuranceWxpayExample();
        InsuranceWxpayExample.Criteria criteria = example.createCriteria();
        criteria.andIsDeletedEqualTo(false);
        insuranceWxpayList = this.insuranceWxpayMapper.selectByExample(example);
        PageInfo pageInfo = new PageInfo(insuranceWxpayList);
        return pageInfo;
    }

    @Override
    public PageInfo list(String pageNum, String pageSize) {
        return null;
    }

    @Override
    public PageInfo selectLike(InsuranceWxpay insuranceWxpay, String pageNum, String pageSize) {
        List<InsuranceWxpay> insuranceWxpayList = new ArrayList<>();
        InsuranceWxpayExample example = setParamOfCriteria(insuranceWxpay);
        Page<Object> objects = PageHelper.startPage(Integer.parseInt(pageNum), Integer.parseInt(pageSize));
        insuranceWxpayList = this.insuranceWxpayMapper.selectByExample(example);
        PageInfo pageInfo = new PageInfo(insuranceWxpayList);
        return pageInfo;
    }

    @Override
    public InsuranceWxpay selectById(String id) {
        InsuranceWxpay insuranceWxpay = new InsuranceWxpay();
        try {
            insuranceWxpay = insuranceWxpayMapper.selectByPrimaryKey(Integer.parseInt(id));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return insuranceWxpay;
    }

    @Override
    public Boolean updateById(InsuranceWxpay insuranceWxpay) {
        insuranceWxpayMapper.updateByPrimaryKeySelective(insuranceWxpay);
        return true;
    }

    @Override
    public int insertAtUnifiedorder(InsuranceWxpay insuranceWxpay) {
        insuranceWxpayMapper.insertSelective(insuranceWxpay);
        return insuranceWxpay.getId();
    }

    @Override
    public void setAfterPaySucceed(InsuranceWxpay insuranceWxpay) {
        insuranceWxpayMapper.updateByPrimaryKeySelective(insuranceWxpay);
    }

    public static InsuranceWxpayExample setParamOfCriteria(InsuranceWxpay insuranceWxpay) {
        InsuranceWxpayExample example = new InsuranceWxpayExample();
        String orderByStr = "";
        if (insuranceWxpay.getOrderByOne() != null && !"".equals(insuranceWxpay.getOrderByOne()))
            orderByStr = orderByStr /*+ "'"*/ + insuranceWxpay.getOrderByOne() + " ASC, ";
        if (insuranceWxpay.getOrderByTwo() != null && !"".equals(insuranceWxpay.getOrderByTwo()))
            orderByStr = orderByStr /*+ "'"*/ + insuranceWxpay.getOrderByTwo() + " ASC, ";
        if (insuranceWxpay.getOrderByThree() != null && !"".equals(insuranceWxpay.getOrderByThree()))
            orderByStr = orderByStr /*+ "'"*/ + insuranceWxpay.getOrderByThree() + " ASC, ";
        if (orderByStr.endsWith(", ")) orderByStr = orderByStr.substring(0, orderByStr.length() - 2);
        if (orderByStr != null && !orderByStr.equals("")) example.setOrderByClause(orderByStr);

        InsuranceWxpayExample.Criteria criteria = example.createCriteria();

        if (insuranceWxpay.getOpenId() != null && !insuranceWxpay.getOpenId().equals(""))
            criteria.andOpenIdLike("%" + insuranceWxpay.getOpenId() + "%");
        if (insuranceWxpay.getAppId() != null && !insuranceWxpay.getAppId().equals(""))
            criteria.andAppIdLike("%" + insuranceWxpay.getAppId() + "%");
        if (insuranceWxpay.getMchId() != null && !insuranceWxpay.getMchId().equals(""))
            criteria.andMchIdLike("%" + insuranceWxpay.getMchId() + "%");
        if (insuranceWxpay.getNonceStr() != null && !insuranceWxpay.getNonceStr().equals(""))
            criteria.andNonceStrLike("%" + insuranceWxpay.getNonceStr() + "%");
        if (insuranceWxpay.getBody() != null && !insuranceWxpay.getBody().equals(""))
            criteria.andBodyLike("%" + insuranceWxpay.getBody() + "%");
        if (insuranceWxpay.getOutTradeNo() != null && !insuranceWxpay.getOutTradeNo().equals(""))
            criteria.andOutTradeNoLike("%" + insuranceWxpay.getOutTradeNo() + "%");
        if (insuranceWxpay.getTotalFee() != null && !insuranceWxpay.getTotalFee().equals(""))
            criteria.andTotalFeeLike("%" + insuranceWxpay.getTotalFee() + "%");
        if (insuranceWxpay.getSpbillCreateIp() != null && !insuranceWxpay.getSpbillCreateIp().equals(""))
            criteria.andSpbillCreateIpLike("%" + insuranceWxpay.getSpbillCreateIp() + "%");
        if (insuranceWxpay.getNotifyUrl() != null && !insuranceWxpay.getNotifyUrl().equals(""))
            criteria.andNotifyUrlLike("%" + insuranceWxpay.getNotifyUrl() + "%");
        if (insuranceWxpay.getTradeType() != null && !insuranceWxpay.getTradeType().equals(""))
            criteria.andTradeTypeLike("%" + insuranceWxpay.getTradeType() + "%");
        if (insuranceWxpay.getReturnCode() != null && !insuranceWxpay.getReturnCode().equals(""))
            criteria.andReturnCodeLike("%" + insuranceWxpay.getReturnCode() + "%");
        if (insuranceWxpay.getResultCode() != null && !insuranceWxpay.getResultCode().equals(""))
            criteria.andResultCodeLike("%" + insuranceWxpay.getResultCode() + "%");
        if (insuranceWxpay.getPrepayId() != null && !insuranceWxpay.getPrepayId().equals(""))
            criteria.andPrepayIdLike("%" + insuranceWxpay.getPrepayId() + "%");
        if (insuranceWxpay.getSignType() != null && !insuranceWxpay.getSignType().equals(""))
            criteria.andSignTypeLike("%" + insuranceWxpay.getSignType() + "%");
        if (insuranceWxpay.getTimeStamp() != null && !insuranceWxpay.getTimeStamp().equals(""))
            criteria.andTimeStampLike("%" + insuranceWxpay.getTimeStamp() + "%");
        if (insuranceWxpay.getPaySign() != null && !insuranceWxpay.getPaySign().equals(""))
            criteria.andPaySignLike("%" + insuranceWxpay.getSignType() + "%");

        if (insuranceWxpay.getPayTimeFrom() != null && insuranceWxpay.getPayTimeTo() != null
                && !insuranceWxpay.getPayTimeFrom().equals("") && !insuranceWxpay.getPayTimeTo().equals(""))
            criteria.andPayTimeBetween(
                    LocalDateTime.parse(insuranceWxpay.getPayTimeFrom(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                    LocalDateTime.parse(insuranceWxpay.getPayTimeTo(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        if (insuranceWxpay.getUnifiedorderTimeFrom() != null && insuranceWxpay.getUnifiedorderTimeTo() != null
                && !insuranceWxpay.getUnifiedorderTimeFrom().equals("") && !insuranceWxpay.getUnifiedorderTimeTo().equals(""))
            criteria.andUnifiedorderTimeBetween(
                    LocalDateTime.parse(insuranceWxpay.getUnifiedorderTimeFrom(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                    LocalDateTime.parse(insuranceWxpay.getUnifiedorderTimeTo(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        if (insuranceWxpay.getCreateTimeFrom() != null && insuranceWxpay.getCreateTimeTo() != null
                && !insuranceWxpay.getCreateTimeFrom().equals("") && !insuranceWxpay.getCreateTimeTo().equals(""))
            criteria.andCreateTimeBetween(
                    LocalDateTime.parse(insuranceWxpay.getCreateTimeFrom(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                    LocalDateTime.parse(insuranceWxpay.getCreateTimeTo(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        criteria.andIsDeletedEqualTo(false);
        return example;
    }

    @Override
    public void checkPaySucceed() {
        List<InsuranceWxpay> insuranceWxpayList = new ArrayList<>();
        InsuranceWxpayExample example = new InsuranceWxpayExample();
        InsuranceWxpayExample.Criteria criteria = example.createCriteria();
        criteria.andPaySucceedEqualTo(false);
        insuranceWxpayList = this.insuranceWxpayMapper.selectByExample(example);
        for (int i = 0; i < insuranceWxpayList.size(); i++) {
            InsuranceWxpay tmp = insuranceWxpayList.get(i);
            String outTradeNo = tmp.getOutTradeNo();
            Map<String, String> tmpQuery = new HashMap<>();
            try {
                tmpQuery = WXPayExample.queryOrder(outTradeNo);
//                System.out.println(tmpQuery);
                if ("????????????".equals(tmpQuery.get("trade_state_desc"))) {
                    tmp.setPaySucceed(true);//?????????????????????????????????????????????????????????
                    tmp.setPayTime(LocalDateTime.now());
                    insuranceWxpayMapper.updateByPrimaryKeySelective(tmp);
                    String body = tmp.getBody();
//                    if(body.endsWith("??????")){//???????????????????????????????????????controller?????????
//                        try {
//                            //?????? order ???
//                            UserManage userManage = new UserManage();
//                            try {
//                                userManage=userManageService.selectByUserName(tmp.getOpenId());
//                            }catch (NullPointerException e){
//                                e.printStackTrace();
//                            }
//                            InsuranceService insuranceService=new InsuranceService();
//                            insuranceService=insuranceServiceService.selectByServiceName(tmp.getBody());//???????????????????????????
//
//                            InsuranceOrder insuranceOrder = new InsuranceOrder();
//                            insuranceOrder.setBuyerId(userManage.getId());
//                            insuranceOrder.setCreateTime(LocalDateTime.now());
//                            insuranceOrder.setWxpayId(new Integer(tmp.getId()));
//                            insuranceOrder.setServiceId(insuranceService.getId());
//                            insuranceOrder.setExpireTime(LocalDateTime.now().plusMonths(insuranceService.getServiceDuration()));//??????????????????????????????????????????
//
//                            insuranceOrderService.insertAfterPaySucceed(insuranceOrder);
//                        }catch (NullPointerException e){
//                            e.printStackTrace();
//                        }catch (NumberFormatException e){
//                            e.printStackTrace();
//                        }
//                    }
                    if (body.startsWith("??????-")) {//??????????????????
                        try {
//                            ??????-????????????12
                            String claimId = body.substring(body.lastIndexOf("???") + 1);
                            InsuranceClaim insuranceClaim = new InsuranceClaim();
                            insuranceClaim = insuranceClaimService.selectById(claimId);//????????????orderId?????????claim id
                            insuranceClaim.setStatusStaff("PAYEDBACK");
                            insuranceClaim.setWxpayId(tmp.getId());
                            insuranceClaim.setCurPos(3);
                            insuranceClaim.setPaybackTime(LocalDateTime.now());
//                            insuranceClaim.setPayerId(curUser.getId());
                            insuranceClaimService.updateById(insuranceClaim);
//                            String orderId = body.substring(body.lastIndexOf("???") + 1);
//                            InsuranceClaim insuranceClaim = new InsuranceClaim();
//                            insuranceClaim = insuranceClaimService.selectByOrderId(orderId);
//                            insuranceClaim.setStatusStaff("PAYEDBACK");
//                            insuranceClaim.setWxpayId(tmp.getId());
//                            insuranceClaim.setOrderId(Integer.parseInt(orderId));
//                            insuranceClaim.setCurPos(3);
//                            insuranceClaim.setPaybackTime(LocalDateTime.now());
//                            insuranceClaimService.updateById(insuranceClaim);
                        } catch (NullPointerException e) {
                            e.printStackTrace();
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                    }
                } else {

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<InsuranceWxpay> getOrderWaiting(String opneId) {
        List<InsuranceWxpay> ordersWaiting = new ArrayList<>();
        InsuranceWxpayExample example = new InsuranceWxpayExample();
        InsuranceWxpayExample.Criteria criteria = example.createCriteria();
        criteria.andOpenIdEqualTo(opneId)
                .andIsDeletedEqualTo(false)
                .andPaySucceedEqualTo(false)//????????????????????????
                .andUnifiedorderSucceedEqualTo(true)
                .andUnifiedorderTimeGreaterThanOrEqualTo(LocalDateTime.now().minusHours(2))
                //?????????2?????????????????????????????????
                .andBodyNotLike("%??????-????????????%");//????????????????????????????????????????????????
        ordersWaiting=insuranceWxpayMapper.selectByExample(example);
        return ordersWaiting;
    }
}
