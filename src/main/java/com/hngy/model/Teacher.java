package com.hngy.model;

import lombok.Data;

/**
 * @name Teacher
 * @Author 伍允文
 * @Date 2023/5/8
 **/
@Data
public class Teacher {
    private Integer id;
    private String tno;
    private String tname;
    private Integer age;
    private String email;
    private String tel;
    private String password;
    private String teaType;
}
