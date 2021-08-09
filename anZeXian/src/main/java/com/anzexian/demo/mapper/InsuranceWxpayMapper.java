package com.anzexian.demo.mapper;

import com.anzexian.demo.entity.InsuranceWxpay;
import com.anzexian.demo.entity.InsuranceWxpayExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InsuranceWxpayMapper {
    long countByExample(InsuranceWxpayExample example);

    int deleteByExample(InsuranceWxpayExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(InsuranceWxpay record);

    int insertSelective(InsuranceWxpay record);

    List<InsuranceWxpay> selectByExample(InsuranceWxpayExample example);

    InsuranceWxpay selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") InsuranceWxpay record, @Param("example") InsuranceWxpayExample example);

    int updateByExample(@Param("record") InsuranceWxpay record, @Param("example") InsuranceWxpayExample example);

    int updateByPrimaryKeySelective(InsuranceWxpay record);

    int updateByPrimaryKey(InsuranceWxpay record);
}