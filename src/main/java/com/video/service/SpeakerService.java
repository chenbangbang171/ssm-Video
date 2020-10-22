package com.video.service;

import com.video.pojo.Speaker;

import java.util.List;

public interface SpeakerService {
    List<Speaker> queryAllSpeaker();

    void deleteSpeakerById(int id);

    Speaker querySpeakerById(int id);

    void updateSpeakerById(Speaker speaker);

    void addSpeaker(Speaker speaker);

}
