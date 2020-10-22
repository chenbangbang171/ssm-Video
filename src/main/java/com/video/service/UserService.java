package com.video.service;

import com.video.pojo.User;

public interface UserService {

    Integer insertUser(String email, String password);

    String selectByEmail(String email);

    User loginUser(String email, String pwd);

    User selectByUser(String email);

    Integer updateUser(String email, String nickName, String sex, String birthday, String address);

    void upLoadImage(String photoFileName, String email);

    User selectByImg(String email);

    void updatePassWord(String email,String newPassWord);

}
