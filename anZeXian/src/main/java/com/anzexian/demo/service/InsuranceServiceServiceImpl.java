package com.anzexian.demo.service;

import com.anzexian.demo.entity.InsuranceService;
import com.anzexian.demo.entity.InsuranceServiceExample;
import com.anzexian.demo.mapper.InsuranceServiceMapper;
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
public class InsuranceServiceServiceImpl implements InsuranceServiceService {
    @Autowired
    InsuranceServiceMapper insuranceServiceMapper;
    @Autowired
    InsuranceCompanyService insuranceCompanyService;

    @Override
    public PageInfo getAll() {
        InsuranceServiceExample example=new InsuranceServiceExample();
        InsuranceServiceExample.Criteria criteria=example.createCriteria();
        criteria.andIsDeletedEqualTo(false);
        List<InsuranceService> insuranceServiceList = insuranceServiceMapper.selectByExample(example);
        InsuranceService tmp = new InsuranceService();
        for (int i = 0; i < insuranceServiceList.size(); i++) {
            tmp = insuranceServiceList.get(i);
            tmp.setInsuranceCompany(insuranceCompanyService.selectById(String.valueOf(tmp.getCompanyId())));
            insuranceServiceList.set(i, tmp);
        }
        PageInfo pageInfo = new PageInfo(insuranceServiceList);
        return pageInfo;
    }

    @Override
    public PageInfo list(String pageNum, String pageSize) {
        return null;
    }

    @Override
    public PageInfo selectLike(InsuranceService insuranceService, String pageNum, String pageSize) {
        List<InsuranceService> insuranceServiceList = new ArrayList<>();
        InsuranceServiceExample example = setParamOfCriteria(insuranceService);
        Page<Object> objects = PageHelper.startPage(Integer.parseInt(pageNum), Integer.parseInt(pageSize));
        insuranceServiceList = this.insuranceServiceMapper.selectByExample(example);
        InsuranceService tmp = new InsuranceService();
        for (int i = 0; i < insuranceServiceList.size(); i++) {
            tmp = insuranceServiceList.get(i);
            tmp.setInsuranceCompany(insuranceCompanyService.selectById(String.valueOf(tmp.getCompanyId())));
            insuranceServiceList.set(i, tmp);
        }
        PageInfo pageInfo = new PageInfo(insuranceServiceList);
        return pageInfo;
    }

