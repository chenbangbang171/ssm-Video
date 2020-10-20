package com.video.service;

import com.video.pojo.User;

public interface UserService {

    Integer insertUser(String email, String password);

    String selectByEmail(String email);

    User loginUser(String email, String pwd);
}
