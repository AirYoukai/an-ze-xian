package com.anzexian.demo.mapper;

import com.anzexian.demo.entity.InsuranceService;
import com.anzexian.demo.entity.InsuranceServiceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InsuranceServiceMapper {
    long countByExample(InsuranceServiceExample example);

    int deleteByExample(InsuranceServiceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(InsuranceService record);

    int insertSelective(InsuranceService record);

    List<InsuranceService> selectByExample(InsuranceServiceExample example);

    InsuranceService selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") InsuranceService record, @Param("example") InsuranceServiceExample example);

    int updateByExample(@Param("record") InsuranceService record, @Param("example") InsuranceServiceExample example);

    int updateByPrimaryKeySelective(InsuranceService record);

    int updateByPrimaryKey(InsuranceService record);
}