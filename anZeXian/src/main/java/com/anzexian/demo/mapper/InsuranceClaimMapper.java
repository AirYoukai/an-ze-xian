package com.anzexian.demo.mapper;

import com.anzexian.demo.entity.InsuranceClaim;
import com.anzexian.demo.entity.InsuranceClaimExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InsuranceClaimMapper {
    long countByExample(InsuranceClaimExample example);

    int deleteByExample(InsuranceClaimExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(InsuranceClaim record);

    int insertSelective(InsuranceClaim record);

    List<InsuranceClaim> selectByExample(InsuranceClaimExample example);

    InsuranceClaim selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") InsuranceClaim record, @Param("example") InsuranceClaimExample example);

    int updateByExample(@Param("record") InsuranceClaim record, @Param("example") InsuranceClaimExample example);

    int updateByPrimaryKeySelective(InsuranceClaim record);

    int updateByPrimaryKey(InsuranceClaim record);
}