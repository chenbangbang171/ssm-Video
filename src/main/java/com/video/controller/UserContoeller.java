package com.video.controller;

import com.video.pojo.User;
import com.video.service.UserService;
import com.video.utils.MailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("user")
public class UserContoeller {

    @Autowired
    private UserService userService;

    @RequestMapping("insertUser")
    public String insertUser(HttpServletRequest request, HttpServletResponse response, ModelAndView modelAndView) {

        String email = request.getParameter("email");

        String password = request.getParameter("password");

        Integer count = userService.insertUser(email, password);

        User user = userService.selectByUser(email);

        modelAndView.addObject("user", user);

        if (count > 0) {
            return "success";
        }
        return "error";

    }

    @RequestMapping("validateEmail")
    public String validateEmail(HttpServletRequest request, HttpServletResponse response) {

        String test = request.getParameter("email");

        String byEmail = userService.selectByEmail(test);

        if (byEmail != null && byEmail != "") {
            return "error";
        }
        return "success";
    }

    @RequestMapping("validatePassword")
    public String validatePassword(HttpServletRequest request, HttpServletResponse response) {

        String password = request.getParameter("password");

        String email = (String) request.getSession().getAttribute("email");

        User user = userService.selectByImg(email);
        String userPassword = user.getUserPassword();

        return userPassword.equals(password) ? "success" : "error0";
    }

    @RequestMapping("loginUser")
    public String loginUser(HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("email");

        request.getSession().setAttribute("email", email);

        String password = request.getParameter("password");
        User user = userService.loginUser(email, password);
//         return user != null ?  "success" : "failure";

        if (user != null) {
            request.getSession(false).setAttribute("userAccount", user);
            return "success";
        }
        return "failure";
    }


    @RequestMapping("showMyProfile")
    public ModelAndView showMyProfile(HttpServletRequest request, HttpServletResponse response, ModelAndView modelAndView) {

        String email = (String) request.getSession().getAttribute("email");

        User user = userService.selectByImg(email);

        modelAndView.addObject("user", user);

        modelAndView.setViewName("before/my_profile.jsp");

        return modelAndView;
    }

    @RequestMapping("loginOut2")
    public void loginOut2(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws IOException {

        session.setAttribute("userAccount",null);



        response.sendRedirect("/subject/selectAll");
    }

    @RequestMapping("changeProfile")
    public ModelAndView changeProfile(HttpServletRequest request, HttpServletResponse response, ModelAndView modelAndView) {

        String email = (String) request.getSession().getAttribute("email");

        User user = userService.selectByImg(email);

        modelAndView.addObject("user", user);

        modelAndView.setViewName("before/change_profile.jsp");

        return modelAndView;
    }

    @RequestMapping("updateUser")
    public ModelAndView updateUser(HttpServletRequest request, HttpServletResponse response, ModelAndView modelAndView) {

        String email = (String) request.getSession().getAttribute("email");

        String nickName = request.getParameter("nickName");
        String sex = request.getParameter("sex");
        String birthday = request.getParameter("birthday");
        String address = request.getParameter("address");

        Integer count = userService.updateUser(email, nickName, sex, birthday, address);

        if (count > 0) {

            User user = userService.selectByImg(email);

            modelAndView.addObject("user", user);

            modelAndView.setViewName("before/my_profile.jsp");
        }
        return modelAndView;
    }

    @RequestMapping("changeAvatar")
    public ModelAndView changeAvatar(ModelAndView modelAndView, HttpServletRequest request, HttpServletResponse response) {

        String email = (String) request.getSession().getAttribute("email");

        User user = userService.selectByImg(email);

        modelAndView.addObject("user", user);

        modelAndView.setViewName("before/change_avatar.jsp");

        return modelAndView;
    }

    @RequestMapping("upLoadImage")
    public ModelAndView upLoadImage(MultipartFile image_file, ModelAndView modelAndView, HttpServletRequest request, HttpServletResponse response) {

        String email = (String) request.getSession().getAttribute("email");

        //上传地址
        String path = "D:\\servlet\\apache-tomcat-8.5.41\\webapps\\video\\";
        //上传的文件名
        String photoFileName = image_file.getOriginalFilename();
        System.out.println("上传的文件名：" + photoFileName);

        //上传文件
        File file = new File(path + photoFileName);
        //上传方法
        try {
            image_file.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        userService.upLoadImage(email, photoFileName);

        User user = userService.selectByImg(email);

        modelAndView.addObject("user", user);

        modelAndView.setViewName("before/my_profile.jsp");

        return modelAndView;
    }

    @RequestMapping("passwordSafe")
    public ModelAndView passwordSafe(HttpServletRequest request, ModelAndView modelAndView) {
        String email = (String) request.getSession().getAttribute("email");
        User user = userService.selectByImg(email);

        modelAndView.addObject("user", user);

        modelAndView.setViewName("before/password_safe.jsp");

        return modelAndView;

    }

    @RequestMapping("updatePassword")
    public ModelAndView updatePassword(HttpServletRequest request, ModelAndView modelAndView) {
        String email = (String) request.getSession().getAttribute("email");
        User user = userService.selectByImg(email);

        String newPassword = request.getParameter("newPassword");
        userService.updatePassWord(email, newPassword);

        modelAndView.addObject("user", user);

        modelAndView.setViewName("before/my_profile.jsp");

        return modelAndView;

    }

    @RequestMapping("forgetPassword")
    public ModelAndView forgetPassword(HttpServletRequest request, ModelAndView modelAndView) {

        modelAndView.setViewName("before/forget_password.jsp");

        return modelAndView;

    }

    @RequestMapping("sendEmail")
    public String sendEmail(HttpServletRequest request, Model model) {
        String email = request.getParameter("email");
        User user = userService.selectByImg(email);
        if (null == user) {
            return "hasNoUser";
        } else {
            String validateCode = MailUtils.getValidateCode(6);
            MailUtils.sendMail("1713085499@qq.com", "你好，您要重置密码的验证码为： " + validateCode, "密码重置邮件");


            return "success," + validateCode;
        }

    }

    @RequestMapping("validateEmailCode")
    public ModelAndView validateEmailCode(HttpServletRequest request, HttpServletResponse response, ModelAndView modelAndView) throws IOException {
        String code = request.getParameter("code");
        String validateCode = request.getParameter("validateCode");

        String email = request.getParameter("email");
        if (validateCode.equals(code)) {
            modelAndView.addObject("email", email);
            modelAndView.setViewName("before/reset_password.jsp");
            return modelAndView;
        } else {
            modelAndView.setViewName("before/forget_password.jsp");
            return modelAndView;
        }

    }

    @RequestMapping("resetPassword")
    public void resetPassword(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = request.getParameter("email");

        String password = request.getParameter("password");
        userService.updatePassWord(email, password);

        response.sendRedirect("/subject/selectAll");

    }


}
