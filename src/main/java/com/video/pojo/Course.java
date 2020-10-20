package com.video.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Course {
    private int courseId;
    private String courseTitle;
    private String courseDesc;
    private int subjectId;
    private List<Video> videoList;

}
