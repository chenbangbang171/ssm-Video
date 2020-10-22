package com.video.service.Impl;

import com.video.mapper.AdminMapper;
import com.video.pojo.Admin;
import com.video.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;
    @Override
    public Admin login(String adminName, String adminPwd) {
        return adminMapper.login(adminName,adminPwd);
    }
}
