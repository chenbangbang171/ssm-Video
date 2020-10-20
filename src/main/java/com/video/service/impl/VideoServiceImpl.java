package com.video.service.impl;

import com.video.mapper.VideoMapper;
import com.video.pojo.Video;
import com.video.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper videoMapper;

    @Override
    public Video getVideoById(int videoId) {
        return videoMapper.getVideoById(videoId);
    }
}
