package com.video.service.impl;

import com.video.mapper.SubjectMapper;
import com.video.pojo.Subject;
import com.video.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class SubjectServiceImpl  implements SubjectService {

    @Autowired
    private SubjectMapper subjectMapper;

    @Override
    public List<Subject> queryAllSubject() {
        return subjectMapper.queryAllSubject();
    }

    @Override
    public Subject querySubjectById(int subId) {
        return subjectMapper.querySubjectById(subId);
    }
}
