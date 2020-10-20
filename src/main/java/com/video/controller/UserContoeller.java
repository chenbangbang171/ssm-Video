package com.video.controller;

import com.video.pojo.User;
import com.video.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("user")
public class UserContoeller {

    @Autowired
    private UserService userService;

    @RequestMapping("loginUser")
    public String loginUser(HttpServletRequest request, HttpServletResponse response){
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = userService.loginUser(email, password);
//         return user != null ?  "success" : "failure";
            if (user != null){
                request.getSession(false).setAttribute("userAccount",user);
                return "success";
            }
            return "failure";
    }

}
