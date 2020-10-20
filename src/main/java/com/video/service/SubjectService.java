package com.video.service;

import com.video.pojo.Subject;

import java.util.List;

public interface SubjectService {
        List<Subject> queryAllSubject();

        Subject querySubjectById(int SubId);
}
