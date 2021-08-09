package com.anzexian.demo.service;

import com.anzexian.demo.entity.UserLogin;
import com.anzexian.demo.entity.UserLoginExample;
import com.anzexian.demo.mapper.UserLoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserLoginServiceImpl implements UserLoginService {
    @Autowired
    private UserLoginMapper userLoginMapper;

    @Override
    public Boolean insert(UserLogin newLoginCode) {
        userLoginMapper.insertSelective(newLoginCode);
        return true;
    }

    @Override
    public UserLogin getUserLoginByLoginCode(String loginCode) {
        List<UserLogin> userLoginList = new ArrayList<>();
        UserLoginExample example = new UserLoginExample();
        UserLoginExample.Criteria criteria = example.createCriteria();
        criteria.andLoginCodeEqualTo(loginCode);
        UserLogin userLogin = new UserLogin();
        try {
            userLoginList = userLoginMapper.selectByExample(example);
            if (!userLoginList.isEmpty()){
                userLogin = userLoginList.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userLogin;
    }


    @Override
    public Boolean updateByIdSelective(UserLogin userLogin) {
        userLoginMapper.updateByPrimaryKeySelective(userLogin);
        return true;
    }

    @Override
    public Boolean loginCodeHasLogin(String loginCode) {//检测是否已登录。弃用。
        List<UserLogin> userLoginList = new ArrayList<>();
        UserLoginExample example = new UserLoginExample();
        UserLoginExample.Criteria criteria = example.createCriteria();
        criteria.andLoginCodeEqualTo(loginCode);
        UserLogin userLogin = new UserLogin();
        try {
            userLogin = userLoginMapper.selectByExample(example).get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userLogin.getHaslogin() != null && userLogin.getHaslogin() == true;
    }
}