    @Override
    public InsuranceService selectById(String id) {
        InsuranceService insuranceService = new InsuranceService();
        try {
            insuranceService = insuranceServiceMapper.selectByPrimaryKey(Integer.parseInt(id));
            insuranceService.setInsuranceCompany(insuranceCompanyService.selectById(String.valueOf(insuranceService.getCompanyId())));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return insuranceService;
    }

    @Override
    public Boolean updateById(InsuranceService insuranceService) {
        insuranceServiceMapper.updateByPrimaryKeySelective(insuranceService);
        return true;
    }

    @Override
    public Boolean deleteById(String id) {
        InsuranceService insuranceService = new InsuranceService();
        insuranceService.setId(Integer.parseInt(id));
        insuranceService.setIsDeleted(true);
        insuranceServiceMapper.updateByPrimaryKeySelective(insuranceService);
        return true;
    }

    @Override
    public Boolean insert(InsuranceService insuranceService) {
        insuranceServiceMapper.insertSelective(insuranceService);
        return true;
    }

//    @Override
//    public ArrayList<Integer> getServiceIdListByCompanyName(int companyId) {
//        ArrayList<Integer> integerArrayList = new ArrayList<>();
//        List<InsuranceService> insuranceServiceList = new ArrayList<>();
//        InsuranceService insuranceService = new InsuranceService();
//
//        InsuranceServiceExample example = new InsuranceServiceExample();
//        InsuranceServiceExample.Criteria criteria = example.createCriteria();
//        criteria.andCompanyIdEqualTo(companyId);
//        insuranceServiceList = insuranceServiceMapper.selectByExample(example);
//        return integerArrayList;
//    }



    @Override
    public InsuranceService selectByServiceName(String serviceName) {
        InsuranceService insuranceService = new InsuranceService();
        InsuranceServiceExample example=new InsuranceServiceExample();
        InsuranceServiceExample.Criteria criteria=example.createCriteria();
        criteria.andServiceNameEqualTo(serviceName);
        try {
            List<InsuranceService> services = new ArrayList<>();
            services = insuranceServiceMapper.selectByExample(example);
            if(!services.isEmpty())insuranceService=services.get(0);
            insuranceService.setInsuranceCompany(insuranceCompanyService.selectById(String.valueOf(insuranceService.getCompanyId())));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return insuranceService;
    }

    @Override
    public List<Integer> getServiceIdListByServiceName(String serviceName) {
        List<Integer> serviceIdList = new ArrayList<>();
        InsuranceServiceExample example=new InsuranceServiceExample();
        InsuranceServiceExample.Criteria criteria=example.createCriteria();
        criteria.andServiceNameLike("%"+serviceName+"%").andIsDeletedEqualTo(false);
        try {
            List<InsuranceService> services = new ArrayList<>();
            services = insuranceServiceMapper.selectByExample(example);
            for(int i=0;i<services.size();i++)
                serviceIdList.add(services.get(i).getId());
               } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return serviceIdList;
    }

    @Override
    public List<Integer> getServiceIdListByCompanyId(Integer companyId) {
        List<Integer> serviceIdList = new ArrayList<>();
        InsuranceServiceExample example=new InsuranceServiceExample();
        InsuranceServiceExample.Criteria criteria=example.createCriteria();
        criteria.andCompanyIdEqualTo(companyId).andIsDeletedEqualTo(false);
        try {
            List<InsuranceService> services = new ArrayList<>();
            services = insuranceServiceMapper.selectByExample(example);
            for(int i=0;i<services.size();i++)
                serviceIdList.add(services.get(i).getId());
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return serviceIdList;
    }

    @Override
    public List<Integer> getServiceIdListByIndustry(String industry) {
        List<Integer> serviceIdList = new ArrayList<>();
        InsuranceServiceExample example=new InsuranceServiceExample();
        InsuranceServiceExample.Criteria criteria=example.createCriteria();
        criteria.andIndustryLike("%"+industry+"%").andIsDeletedEqualTo(false);
        try {
            List<InsuranceService> services = new ArrayList<>();
            services = insuranceServiceMapper.selectByExample(example);
            for(int i=0;i<services.size();i++)
                serviceIdList.add(services.get(i).getId());
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return serviceIdList;
    }


    public InsuranceServiceExample setParamOfCriteria(InsuranceService insuranceService) {
        InsuranceServiceExample example = new InsuranceServiceExample();
        String orderByStr = "";
        if (insuranceService.getOrderByOne() != null && !"".equals(insuranceService.getOrderByOne()))
            orderByStr = orderByStr /*+ "'"*/ + insuranceService.getOrderByOne() + " ASC, ";
        if (insuranceService.getOrderByTwo() != null && !"".equals(insuranceService.getOrderByTwo()))
            orderByStr = orderByStr /*+ "'"*/ + insuranceService.getOrderByTwo() + " ASC, ";
        if (insuranceService.getOrderByThree() != null && !"".equals(insuranceService.getOrderByThree()))
            orderByStr = orderByStr /*+ "'"*/ + insuranceService.getOrderByThree() + " ASC, ";
        if (orderByStr.endsWith(", ")) orderByStr = orderByStr.substring(0, orderByStr.length() - 2);
        if (orderByStr != null && !orderByStr.equals("")) example.setOrderByClause(orderByStr);

        InsuranceServiceExample.Criteria criteria = example.createCriteria();
        if (insuranceService.getServiceName() != null && !insuranceService.getServiceName().equals(""))
            criteria.andServiceNameLike("%" + insuranceService.getServiceName() + "%");
        if (insuranceService.getServicePremium() != null && !insuranceService.getServicePremium().equals(""))
            criteria.andServicePremiumEqualTo(insuranceService.getServicePremium());
        if (insuranceService.getServicePrice() != null && !insuranceService.getServicePrice().equals(""))
            criteria.andServicePriceEqualTo(insuranceService.getServicePrice());
        if (insuranceService.getServiceDuration() != null && !insuranceService.getServiceDuration().equals(""))
            criteria.andServiceDurationEqualTo(insuranceService.getServiceDuration());
        if (insuranceService.getIndustry() != null && !insuranceService.getIndustry().equals(""))
            criteria.andIndustryLike(insuranceService.getIndustry());
        if (insuranceService.getContactName() != null && !insuranceService.getContactName().equals(""))
            criteria.andContactNameLike(insuranceService.getContactName());
        if (insuranceService.getClaimMethod() != null && !insuranceService.getClaimMethod().equals(""))
            criteria.andClaimMethodLike(insuranceService.getClaimMethod());

        if (insuranceService.getCreateTimeFrom() != null && insuranceService.getCreateTimeTo() != null && !insuranceService.getCreateTimeFrom().equals("") && !insuranceService.getCreateTimeTo().equals(""))
            criteria.andCreateTimeBetween(
                    LocalDateTime.parse(insuranceService.getCreateTimeFrom(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                    LocalDateTime.parse(insuranceService.getCreateTimeTo(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        criteria.andIsDeletedEqualTo(false);
        return example;
    }
}
