package com.example.gmall.controller;


import com.example.gmall.bean.UserInfo;
import com.example.gmall.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("findAll")
    public List<UserInfo> findAll(){
        return userInfoService.findAll();
    }
}
