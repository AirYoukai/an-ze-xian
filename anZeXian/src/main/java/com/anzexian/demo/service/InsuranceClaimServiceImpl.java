package com.anzexian.demo.service;

import com.anzexian.demo.entity.*;
import com.anzexian.demo.mapper.InsuranceClaimMapper;
import com.anzexian.demo.util.wxPaySDKTencent.WXPayExample;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static com.anzexian.demo.util.Constant.*;

@Service
public class InsuranceClaimServiceImpl implements InsuranceClaimService {
    @Autowired
    InsuranceClaimMapper insuranceClaimMapper;
    @Autowired
    InsuranceOrderService insuranceOrderService;
    @Autowired
    UserManageService userManageService;
    @Autowired
    InsuranceWxpayService insuranceWxpayService;


    @Override
    public PageInfo getAll() {
        List<InsuranceClaim> insuranceClaimList = insuranceClaimMapper.selectByExample(null);
        PageInfo pageInfo = new PageInfo(insuranceClaimList);
        return pageInfo;
    }

    @Override
    public PageInfo list(String pageNum, String pageSize) {
        return null;
    }

    @Override
    public PageInfo selectLike(InsuranceClaim insuranceClaim, String pageNum, String pageSize) {
        List<InsuranceClaim> insuranceClaimList = new ArrayList<>();
        InsuranceClaimExample example = setParamOfCriteria(insuranceClaim);
        Page<Object> objects = PageHelper.startPage(Integer.parseInt(pageNum), Integer.parseInt(pageSize));
        insuranceClaimList = this.insuranceClaimMapper.selectByExample(example);
        InsuranceClaim tmp = new InsuranceClaim();
        for (int i = 0; i < insuranceClaimList.size(); i++) {
            tmp = insuranceClaimList.get(i);
            tmp.setInsuranceOrder(insuranceOrderService.selectById(String.valueOf(tmp.getOrderId())));
            //只有order_id非null
            if (tmp.getReviewStaffId() != null && !"".equals(String.valueOf(tmp.getReviewStaffId())))
                tmp.setUserManageReviewStaff(userManageService.selectById(String.valueOf(tmp.getReviewStaffId())));
            if (tmp.getReviewManagerId() != null && !"".equals(String.valueOf(tmp.getReviewManagerId())))
                tmp.setUserManageReviewManager(userManageService.selectById(String.valueOf(tmp.getReviewManagerId())));
            if (tmp.getPayerId() != null && !"".equals(String.valueOf(tmp.getPayerId())))
                tmp.setUserManagePayer(userManageService.selectById(String.valueOf(tmp.getPayerId())));
            if (tmp.getClaimantId() != null && !"".equals(String.valueOf(tmp.getClaimantId())))
                tmp.setUserManageClaimant(userManageService.selectById(String.valueOf(tmp.getClaimantId())));
            if (tmp.getWxpayId() != null && !"".equals(String.valueOf(tmp.getWxpayId())))
                tmp.setInsuranceWxpayPayback(insuranceWxpayService.selectById(String.valueOf(tmp.getWxpayId())));
            insuranceClaimList.set(i, tmp);
        }
        PageInfo pageInfo = new PageInfo(insuranceClaimList);
        return pageInfo;
    }

