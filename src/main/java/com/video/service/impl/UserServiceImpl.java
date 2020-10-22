package com.video.service.impl;

import com.video.mapper.UserMapper;
import com.video.pojo.User;
import com.video.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Integer insertUser(String email, String password) {
        return userMapper.insertUser(email, password);
    }

    @Override
    public String selectByEmail(String email) {
        return userMapper.selectByEmail(email);
    }

    @Override
    public User loginUser(String email, String pwd) {
        return userMapper.loginUser(email,pwd);
    }
}
