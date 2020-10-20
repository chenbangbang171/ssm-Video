package com.video.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.video.pojo.Course;
import com.video.pojo.QueryVoVideo;
import com.video.pojo.Speaker;
import com.video.pojo.Video;
import com.video.service.CourseService;
import com.video.service.SpeakerService;
import com.video.service.SubjectService;
import com.video.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private SpeakerService speakerService;

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

    @RequestMapping("list")
    public ModelAndView getVideoList(@RequestParam(defaultValue = "1",required = false) Integer pageNum,
                                     @RequestParam(defaultValue = "10",required = false) Integer pageSize,
                                     ModelAndView modelAndView,
                                     QueryVoVideo queryVo) {
        PageHelper.startPage(pageNum,pageSize);
        List<Video> videos = videoService.queryAllVideo(queryVo);
        PageInfo pageInfo = new PageInfo(videos);
        modelAndView.addObject("pageInfo",pageInfo);

        List<Speaker> speakerList = speakerService.queryAllSpeaker();
        List<Course> courseList = courseService.queryAllCourse();
        modelAndView.addObject("speakerList",speakerList);
        modelAndView.addObject("courseList",courseList);

        modelAndView.setViewName("behind/videoList.jsp");
        return modelAndView;
    }


}
