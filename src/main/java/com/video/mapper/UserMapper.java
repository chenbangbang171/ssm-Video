package com.video.mapper;

import com.video.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    Integer insertUser(@Param("email") String email, @Param("password") String password);

    String selectByEmail(@Param("email") String email);

    User loginUser(@Param("email") String email, @Param("pwd") String pwd);
}
