package com.video.mapper;

import com.video.pojo.Course;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseMapper {
    List<Course> queryAllCourse();

    Course queryCourseById(int courseId);



}
