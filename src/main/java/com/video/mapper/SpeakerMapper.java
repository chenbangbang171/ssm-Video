package com.video.mapper;

import com.video.pojo.Speaker;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpeakerMapper {
    List<Speaker> queryAllSpeaker();
    void deleteSpeakerById(int id);
    Speaker querySpeakerById(int id);

    void updateSpeakerById(Speaker speaker);

    void addSpeaker(Speaker speaker);
}
