package com.anzexian.demo.service;

//import com.anzexian.demo.entity.InsuranceApplicant;
import com.anzexian.demo.entity.InsuranceOrder;
//import com.anzexian.demo.entity.InsuranceInsured;
import com.anzexian.demo.entity.InsuranceOrder;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface InsuranceOrderService {
    Boolean updateById(InsuranceOrder insuranceOrder);
    InsuranceOrder selectById(String id);
    PageInfo selectLike(InsuranceOrder insuranceOrder, String pageNum, String pageSize);
    void insertAfterPaySucceed(InsuranceOrder insuranceOrder);
    PageInfo getAll();
    List<InsuranceOrder> selectByBuyerId(Integer id);
    Boolean deleteById(String id);

    boolean hasOrderNotActive();
}
