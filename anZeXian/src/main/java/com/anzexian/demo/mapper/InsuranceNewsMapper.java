package com.anzexian.demo.mapper;

import com.anzexian.demo.entity.InsuranceNews;
import com.anzexian.demo.entity.InsuranceNewsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InsuranceNewsMapper {
    long countByExample(InsuranceNewsExample example);

    int deleteByExample(InsuranceNewsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(InsuranceNews record);

    int insertSelective(InsuranceNews record);

    List<InsuranceNews> selectByExample(InsuranceNewsExample example);

    InsuranceNews selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") InsuranceNews record, @Param("example") InsuranceNewsExample example);

    int updateByExample(@Param("record") InsuranceNews record, @Param("example") InsuranceNewsExample example);

    int updateByPrimaryKeySelective(InsuranceNews record);

    int updateByPrimaryKey(InsuranceNews record);
}