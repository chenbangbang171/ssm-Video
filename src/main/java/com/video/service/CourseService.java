package com.video.service;

import com.video.pojo.Course;

import java.util.List;

public interface CourseService {
    List<Course>  queryAllCourse();

    Course queryCourseById(int courseId);

}
