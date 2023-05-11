package com.hngy.listener;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @name: TeacherData
 * @author: liuwenxuan
 * @date: 2023-05-11 08:55
 **/
@Data
public class TeacherData {
    @ExcelProperty("教师编号")
    private String tno;
    @ExcelProperty("教师姓名")
    private String tname;
    @ExcelProperty("年龄")
    private Integer age;
    @ExcelProperty("电子邮箱")
    private String email;
    @ExcelProperty("联系电话")
    private String tel;
    @ExcelProperty("教师类型")
    private String teaType;
}
