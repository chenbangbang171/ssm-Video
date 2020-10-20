package com.video.mapper;

import com.video.pojo.Course;
import com.video.pojo.Subject;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectMapper {
       List<Subject> queryAllSubject();

       Subject querySubjectById(int SubId);

       Course queryCourseBySubId(int subId);

}
