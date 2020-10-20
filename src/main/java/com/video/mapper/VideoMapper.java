package com.video.mapper;

import com.video.pojo.Video;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoMapper {
        Video getVideoById(int videoId);
}
