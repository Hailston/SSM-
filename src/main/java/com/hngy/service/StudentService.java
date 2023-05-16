package com.hngy.service;

import com.github.pagehelper.PageInfo;
import com.hngy.model.Classes;
import com.hngy.model.Student;
import com.hngy.model.StudentCourseInfo;
import com.hngy.model.StudentElectiveCourse;
import com.hngy.vo.ResultVO;

import java.util.List;

/**
 * @name: StudentService
 * @author: liuwenxuan
 * @date: 2023-05-14 20:59
 **/
public interface StudentService {
    Student getStudent(String sno);

    ResultVO<?> changePassword(String sno, String oldPassword, String newPassword);

    PageInfo<StudentCourseInfo> pageRequireCourse(String sno, String cname, Integer page, Integer rows);

    PageInfo<StudentCourseInfo> pageElectiveCourse(String sno, String cname, Integer page, Integer rows);

    List<StudentElectiveCourse> selectCourseInfo(String sno);

    ResultVO<?> submitSelectCourse(String sno, Integer courseId);
}
