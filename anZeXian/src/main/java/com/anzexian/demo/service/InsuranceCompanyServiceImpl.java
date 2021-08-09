package com.anzexian.demo.service;

import com.anzexian.demo.entity.InsuranceCompany;
import com.anzexian.demo.entity.InsuranceCompanyExample;
import com.anzexian.demo.entity.InsuranceService;
import com.anzexian.demo.entity.InsuranceServiceExample;
import com.anzexian.demo.mapper.InsuranceCompanyMapper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InsuranceCompanyServiceImpl implements InsuranceCompanyService {
    @Autowired
    private InsuranceCompanyMapper insuranceCompanyMapper;
    @Override
    public int getCompanyId(String companyName) {
        List<InsuranceCompany> insuranceCompanyList = new ArrayList<>();
        InsuranceCompanyExample example=new InsuranceCompanyExample();
        InsuranceCompanyExample.Criteria criteria=example.createCriteria();
        criteria.andCompanyNameEqualTo(companyName);
        insuranceCompanyList = this.insuranceCompanyMapper.selectByExample(example);
        return insuranceCompanyList.isEmpty()?-1:insuranceCompanyList.get(0).getId();
    }

    @Override
    public int insertNewCompany(String companyName) {
        InsuranceCompany insuranceCompany = new InsuranceCompany();
        insuranceCompany.setCompanyName(companyName);
        insuranceCompanyMapper.insertSelective(insuranceCompany);
        return insuranceCompany.getId();
    }

    @Override
    public List<InsuranceCompany> getAllCompany() {
        List<InsuranceCompany> insuranceCompanyArrayList = new ArrayList<>();
        insuranceCompanyArrayList=insuranceCompanyMapper.selectByExample(null);
        return insuranceCompanyArrayList;
    }

    @Override
    public InsuranceCompany selectById(String id) {
        InsuranceCompany insuranceCompany = new InsuranceCompany();
        try {
            insuranceCompany=insuranceCompanyMapper.selectByPrimaryKey(Integer.parseInt(id));
        }catch (NullPointerException e) {
            e.printStackTrace();
        }
        return insuranceCompany;
    }

    @Override
    public PageInfo getALl() {
        return null;
    }

    @Override
    public PageInfo list(String pageNum, String pageSize) {
        return null;
    }

    @Override
    public PageInfo selectLike(InsuranceService insuranceService, String pageNum, String pageSize) {
        return null;
    }

    @Override
    public Boolean updateById(InsuranceService insuranceService) {
        return null;
    }

    @Override
    public Boolean deleteById(String id) {
        return null;
    }

    @Override
    public Boolean insert(InsuranceService insuranceService) {
        return null;
    }
}
