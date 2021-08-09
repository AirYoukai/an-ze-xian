package com.anzexian.demo.service;

import com.anzexian.demo.entity.InsuranceNews;
import com.github.pagehelper.PageInfo;

public interface InsuranceNewsService {
    Boolean updateById(InsuranceNews insuranceNewsService);

    InsuranceNews selectById(String id);

    PageInfo selectLike(InsuranceNews insuranceNews, String pageNum, String pageSize);

//    void insertAfterPaySucceed(InsuranceNews insuranceNewsService);


    Boolean deleteById(String id);

    Boolean insert(InsuranceNews insuranceNews);

    PageInfo getAll();
}
