package com.anzexian.demo.service;

import com.anzexian.demo.entity.InsuranceCompany;
import com.anzexian.demo.entity.InsuranceService;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface InsuranceCompanyService {
    int getCompanyId(String companyName);

    int insertNewCompany(String companyName);

    InsuranceCompany selectById(String id);
    //后面这些通通没有用过
    List<InsuranceCompany> getAllCompany();
    PageInfo getALl();
    PageInfo list(String pageNum, String pageSize);
    PageInfo selectLike(InsuranceService insuranceService, String pageNum, String pageSize);
    //    boolean updateById(InsuranceService insuranceService);
//    boolean deleteById(String id);

    Boolean updateById(InsuranceService insuranceService);

    Boolean deleteById(String id);

    Boolean insert(InsuranceService insuranceService);
}
