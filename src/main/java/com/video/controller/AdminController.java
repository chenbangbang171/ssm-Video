package com.video.controller;

import com.video.pojo.Admin;
import com.video.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**
     * 后台登录入口
     *
     * @param modelAndView
     * @return
     * @throws Exception
     */
    @RequestMapping("login-view")
    public ModelAndView loginView(ModelAndView modelAndView) throws Exception {
        modelAndView.setViewName("behind/login.jsp");
        return modelAndView;
    }

    /**
     * 后台登录
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("login")
    public String login(HttpServletRequest request, HttpServletResponse response){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Admin admin = adminService.login(username, password);
        request.getSession(false).setAttribute("amdin",admin);

        return admin != null ? "success" : "failure";
    }

}
