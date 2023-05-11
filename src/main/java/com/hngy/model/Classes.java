package com.hngy.model;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @name: Classes
 * @author: liuwenxuan
 * @date: 2023-05-10 22:07
 **/
@Data
public class Classes {
    private Integer id;
    @ExcelProperty("教师号")
    private Integer teacherId;
    @ExcelProperty("最大选课人数")
    private Integer chooseMax;
    @ExcelProperty("已选人数")
    private Integer chooseCurNum;
    @ExcelProperty("上课地点")
    private String room;
    @ExcelProperty("上课时间")
    private String courTime;
    @ExcelProperty("课程学分")
    private String cmark;
    @ExcelProperty("课程名称")
    private String cname;
}
