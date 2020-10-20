package com.video.service;

import com.video.pojo.User;
import org.springframework.stereotype.Service;


public interface UserService {
    User loginUser(String email,String pwd);
}
