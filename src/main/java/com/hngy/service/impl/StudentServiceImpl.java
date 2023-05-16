package com.hngy.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hngy.exception.UserException;
import com.hngy.mapper.StudentMapper;
import com.hngy.model.Classes;
import com.hngy.model.Student;
import com.hngy.model.StudentCourseInfo;
import com.hngy.model.StudentElectiveCourse;
import com.hngy.service.StudentService;
import com.hngy.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @name: StudentServiceImpl
 * @author: liuwenxuan
 * @date: 2023-05-14 21:00
 **/
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student getStudent(String sno) {
        return studentMapper.getStudent(sno);
    }

    @Override
    public ResultVO<?> changePassword(String sno, String oldPassword, String newPassword) {
        int i = studentMapper.changePassword(sno, oldPassword, newPassword);
        if (i == 0){
            throw new UserException("旧密码不正确!");
        }
        return ResultVO.ok("密码修改成功!");
    }

    @Override
    public PageInfo<StudentCourseInfo> pageRequireCourse(String sno,String cname ,Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        List<StudentCourseInfo> courseList = studentMapper.getStudentCourse(sno,cname,1);
        return new PageInfo<>(courseList);
    }

    @Override
    public PageInfo<StudentCourseInfo> pageElectiveCourse(String sno, String cname, Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        List<StudentCourseInfo> courseList = studentMapper.getStudentCourse(sno,cname,2);
        return new PageInfo<>(courseList);
    }

    @Override
    public List<StudentElectiveCourse> selectCourseInfo(String sno) {
        return studentMapper.getElectiveCourse(sno);
    }

    @Override
    public ResultVO<?> submitSelectCourse(String sno, Integer courseId) {
        studentMapper.insertStudentClasses(sno, courseId);
        return ResultVO.ok("选课成功!");
    }
}
