package com.hngy.model;

import lombok.Data;

/**
 * @name: StudentCourseInfo
 * @author: 伍允文
 * @date: 2023-05-15 10:33
 **/
@Data
public class StudentCourseInfo {
    private Integer id;
    private String cname;
    private String room;
    private String courTime;
    private String cmark;
    private Integer cscore;
}
