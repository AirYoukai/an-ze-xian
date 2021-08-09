package com.anzexian.demo.service;

import com.anzexian.demo.entity.InsuranceOrder;
import com.anzexian.demo.entity.InsuranceOrderExample;
import com.anzexian.demo.mapper.InsuranceOrderMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class InsuranceOrderServiceImpl implements InsuranceOrderService {
    @Autowired
    InsuranceOrderMapper insuranceOrderMapper;
    @Autowired
    InsuranceServiceService insuranceServiceService;
    @Autowired
    InsuranceWxpayService insuranceWxpayService;
    @Autowired
    UserManageService userManageService;

    //    @Override
//    public boolean isOutTradeNoRepetitive(String outTradeNo) {
//        InsuranceOrder tmp = new InsuranceOrder();
//        tmp.setOutTradeNo(outTradeNo);
//        InsuranceOrderExample example = new InsuranceOrderExample();
//        InsuranceOrderExample.Criteria criteria = example.createCriteria();
//        criteria.andOutTradeNoEqualTo(outTradeNo);
//        return !insuranceOrderMapper.selectByExample(example).isEmpty();
//    }
    @Override
    public PageInfo getAll() {
        List<InsuranceOrder> insuranceOrderList = new ArrayList<>();
        InsuranceOrderExample example = new InsuranceOrderExample();
        InsuranceOrderExample.Criteria criteria = example.createCriteria();
        criteria.andIsDeletedEqualTo(false);
        insuranceOrderList = this.insuranceOrderMapper.selectByExample(example);
        InsuranceOrder tmp = new InsuranceOrder();
        for (int i = 0; i < insuranceOrderList.size(); i++) {
            tmp = insuranceOrderList.get(i);
            tmp.setInsuranceService(insuranceServiceService.selectById(String.valueOf(tmp.getServiceId())));
            tmp.setInsuranceWxpay(insuranceWxpayService.selectById(String.valueOf(tmp.getWxpayId())));
            tmp.setUserManage(userManageService.selectById(String.valueOf(tmp.getBuyerId())));
            insuranceOrderList.set(i, tmp);
        }
        PageInfo pageInfo = new PageInfo(insuranceOrderList);
        return pageInfo;
    }

    @Override
    public PageInfo selectLike(InsuranceOrder insuranceOrder, String pageNum, String pageSize) {
        List<InsuranceOrder> insuranceOrderList = new ArrayList<>();
        InsuranceOrderExample example = setParamOfCriteria(insuranceOrder);
        Page<Object> objects = PageHelper.startPage(Integer.parseInt(pageNum), Integer.parseInt(pageSize));
        insuranceOrderList = this.insuranceOrderMapper.selectByExample(example);
        InsuranceOrder tmp = new InsuranceOrder();
        for (int i = 0; i < insuranceOrderList.size(); i++) {
            tmp = insuranceOrderList.get(i);
            tmp.setInsuranceService(insuranceServiceService.selectById(String.valueOf(tmp.getServiceId())));
            tmp.setInsuranceWxpay(insuranceWxpayService.selectById(String.valueOf(tmp.getWxpayId())));
            tmp.setUserManage(userManageService.selectById(String.valueOf(tmp.getBuyerId())));
            insuranceOrderList.set(i, tmp);
        }
        PageInfo pageInfo = new PageInfo(insuranceOrderList);
        return pageInfo;
    }

    @Override
    public InsuranceOrder selectById(String id) {
        InsuranceOrder insuranceOrder = new InsuranceOrder();
        try {
            insuranceOrder = insuranceOrderMapper.selectByPrimaryKey(Integer.parseInt(id));
            insuranceOrder.setInsuranceService(insuranceServiceService.selectById(String.valueOf(insuranceOrder.getServiceId())));
            insuranceOrder.setInsuranceWxpay(insuranceWxpayService.selectById(String.valueOf(insuranceOrder.getWxpayId())));
            insuranceOrder.setUserManage(userManageService.selectById(String.valueOf(insuranceOrder.getBuyerId())));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return insuranceOrder;
    }

    @Override
    public Boolean updateById(InsuranceOrder insuranceOrder) {
        insuranceOrderMapper.updateByPrimaryKeySelective(insuranceOrder);
        return true;
    }

    @Override
    public void insertAfterPaySucceed(InsuranceOrder insuranceOrder) {
        insuranceOrderMapper.insertSelective(insuranceOrder);
    }


    @Override
    public List<InsuranceOrder> selectByBuyerId(Integer buyerId) {
        List<InsuranceOrder> insuranceOrderList = new ArrayList<>();
        InsuranceOrderExample example = new InsuranceOrderExample();
        InsuranceOrderExample.Criteria criteria = example.createCriteria();
        if (buyerId != null && !"".equals(buyerId))
            criteria.andBuyerIdEqualTo(buyerId);
        criteria.andIsDeletedEqualTo(false);
        insuranceOrderList = this.insuranceOrderMapper.selectByExample(example);
        InsuranceOrder tmp = new InsuranceOrder();
        for (int i = 0; i < insuranceOrderList.size(); i++) {
            tmp = insuranceOrderList.get(i);
            tmp.setInsuranceService(insuranceServiceService.selectById(String.valueOf(tmp.getServiceId())));
            tmp.setInsuranceWxpay(insuranceWxpayService.selectById(String.valueOf(tmp.getWxpayId())));
            tmp.setUserManage(userManageService.selectById(String.valueOf(tmp.getBuyerId())));
            insuranceOrderList.set(i, tmp);
        }
        return insuranceOrderList;
    }

    @Override
    public Boolean deleteById(String id) {
        InsuranceOrder insuranceOrder = new InsuranceOrder();
        insuranceOrder.setId(Integer.parseInt(id));
        insuranceOrder.setIsDeleted(true);
        insuranceOrderMapper.updateByPrimaryKeySelective(insuranceOrder);
        return true;
    }

    @Override
    public boolean hasOrderNotActive() {
        List<InsuranceOrder> insuranceOrderList = new ArrayList<>();
        InsuranceOrderExample example = new InsuranceOrderExample();
        InsuranceOrderExample.Criteria criteria = example.createCriteria();
        criteria.andIsDeletedEqualTo(false).andIsActiveEqualTo(false);
        insuranceOrderList = this.insuranceOrderMapper.selectByExample(example);
        return !insuranceOrderList.isEmpty();
    }

    public InsuranceOrderExample setParamOfCriteria(InsuranceOrder insuranceOrder) {
        InsuranceOrderExample example = new InsuranceOrderExample();
        String orderByStr = "";
        if (insuranceOrder.getOrderByOne() != null && !"".equals(insuranceOrder.getOrderByOne()))
            orderByStr = orderByStr /*+ "'"*/ + insuranceOrder.getOrderByOne() + " ASC, ";
        if (insuranceOrder.getOrderByTwo() != null && !"".equals(insuranceOrder.getOrderByTwo()))
            orderByStr = orderByStr /*+ "'"*/ + insuranceOrder.getOrderByTwo() + " ASC, ";
        if (insuranceOrder.getOrderByThree() != null && !"".equals(insuranceOrder.getOrderByThree()))
            orderByStr = orderByStr /*+ "'"*/ + insuranceOrder.getOrderByThree() + " ASC, ";
        if (orderByStr.endsWith(", ")) orderByStr = orderByStr.substring(0, orderByStr.length() - 2);
        if (orderByStr != null && !orderByStr.equals("")) example.setOrderByClause(orderByStr);

        InsuranceOrderExample.Criteria criteria = example.createCriteria();

        if (insuranceOrder.getIsActive() != null && !insuranceOrder.getIsActive().equals(""))
            criteria.andIsActiveEqualTo(insuranceOrder.getIsActive());

        if (insuranceOrder.getExpireTimeFrom() != null && insuranceOrder.getExpireTimeTo() != null && !insuranceOrder.getExpireTimeFrom().equals("") && !insuranceOrder.getExpireTimeTo().equals(""))
            criteria.andExpireTimeBetween(
                    LocalDateTime.parse(insuranceOrder.getExpireTimeFrom(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                    LocalDateTime.parse(insuranceOrder.getExpireTimeTo(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        if (insuranceOrder.getCreateTimeFrom() != null && insuranceOrder.getCreateTimeTo() != null && !insuranceOrder.getCreateTimeFrom().equals("") && !insuranceOrder.getCreateTimeTo().equals(""))
            criteria.andCreateTimeBetween(
                    LocalDateTime.parse(insuranceOrder.getCreateTimeFrom(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                    LocalDateTime.parse(insuranceOrder.getCreateTimeTo(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
//        if (!"".equals(insuranceOrder.getCompanyId() + "")) {
//            ArrayList<Integer> serviceIdListByCompanyName = insuranceServiceService.getServiceIdListByCompanyName(insuranceOrder.getCompanyId());
//            if(!serviceIdListByCompanyName.isEmpty())criteria.andServiceIdIn(serviceIdListByCompanyName);
//        }
//        if (insuranceOrder.getIndustry() != null && !insuranceOrder.getIndustry().equals("")) {
//            ArrayList<Integer> serviceIdListByIndustry = insuranceServiceService.getServiceIdListByIndustry(insuranceOrder.getIndustry());
//            if(!serviceIdListByIndustry.isEmpty())criteria.andServiceIdIn(serviceIdListByIndustry);
//        }

//        if (!"".equals(insuranceOrder() + "")) {
//            ArrayList<Integer> serviceIdListByCompanyName = insuranceServiceService.getServiceIdListByCompanyName(insuranceOrder.getCompanyId());
//            if(!serviceIdListByCompanyName.isEmpty())criteria.andServiceIdIn(serviceIdListByCompanyName);
//        }
//        if (!"".equals(insuranceOrder.getCompanyId() + "")) {
//            ArrayList<Integer> serviceIdListByCompanyName = insuranceServiceService.getServiceIdListByCompanyName(insuranceOrder.getCompanyId());
//            if(!serviceIdListByCompanyName.isEmpty())criteria.andServiceIdIn(serviceIdListByCompanyName);
//        }
        if (insuranceOrder.getIndustry() != null && !insuranceOrder.getIndustry().equals("")) {
            List<Integer> serviceIdListByIndustry = insuranceServiceService.getServiceIdListByIndustry(insuranceOrder.getIndustry());
            if (!serviceIdListByIndustry.isEmpty()) criteria.andServiceIdIn(serviceIdListByIndustry);
        }
        if (insuranceOrder.getServiceName() != null && !insuranceOrder.getServiceName().equals("")) {
            List<Integer> serviceIdListByServiceName = insuranceServiceService.getServiceIdListByServiceName(insuranceOrder.getServiceName());
            if (!serviceIdListByServiceName.isEmpty()) criteria.andServiceIdIn(serviceIdListByServiceName);
        }
        if ((Integer) insuranceOrder.getCompanyId() != null && !"".equals((Integer) insuranceOrder.getCompanyId())) {
            List<Integer> serviceIdListByCompanyId = insuranceServiceService.getServiceIdListByCompanyId(insuranceOrder.getCompanyId());
            if (!serviceIdListByCompanyId.isEmpty()) criteria.andServiceIdIn(serviceIdListByCompanyId);
        }
        criteria.andIsDeletedEqualTo(false);
        return example;
    }
}