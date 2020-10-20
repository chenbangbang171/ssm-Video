package com.video.mapper;

import com.video.pojo.Speaker;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpeakerMapper {
    List<Speaker> queryAllSpeaker();
}
