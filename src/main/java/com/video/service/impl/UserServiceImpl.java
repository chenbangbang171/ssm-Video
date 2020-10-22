package com.video.service.Impl;

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

    @Override
    public User selectByUser(String email) {
        return userMapper.selectByUser(email);
    }

    @Override
    public Integer updateUser(String email, String nickName, String sex, String birthday, String address) {
        return userMapper.updateUser(email,nickName,sex,birthday,address);
    }

    @Override
    public void upLoadImage(String email, String photoFileName) {
        userMapper.upLoadImage(email, photoFileName);
    }

    @Override
    public User selectByImg(String email) {
        return userMapper.selectByImg(email);
    }

    @Override
    public void updatePassWord(String email, String newPassWord) {
        userMapper.updatePassWord(email,newPassWord);
    }
}
