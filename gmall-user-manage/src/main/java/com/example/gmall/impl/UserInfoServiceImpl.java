package com.example.gmall.impl;

import com.example.gmall.bean.UserInfo;
import com.example.gmall.mapper.UserInfoMapper;
import com.example.gmall.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Override
    public List<UserInfo> findAll() {
        return userInfoMapper.selectAll();
    }

    @Override
    public List<UserInfo> findAllByloginName(String loginName) {
        Example example = new Example(UserInfo.class);
        example.createCriteria().andLike("loginName","%"+loginName+"%");
        return userInfoMapper.selectByExample(example);
    }

    @Override
    public List<UserInfo> findAllByUserInfo(UserInfo userInfo) {
        Example example = new Example(UserInfo.class);
        example.createCriteria().andLike("loginName","%"+userInfo.getLoginName()+"%");
        return userInfoMapper.selectByExample(example);
    }

    @Override
    public void addUser(UserInfo userInfo) {
        userInfoMapper.insert(userInfo);
    }

    @Override
    public void delUserInfo(UserInfo userInfo) {
        userInfoMapper.delete(userInfo);
    }

    @Override
    public void updateById(UserInfo userInfo) {
      //  userInfoMapper.updateByPrimaryKey(userInfo);
        /**
         * 根据非主键进行修改
         */
        Example example = new Example(UserInfo.class);
        example.createCriteria().andEqualTo("nickName",userInfo.getNickName());
                //第一个参数，封装修改的类容，第二个参数example
        userInfoMapper.updateByExampleSelective(userInfo,example);
    }
}
