package com.video.controller;

import com.video.pojo.Course;
import com.video.pojo.Video;
import com.video.service.CourseService;
import com.video.service.SubjectService;
import com.video.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private CourseService courseService;

    @RequestMapping("showVideo")
    public ModelAndView getVideo(HttpServletRequest request, HttpServletResponse response) {
        String videoId = request.getParameter("videoId");
        String subName = request.getParameter("subName");

        Video video = videoService.getVideoById(Integer.parseInt(videoId));
        Course course = courseService.queryCourseById(video.getVideoCourseId());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("subName", subName);
        modelAndView.addObject("subjectList", subjectService.queryAllSubject());
        modelAndView.addObject("video",video );
        modelAndView.addObject("course",course );

        modelAndView.setViewName("before/section.jsp");
        return modelAndView;
    }
}
