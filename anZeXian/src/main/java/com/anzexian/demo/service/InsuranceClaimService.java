package com.anzexian.demo.service;

import com.anzexian.demo.entity.InsuranceClaim;
import com.github.pagehelper.PageInfo;

import java.util.ArrayList;
import java.util.List;

public interface InsuranceClaimService {
    PageInfo getAll();
    PageInfo list(String pageNum, String pageSize);
    PageInfo selectLike(InsuranceClaim insuranceClaim, String pageNum, String pageSize);
    InsuranceClaim selectById(String id);
    Boolean updateById(InsuranceClaim insuranceClaim);
    Boolean deleteById(String id);
    Boolean insert(InsuranceClaim insuranceClaim);
    List<InsuranceClaim> selectByClaimantId(Integer id);
    boolean hasClaimsForManager();
    boolean hasClaimsForStaff();
}
