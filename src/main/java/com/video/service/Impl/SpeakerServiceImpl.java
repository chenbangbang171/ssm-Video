package com.video.service.impl;

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
}
