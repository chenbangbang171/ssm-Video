package com.video.mapper;

import com.video.pojo.QueryVoVideo;
import com.video.pojo.Video;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoMapper {
        Video getVideoById(int videoId);
        List<Video> queryAllVideo( QueryVoVideo queryVo);

        void deleteVideoById(int videoId);

        void deleteVideos(String[] ids);

        void addVideo(Video video);

        void updateVideo(Video video);
}
