package com.example.gmall.service;

import com.example.gmall.bean.UserInfo;

import java.util.List;

public interface UserInfoService {

    List<UserInfo> findAll();

    List<UserInfo> findAllByloginName(String loginName);

    List<UserInfo> findAllByUserInfo(UserInfo userInfo);

    void addUser(UserInfo userInfo);

    void delUserInfo(UserInfo userInfo);

    void updateById(UserInfo userInfo);
}
