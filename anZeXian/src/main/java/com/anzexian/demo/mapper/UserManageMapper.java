package com.anzexian.demo.mapper;

import com.anzexian.demo.entity.UserManage;
import com.anzexian.demo.entity.UserManageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserManageMapper {
    long countByExample(UserManageExample example);
    int deleteByExample(UserManageExample example);
    int deleteByPrimaryKey(Integer id);
    int insert(UserManage record);
    int insertSelective(UserManage record);
    List<UserManage> selectByExample(UserManageExample example);
    UserManage selectByPrimaryKey(Integer id);
    int updateByExampleSelective(@Param("record") UserManage record, @Param("example") UserManageExample example);
    int updateByExample(@Param("record") UserManage record, @Param("example") UserManageExample example);
    int updateByPrimaryKeySelective(UserManage record);
    int updateByPrimaryKey(UserManage record);
}