package com.anzexian.demo.service;

import com.anzexian.demo.entity.UserManage;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface UserManageService {
    PageInfo getALl();

    PageInfo list(String pageNum, String pageSize);

    PageInfo selectLike(UserManage userManage,String pageNum, String pageSize);

    //    boolean tryLogin(UserManage userManage);
    boolean updateById(UserManage userManage);

    boolean deleteById(String id);

    UserManage tryLogin(String openId);
    UserManage loginWeb(UserManage userManage);
    Boolean signup(UserManage userManage);

    UserManage selectById(String id);

//    void insertLotsOfData();

    UserManage selectByUserName(String openId);

    List<UserManage> getAllStaffs();

    List<UserManage> getAllManagers();
}