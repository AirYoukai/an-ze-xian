package com.anzexian.demo.service;

import com.anzexian.demo.entity.InsuranceService;
import com.github.pagehelper.PageInfo;

import java.util.ArrayList;
import java.util.List;

public interface InsuranceServiceService {
    PageInfo getAll();
    PageInfo list(String pageNum, String pageSize);
    PageInfo selectLike(InsuranceService insuranceService, String pageNum, String pageSize);
    //    boolean updateById(InsuranceService insuranceService);
//    boolean deleteById(String id);
    InsuranceService selectById(String id);

    Boolean updateById(InsuranceService insuranceService);

    Boolean deleteById(String id);

    Boolean insert(InsuranceService insuranceService);

    InsuranceService selectByServiceName(String serviceName);
///////////三个接口都是供订单查询调用的！/////////////////////////////
    List<Integer> getServiceIdListByServiceName(String serviceName);

    List<Integer> getServiceIdListByCompanyId(Integer companyId);

    List<Integer> getServiceIdListByIndustry(String industry);
}
