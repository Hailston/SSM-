package com.hngy.model;

import lombok.Data;

/**
 * @name CourseInfo
 * @Author 伍允文
 * @Date 2023/5/8
 **/
@Data
public class CourseInfo {
    private String courseNumber;
    private String courseName;
    private String courseTeacher;
    private String courseTime;
    private String coursePlace;
    private Float courseScore;
    private String courseMemo;
}
