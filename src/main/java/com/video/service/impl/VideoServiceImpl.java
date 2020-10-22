package com.video.service.Impl;

import com.video.mapper.VideoMapper;
import com.video.pojo.QueryVoVideo;
import com.video.pojo.Video;
import com.video.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper videoMapper;

    @Override
    public Video getVideoById(int videoId) {
        return videoMapper.getVideoById(videoId);
    }

    @Override
    public List<Video> queryAllVideo(QueryVoVideo queryVo) {
        return videoMapper.queryAllVideo(queryVo);
    }

    @Override
    public void deleteVideoById(int videoId) {
        videoMapper.deleteVideoById(videoId);
    }

    @Override
    public void deleteVideos(String[] ids) {
        videoMapper.deleteVideos(ids);
    }

    @Override
    public void addVideo(Video video) {
        videoMapper.addVideo(video);
    }

    @Override
    public void updateVideo(Video video) {
        videoMapper.updateVideo(video);
    }
}
