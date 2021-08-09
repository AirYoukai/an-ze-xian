package com.anzexian.demo.service;

import com.anzexian.demo.entity.UserLogin;
import com.sun.org.apache.xpath.internal.operations.Bool;

public interface UserLoginService {
    Boolean insert(UserLogin newLoginCode);//插入新的loginCode
    UserLogin getUserLoginByLoginCode(String loginCode);//取之
    Boolean updateByIdSelective(UserLogin newLoginCode);//修改
    Boolean loginCodeHasLogin(String loginCode);//该loginCode是否已登录（被扫了还不算，要已经登录
}
