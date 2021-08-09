package com.anzexian.demo.service;

import com.anzexian.demo.entity.UserManage;
import com.anzexian.demo.entity.UserManageExample;
import com.anzexian.demo.mapper.UserManageMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.anzexian.demo.util.Constant.*;

@Service
public class UserManageServiceImpl implements UserManageService {
    @Autowired
    private UserManageMapper userManageMapper;

    @Override
    public PageInfo getALl() {
        UserManageExample example = new UserManageExample();
        UserManageExample.Criteria criteria = example.createCriteria();
        criteria.andIsDeletedEqualTo(false);
        List<UserManage> userManageList = userManageMapper.selectByExample(example);
        PageInfo pageInfo = new PageInfo(userManageList);
        return pageInfo;
    }

    @Override
    public PageInfo list(String pageNum, String pageSize) {
//        PageInfo pageInfo=new PageInfo();
        Page<Object> objects = PageHelper.startPage(Integer.parseInt(pageNum), Integer.parseInt(pageSize));
        List<UserManage> userManageList = userManageMapper.selectByExample(null);
        PageInfo pageInfo = new PageInfo(userManageList);
        return pageInfo;
    }


    @Override
    public PageInfo selectLike(UserManage userManage, String pageNum, String pageSize) {
        List<UserManage> userManageList = new ArrayList<>();
        UserManageExample example = setParamOfCriteria(userManage);
        Page<Object> objects = PageHelper.startPage(Integer.parseInt(pageNum), Integer.parseInt(pageSize));
        userManageList = this.userManageMapper.selectByExample(example);
        PageInfo pageInfo = new PageInfo(userManageList);
        return pageInfo;
    }

//    @Override
//    public boolean updateById(UserManage userManage) {tryLogin
//        return userManageMapper.updateByPrimaryKeySelective(userManage)>0;
//    }

    @Override
    public boolean updateById(UserManage userManage) {
        userManageMapper.updateByPrimaryKeySelective(userManage);
        return true;
    }

    @Override
    public boolean deleteById(String id) {
        UserManage userManage = new UserManage();
        userManage.setId(Integer.parseInt(id));
        userManage.setIsDeleted(true);
        userManageMapper.updateByPrimaryKeySelective(userManage);
        return true;
    }

