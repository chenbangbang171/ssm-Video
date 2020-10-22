package com.video.mapper;


import com.video.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    Integer insertUser(@Param("email") String email, @Param("password") String password);

    String selectByEmail(@Param("email") String email);

    User loginUser(@Param("email") String email, @Param("pwd") String pwd);

    User selectByUser(@Param("email") String email);

    Integer updateUser(@Param("email") String email, @Param("nickName") String nickName, @Param("sex") String sex, @Param("birthday") String birthday, @Param("address") String address);

    Integer upLoadImage(@Param("email") String email,@Param("photoFileName") String photoFileName);

    User selectByImg(@Param("email") String email);

    void updatePassWord(@Param("email") String email, @Param("newPassWord") String newPassWord);
}
