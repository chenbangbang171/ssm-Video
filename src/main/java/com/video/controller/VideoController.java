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

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
        modelAndView.addObject("video", video);
        modelAndView.addObject("course", course);

        modelAndView.setViewName("before/section.jsp");
        return modelAndView;
    }

    @RequestMapping("list")
    public ModelAndView getVideoList(@RequestParam(defaultValue = "1", required = false) Integer pageNum,
                                     @RequestParam(defaultValue = "10", required = false) Integer pageSize,
                                     ModelAndView modelAndView,
                                     QueryVoVideo queryVo) {
        PageHelper.startPage(pageNum, pageSize);
        List<Video> videos = videoService.queryAllVideo(queryVo);
        PageInfo pageInfo = new PageInfo(videos);
        modelAndView.addObject("pageInfo", pageInfo);

        List<Speaker> speakerList = speakerService.queryAllSpeaker();
        List<Course> courseList = courseService.queryAllCourse();
        modelAndView.addObject("speakerList", speakerList);
        modelAndView.addObject("courseList", courseList);

        modelAndView.setViewName("behind/videoList.jsp");
        return modelAndView;
    }

    @RequestMapping("videoDel")
    public String videoDel(HttpServletRequest request) {
        String id = request.getParameter("id");
        videoService.deleteVideoById(Integer.parseInt(id));
        return "success";
    }


    @RequestMapping("delBatchVideos")
    public void delBatchVideos(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String checkedArr = request.getParameter("checkedArr");
        String[] ids = checkedArr.split(",");
        videoService.deleteVideos(ids);
        response.sendRedirect("/video/list");
    }


    @RequestMapping("addVideo")
    public ModelAndView addVideo(ModelAndView modelAndView) throws IOException {
        List<Speaker> speakerList = speakerService.queryAllSpeaker();
        List<Course> courseList = courseService.queryAllCourse();

        modelAndView.addObject("speakerList", speakerList);
        modelAndView.addObject("courseList", courseList);
        modelAndView.setViewName("behind/addVideo.jsp");
        return modelAndView;
    }


    @RequestMapping("saveOrUpdate")
    public void saveOrUpdate(HttpServletRequest request, Video video, HttpServletResponse response) throws IOException {
        String id = request.getParameter("videoId");

        if (null != id) {
            video.setVideoId(Integer.parseInt(id));
            videoService.updateVideo(video);
        } else {
            videoService.addVideo(video);
        }

        response.sendRedirect("/video/list");
    }


    @RequestMapping("edit")
    public ModelAndView edit(HttpServletRequest request, ModelAndView modelAndView) {
        String id = request.getParameter("id");
        Video video = videoService.getVideoById(Integer.parseInt(id));
        List<Speaker> speakerList = speakerService.queryAllSpeaker();
        List<Course> courseList = courseService.queryAllCourse();

        modelAndView.addObject("video", video);
        modelAndView.addObject("speakerList", speakerList);
        modelAndView.addObject("courseList", courseList);
        modelAndView.setViewName("behind/addVideo.jsp");
        return modelAndView;
    }



}