    @Override
    public UserManage tryLogin(String openId) {
        List<UserManage> userManagelist = new ArrayList<>();
        UserManageExample example = new UserManageExample();
        UserManageExample.Criteria criteria = example.createCriteria();
//        criteria.andUserNameEqualTo(openId);
        criteria.andOpenIdEqualTo(openId);
        UserManage userManage = new UserManage();
        try {
            userManagelist = this.userManageMapper.selectByExample(example);
            userManage = userManagelist.get(0);
//            System.out.println(userManageArrayListlist);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return userManage;
    }

    @Override
    public UserManage loginWeb(UserManage userManage) {
        List<UserManage> userManageArrayListlist = new ArrayList<>();
        UserManageExample example = new UserManageExample();
        UserManageExample.Criteria criteria = example.createCriteria();
        criteria.andUserNameEqualTo(userManage.getUserName())
                .andPasswordEqualTo(userManage.getPassword());
        UserManage res = new UserManage();
        try {
            userManageArrayListlist = this.userManageMapper.selectByExample(example);
            res = userManageArrayListlist.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public Boolean signup(UserManage userManage) {
        userManageMapper.insertSelective(userManage);
        return true;
    }

//    @Override
//    public Boolean signup(UserManage userManage) {
//        return userManageMapper.insertSelective(userManage)>0;
//    }

    @Override
    public UserManage selectById(String id) {
        UserManage userManage = new UserManage();
        try {
            userManage = this.userManageMapper.selectByPrimaryKey(Integer.parseInt(id));
//            System.out.println(userManageArrayListlist);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return userManage;
    }

//    public void insertLotsOfData() {
//        UserManage userManage = new UserManage();
//        userManage.setCreateTime(LocalDateTime.now());
//        for (int i = 0; i < 200; i++) {
//            userManage.setUserName(getRandomString(10));
//            userManage.setOpenId(getRandomNumberString(11));
//            userManage.setPassword(getRandomString(10));
//            userManage.setUserAge(new Random().nextInt(100));
//            userManage.setUserSex("male");
//            System.out.println("userManage is " + userManage);
//            userManageMapper.insertSelective(userManage);
//        }
//    }

    @Override
    public UserManage selectByUserName(String userName) {
        List<UserManage> userManagelist = new ArrayList<>();
        UserManageExample example = new UserManageExample();
        UserManageExample.Criteria criteria = example.createCriteria();
        criteria.andUserNameEqualTo(userName);
        try {
            userManagelist = this.userManageMapper.selectByExample(example);
//            System.out.println(userManageArrayListlist);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        return userManagelist.get(0);
    }

    @Override
    public List<UserManage> getAllStaffs() {
        List<UserManage> userManagelist = new ArrayList<>();
        UserManageExample example = new UserManageExample();
        UserManageExample.Criteria criteria = example.createCriteria();
        criteria.andUserRoleEqualTo(USER_ROLE_STAFF);
        try {
            userManagelist = this.userManageMapper.selectByExample(example);
//            System.out.println(userManageArrayListlist);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return userManagelist;
    }

    @Override
    public List<UserManage> getAllManagers() {
        List<UserManage> userManagelist = new ArrayList<>();
        UserManageExample example = new UserManageExample();
        UserManageExample.Criteria criteria = example.createCriteria();
        criteria.andUserRoleEqualTo(USER_ROLE_BOSS);
        try {
            userManagelist = this.userManageMapper.selectByExample(example);
//            System.out.println(userManageArrayListlist);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return userManagelist;
    }

    public static String getRandomNumberString(int length) {
        String str = "0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(str.length());
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    public static String getRandomString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(str.length());
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    public static UserManageExample setParamOfCriteria(UserManage userManage) {
        UserManageExample example = new UserManageExample();
        String orderByStr = "";

        if (userManage.getOrderByOne() != null && !userManage.getOrderByOne().equals(""))
            orderByStr = orderByStr + userManage.getOrderByOne() + " ASC, ";
        if (userManage.getOrderByTwo() != null && !userManage.getOrderByTwo().equals(""))
            orderByStr = orderByStr + userManage.getOrderByTwo() + " ASC, ";
        if (userManage.getOrderByThree() != null && !userManage.getOrderByThree().equals(""))
            orderByStr = orderByStr + userManage.getOrderByThree() + " ASC, ";
        if (orderByStr.endsWith(", ")) orderByStr = orderByStr.substring(0, orderByStr.length() - 2);
        if (orderByStr != null && !orderByStr.equals("")) example.setOrderByClause(orderByStr);

        UserManageExample.Criteria criteria = example.createCriteria();
        if (userManage.getUserName() != null && !userManage.getUserName().equals(""))
            criteria.andUserNameLike("%" + userManage.getUserName() + "%");
        if (userManage.getPassword() != null && !userManage.getPassword().equals(""))
            criteria.andPasswordLike("%" + userManage.getPassword() + "%");
        if (userManage.getOpenId() != null && !userManage.getOpenId().equals(""))
            criteria.andOpenIdLike("%" + userManage.getOpenId() + "%");
        if (userManage.getUserRealName() != null && !userManage.getUserRealName().equals(""))
            criteria.andUserRealNameLike("%" + userManage.getUserRealName() + "%");
        if (userManage.getUserSex() != null && !userManage.getUserSex().equals(""))
            criteria.andUserSexLike("%" + userManage.getUserSex() + "%");
        if (userManage.getUserRole() != null && !userManage.getUserRole().equals(""))
            criteria.andUserRoleEqualTo(userManage.getUserRole());
        if (userManage.getCreateTimeFrom() != null && userManage.getCreateTimeTo() != null
                && !userManage.getCreateTimeFrom().equals("") && !userManage.getCreateTimeTo().equals(""))
            criteria.andCreateTimeBetween(
                    LocalDateTime.parse(userManage.getCreateTimeFrom(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                    LocalDateTime.parse(userManage.getCreateTimeTo(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            );


        criteria.andIsDeletedEqualTo(false);
        return example;
    }
}