    @Override
    public InsuranceClaim selectById(String id) {
        InsuranceClaim tmp = new InsuranceClaim();
        try {
            tmp = insuranceClaimMapper.selectByPrimaryKey(Integer.parseInt(id));
            tmp.setInsuranceOrder(insuranceOrderService.selectById(String.valueOf(tmp.getOrderId())));
            //只有order_id非null
            if (tmp.getReviewStaffId() != null && !"".equals(String.valueOf(tmp.getReviewStaffId())))
                tmp.setUserManageReviewStaff(userManageService.selectById(String.valueOf(tmp.getReviewStaffId())));
            if (tmp.getReviewManagerId() != null && !"".equals(String.valueOf(tmp.getReviewManagerId())))
                tmp.setUserManageReviewManager(userManageService.selectById(String.valueOf(tmp.getReviewManagerId())));
            if (tmp.getPayerId() != null && !"".equals(String.valueOf(tmp.getPayerId())))
                tmp.setUserManagePayer(userManageService.selectById(String.valueOf(tmp.getPayerId())));
            if (tmp.getClaimantId() != null && !"".equals(String.valueOf(tmp.getClaimantId())))
                tmp.setUserManageClaimant(userManageService.selectById(String.valueOf(tmp.getClaimantId())));
            if (tmp.getWxpayId() != null && !"".equals(String.valueOf(tmp.getWxpayId())))
                tmp.setInsuranceWxpayPayback(insuranceWxpayService.selectById(String.valueOf(tmp.getWxpayId())));

        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return tmp;
    }

    @Override
    public Boolean updateById(InsuranceClaim insuranceClaim) {
        insuranceClaimMapper.updateByPrimaryKeySelective(insuranceClaim);
        return true;
    }

    @Override
    public Boolean deleteById(String id) {
        InsuranceClaim insuranceClaim = new InsuranceClaim();
        insuranceClaim.setId(Integer.parseInt(id));
        insuranceClaim.setIsDeleted(true);
        insuranceClaimMapper.updateByPrimaryKeySelective(insuranceClaim);
        return true;
    }
    @Override
    public Boolean insert(InsuranceClaim insuranceClaim) {
        return  insuranceClaimMapper.insertSelective(insuranceClaim)>0;
    }
//    @Override
//    public Boolean insert(InsuranceClaim insuranceClaim) {
//        insuranceClaimMapper.insertSelective(insuranceClaim);
//        return true;
//    }

    @Override
    public List<InsuranceClaim> selectByClaimantId(Integer claimantId) {
        List<InsuranceClaim> insuranceClaimList = new ArrayList<>();
        InsuranceClaimExample example = new InsuranceClaimExample();
        InsuranceClaimExample.Criteria criteria = example.createCriteria();
        if(claimantId!=null && !"".equals(claimantId))
            criteria.andClaimantIdEqualTo(claimantId);
        criteria.andIsDeletedEqualTo(false);
        insuranceClaimList = this.insuranceClaimMapper.selectByExample(example);
        InsuranceClaim tmp = new InsuranceClaim();
        for(int i=0;i<insuranceClaimList.size();i++){
            tmp = insuranceClaimList.get(i);
            tmp.setInsuranceOrder(insuranceOrderService.selectById(String.valueOf(tmp.getOrderId())));
            //只有order_id非null
            if (tmp.getReviewStaffId() != null && !"".equals(String.valueOf(tmp.getReviewStaffId())))
                tmp.setUserManageReviewStaff(userManageService.selectById(String.valueOf(tmp.getReviewStaffId())));
            if (tmp.getReviewManagerId() != null && !"".equals(String.valueOf(tmp.getReviewManagerId())))
                tmp.setUserManageReviewManager(userManageService.selectById(String.valueOf(tmp.getReviewManagerId())));
            if (tmp.getPayerId() != null && !"".equals(String.valueOf(tmp.getPayerId())))
                tmp.setUserManagePayer(userManageService.selectById(String.valueOf(tmp.getPayerId())));
            if (tmp.getClaimantId() != null && !"".equals(String.valueOf(tmp.getClaimantId())))
                tmp.setUserManageClaimant(userManageService.selectById(String.valueOf(tmp.getClaimantId())));
            if (tmp.getWxpayId() != null && !"".equals(String.valueOf(tmp.getWxpayId())))
                tmp.setInsuranceWxpayPayback(insuranceWxpayService.selectById(String.valueOf(tmp.getWxpayId())));
            insuranceClaimList.set(i, tmp);
        }
        return insuranceClaimList;
    }

    public InsuranceClaimExample setParamOfCriteria(InsuranceClaim insuranceClaim) {
        InsuranceClaimExample example = new InsuranceClaimExample();
        String orderByStr = "";
        if (insuranceClaim.getOrderByOne() != null && !"".equals(insuranceClaim.getOrderByOne()))
            orderByStr = orderByStr /*+ "'"*/ + insuranceClaim.getOrderByOne() + " ASC, ";
        if (insuranceClaim.getOrderByTwo() != null && !"".equals(insuranceClaim.getOrderByTwo()))
            orderByStr = orderByStr /*+ "'"*/ + insuranceClaim.getOrderByTwo() + " ASC, ";
        if (insuranceClaim.getOrderByThree() != null && !"".equals(insuranceClaim.getOrderByThree()))
            orderByStr = orderByStr /*+ "'"*/ + insuranceClaim.getOrderByThree() + " ASC, ";
        if (orderByStr.endsWith(", ")) orderByStr = orderByStr.substring(0, orderByStr.length() - 2);
        if (orderByStr != null && !orderByStr.equals("")) example.setOrderByClause(orderByStr);
        InsuranceClaimExample.Criteria criteria = example.createCriteria();
        if (insuranceClaim.getCurPosList() != null && !insuranceClaim.getCurPosList().isEmpty())
            criteria.andCurPosIn(insuranceClaim.getCurPosList());
        if (insuranceClaim.getStatusStaff()!= null && !insuranceClaim.getStatusStaff().equals(""))
            criteria.andStatusStaffLike(insuranceClaim.getStatusStaff());
        if (insuranceClaim.getStatusManager()!= null && !insuranceClaim.getStatusManager().equals(""))
            criteria.andStatusManagerLike(insuranceClaim.getStatusManager());
        if (insuranceClaim.getCreateTimeFrom() != null && insuranceClaim.getCreateTimeTo() != null && !insuranceClaim.getCreateTimeFrom().equals("") && !insuranceClaim.getCreateTimeTo().equals(""))
            criteria.andCreateTimeBetween(LocalDateTime.parse(insuranceClaim.getCreateTimeFrom(), DateTimeFormatter.ofPattern("yyyy-MM-dd")), LocalDateTime.parse(insuranceClaim.getCreateTimeTo(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        criteria.andIsDeletedEqualTo(false);
        return example;
    }

//    @Override
//    public void checkPaySucceed(){
//        System.out.println("-------checkPaySucceed--------");
//        List<InsuranceClaim> insuranceClaimList = new ArrayList<>();
//        InsuranceClaimExample example =new InsuranceClaimExample();
//        InsuranceClaimExample.Criteria criteria=example.createCriteria();
////        criteria.andPaySucceedEqualTo(false);
//        insuranceClaimList = this.insuranceClaimMapper.selectByExample(example);
//        for(int i=0;i<insuranceClaimList.size();i++){
//            InsuranceClaim tmp=insuranceClaimList.get(i);
////            String outTradeNo=tmp.getOutTradeNo();
//            Map<String, String> tmpQuery = new HashMap<>();
//            try {
////                tmpQuery= WXPayExample.queryOrder(outTradeNo);
////                if("支付成功".equals(tmpQuery.get("trade_state_desc")))
////                {
////                    tmp.setPaySucceed(true);//当且仅当支付成功后才可以设置为支付成功
////                    tmp.setPayTime(LocalDateTime.now());
////                    insuranceClaimMapper.updateByPrimaryKeySelective(tmp);
////                }
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//        }
//    }

//    @Override
//    public InsuranceClaim selectByOrderId(String orderId) {
//        List<InsuranceClaim> insuranceClaimList = new ArrayList<>();
//        InsuranceClaimExample example = new InsuranceClaimExample();
//        InsuranceClaimExample.Criteria criteria = example.createCriteria();
//        if(orderId!=null && !"".equals(orderId))
//            criteria.andOrderIdEqualTo(Integer.parseInt(orderId));
//        insuranceClaimList = this.insuranceClaimMapper.selectByExample(example);
//        return insuranceClaimList.isEmpty()?new InsuranceClaim():insuranceClaimList.get(0);
//    }

    @Override
    public boolean hasClaimsForStaff() {
        List<InsuranceClaim> insuranceClaimList = new ArrayList<>();
        InsuranceClaimExample example = new InsuranceClaimExample();
        InsuranceClaimExample.Criteria criteria = example.createCriteria();
        Integer[] integers = {CUR_POS_STAFF_REVIEW, CUR_POS_STAFF_PAYBACK};
        List<Integer> integerArrayList = Arrays.asList(integers);
        criteria.andCurPosIn(integerArrayList).andIsDeletedEqualTo(false);
        insuranceClaimList = this.insuranceClaimMapper.selectByExample(example);
        return !insuranceClaimList.isEmpty();
    }

    @Override
    public boolean hasClaimsForManager() {
        List<InsuranceClaim> insuranceClaimList = new ArrayList<>();
        InsuranceClaimExample example = new InsuranceClaimExample();
        InsuranceClaimExample.Criteria criteria = example.createCriteria();
        criteria.andCurPosEqualTo(CUR_POS_MANAGER_REVIEW).andIsDeletedEqualTo(false);
        insuranceClaimList = this.insuranceClaimMapper.selectByExample(example);
        return !insuranceClaimList.isEmpty();
    }
}
