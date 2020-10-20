package com.video.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Subject {
    private int subId;
    private String subName;
    List<Course>  courseList;
}
