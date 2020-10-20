package com.video.controller;


import com.video.pojo.Subject;
import com.video.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;


@RestController
@RequestMapping("subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @RequestMapping("selectAll")
    public ModelAndView queryAllSubject(ModelAndView modelAndView){


        List<Subject> subjects = subjectService.queryAllSubject();
        modelAndView.addObject("subjectList",subjects);
        modelAndView.setViewName("before/index.jsp");
        return modelAndView;
    }


}
