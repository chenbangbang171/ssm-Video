package com.video.controller;

import com.video.pojo.User;
import com.video.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("user")
public class UserContoeller {

    @Autowired
    private UserService userService;

    @RequestMapping("insertUser")
    public String insertUser(HttpServletRequest request, HttpServletResponse response) {

        String email = request.getParameter("email");

        String password = request.getParameter("password");

        System.out.println(email);
        System.out.println(password);

        Integer count =  userService.insertUser(email, password);

        System.out.println(count);
        if (count > 0) {
            return "success";
        }
        return "error";

    }

    @RequestMapping("validateEmail")
    public String validateEmail(HttpServletRequest request, HttpServletResponse response) {

        String test = request.getParameter("email");

        String byEmail  = userService.selectByEmail(test);

        if(byEmail != null && byEmail !="") {
            return "error";
        }
        return "success";
    }

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
