package com.video.controller;

import com.video.pojo.Course;
import com.video.pojo.Subject;
import com.video.service.CourseService;
import com.video.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private SubjectService subjectService;

    @RequestMapping("course/{subId}")
    public ModelAndView querySubjectById(ModelAndView modelAndView, @PathVariable(name = "subId") String subId){
        Subject subject = subjectService.querySubjectById(Integer.parseInt(subId));
        System.out.println(subject);
        List<Subject> subjects = subjectService.queryAllSubject();
        modelAndView.addObject("subjectList",subjects);
        modelAndView.addObject("subject",subject);
        modelAndView.setViewName("before/course.jsp");
        return modelAndView;
    }
}
