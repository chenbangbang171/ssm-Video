package com.video.mapper;

import com.video.pojo.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminMapper {

    Admin login(@Param("adminName") String adminName,@Param("adminPwd") String adminPwd);


}
