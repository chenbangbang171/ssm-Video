package com.video.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.video.pojo.QueryVoVideo;
import com.video.pojo.Speaker;
import com.video.service.SpeakerService;
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
@RequestMapping("speaker")
public class SpeakerController {

    @Autowired
    private SpeakerService speakerService;

    @RequestMapping("showSpeakerList")
    public ModelAndView showSpeakerList(ModelAndView modelAndView,
                                        @RequestParam(defaultValue = "1", required = false) Integer pageNum,
                                        @RequestParam(defaultValue = "10", required = false) Integer pageSize
    ) {

        PageHelper.startPage(pageNum, pageSize);
        List<Speaker> speakerList = speakerService.queryAllSpeaker();
        PageInfo pageInfo = new PageInfo(speakerList);
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("behind/speakerList.jsp");
        return modelAndView;
    }

    @RequestMapping("deleteSpeakerById")
    public String deleteSpeakerById(HttpServletRequest request) throws IOException {
        String id = request.getParameter("id");
        speakerService.deleteSpeakerById(Integer.parseInt(id));
        return "success";
    }

    @RequestMapping("edit")
    public ModelAndView edit(HttpServletRequest request, ModelAndView modelAndView) throws IOException {
        String id = request.getParameter("id");
        Speaker speaker = speakerService.querySpeakerById(Integer.parseInt(id));
        modelAndView.addObject("speaker", speaker);
        modelAndView.setViewName("behind/addSpeaker.jsp");

        return modelAndView;
    }


    @RequestMapping("addSpeaker")
    public ModelAndView addSpeaker(ModelAndView modelAndView, HttpServletRequest request) throws IOException {
        modelAndView.setViewName("behind/addSpeaker.jsp");
        return modelAndView;
    }

    @RequestMapping("saveOrUpdate")
    public void saveOrUpdate(HttpServletRequest request, Speaker speaker, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        if (null != id) {
            speaker.setSpeakerId(Integer.parseInt(id));
            speakerService.updateSpeakerById(speaker);
        } else {
            speaker.setSpeakerId(0);
            speaker.setHeadImgUrl("");
            speakerService.addSpeaker(speaker);
        }
        response.sendRedirect("/speaker/showSpeakerList");
    }


}
