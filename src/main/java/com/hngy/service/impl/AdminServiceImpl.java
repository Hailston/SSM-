package com.hngy.service.impl;

import com.alibaba.excel.EasyExcel;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hngy.exception.StudentException;
import com.hngy.listener.StudentData;
import com.hngy.listener.StudentDataListener;
import com.hngy.mapper.StudentMapper;
import com.hngy.mapper.TeacherMapper;
import com.hngy.model.Student;
import com.hngy.model.Teacher;
import com.hngy.service.AdminService;
import com.hngy.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @name: AdminServiceImpl
 * @author: liuwenxuan
 * @date: 2023-05-08 12:36
 **/
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public ResultVO<?> addStudent(Student student) {
        try {
            studentMapper.addStudent(student);
        }catch (Exception e){
            e.printStackTrace();
            throw new StudentException("添加失败!");
        }
        return ResultVO.ok("添加成功");
    }

    @Override
    public PageInfo<Student> pageStudent(Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        List<Student> students = studentMapper.listAll();
        return new PageInfo<>(students);
    }

    @Override
    public void importStudentExcel(MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), StudentData.class, new StudentDataListener(studentMapper)).sheet().doRead();
    }

    @Override
    public ResultVO<?> addTeacher(Teacher teacher) {
        teacherMapper.addTeacher(teacher);
        return ResultVO.ok("添加成功!");
    }
}
