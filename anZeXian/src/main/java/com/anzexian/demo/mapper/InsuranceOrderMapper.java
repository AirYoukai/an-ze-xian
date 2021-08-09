package com.anzexian.demo.mapper;

import com.anzexian.demo.entity.InsuranceOrder;
import com.anzexian.demo.entity.InsuranceOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InsuranceOrderMapper {
    long countByExample(InsuranceOrderExample example);

    int deleteByExample(InsuranceOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(InsuranceOrder record);

    int insertSelective(InsuranceOrder record);

    List<InsuranceOrder> selectByExample(InsuranceOrderExample example);

    InsuranceOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") InsuranceOrder record, @Param("example") InsuranceOrderExample example);

    int updateByExample(@Param("record") InsuranceOrder record, @Param("example") InsuranceOrderExample example);

    int updateByPrimaryKeySelective(InsuranceOrder record);

    int updateByPrimaryKey(InsuranceOrder record);
}