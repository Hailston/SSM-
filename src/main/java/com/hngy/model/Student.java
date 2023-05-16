package com.hngy.model;

import lombok.Data;

/**
 * @name Classes
 * @Author 刘文选
 * @Date 2023/5/8
 **/
@Data
public class Student {
    private Integer id;
    private String sno;
    private String username;
    private String sex;
    private String password;
    private String department;
    private String jiguan;
    private String mark;
    private String email;
    private String image;
    private String tel;
    private Integer maxClasses;
}
