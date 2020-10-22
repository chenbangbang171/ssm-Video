package com.video.controller;


import com.video.pojo.Subject;
import com.video.pojo.User;
import com.video.service.SubjectService;
import com.video.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@RestController
@RequestMapping("subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private UserService userService;

    @RequestMapping("selectAll")
    public ModelAndView queryAllSubject(HttpServletRequest request, HttpServletResponse response, ModelAndView modelAndView){

        String email = (String)request.getSession().getAttribute("email");

        User user = userService.selectByUser(email);

        modelAndView.addObject("user",user);

        List<Subject> subjects = subjectService.queryAllSubject();
        modelAndView.addObject("subjectList",subjects);
        modelAndView.setViewName("before/index.jsp");
        return modelAndView;
    }


}
