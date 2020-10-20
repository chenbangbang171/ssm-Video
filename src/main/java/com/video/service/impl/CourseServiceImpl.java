package com.video.service.impl;

import com.video.mapper.CourseMapper;
import com.video.pojo.Course;
import com.video.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;


    @Override
    public List<Course> queryAllCourse() {
        return courseMapper.queryAllCourse();
    }

    @Override
    public Course queryCourseById(int courseId) {
        return courseMapper.queryCourseById(courseId);
    }


}
