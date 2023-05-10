package com.hngy.listener;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @name: StudentData
 * @author: liuwenxuan
 * @date: 2023-05-10 09:51
 **/
@Data
public class StudentData {

    @ExcelProperty("学号")
    private String sno;
    @ExcelProperty("姓名")
    private String username;
    @ExcelProperty("性别")
    private String sex;
    @ExcelProperty("密码")
    private String password;
    @ExcelProperty("院系")
    private String department;
    @ExcelProperty("籍贯")
    private String jiguan;
    @ExcelProperty("学分")
    private String mark;
    @ExcelProperty("学生邮箱")
    private String email;
    @ExcelProperty("联系电话")
    private String tel;
    @ExcelProperty("最大选课数")
    private String maxClasses;

}
