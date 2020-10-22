package com.video.service;


import com.video.pojo.QueryVoVideo;
import com.video.pojo.Video;

import java.util.List;

public interface VideoService {
    Video getVideoById(int videoId);

    List<Video> queryAllVideo(QueryVoVideo queryVo);

    void deleteVideoById(int videoId);

    void deleteVideos(String[] ids);

    void addVideo(Video video);

    void updateVideo(Video video);


}
