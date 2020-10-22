package com.video.service.Impl;

import com.video.mapper.SpeakerMapper;
import com.video.pojo.Speaker;
import com.video.service.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpeakerServiceImpl implements SpeakerService {
    @Autowired
    private SpeakerMapper speakerMapper;
    @Override
    public List<Speaker> queryAllSpeaker() {
        return speakerMapper.queryAllSpeaker();
    }

    @Override
    public void deleteSpeakerById(int id) {
        speakerMapper.deleteSpeakerById(id);
    }

    @Override
    public Speaker querySpeakerById(int id) {
        return speakerMapper.querySpeakerById(id);
    }

    @Override
    public void updateSpeakerById(Speaker speaker) {
        speakerMapper.updateSpeakerById(speaker);
    }

    @Override
    public void addSpeaker(Speaker speaker) {
        speakerMapper.addSpeaker(speaker);
    }


}
