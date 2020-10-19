package com.video.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private int userId;
    private String userEmail;
    private String userPhoneNum;
    private String userPassword;
    private String userCode;
    private String userNickName;
    private String userSex;
    private String userBirthday;
    private String userAddress;
    private String userImgUrl;
    private Date UsercreateTime;

}
