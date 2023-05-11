package com.hngy.service.impl;

import com.alibaba.excel.EasyExcel;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hngy.exception.StudentException;
import com.hngy.exception.UserException;
import com.hngy.listener.*;
import com.hngy.mapper.AdminMapper;
import com.hngy.mapper.ClassesMapper;
import com.hngy.mapper.StudentMapper;
import com.hngy.mapper.TeacherMapper;
import com.hngy.model.Classes;
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

    @Autowired
    private ClassesMapper classesMapper;

    @Autowired
    private AdminMapper adminMapper;

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

    @Override
    public PageInfo<Teacher> pageTeacher(Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        List<Teacher> teachers = teacherMapper.listAll();
        return new PageInfo<>(teachers);
    }

    @Override
    public void importTeacherExcel(MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), TeacherData.class, new TeacherDataListener(teacherMapper)).sheet().doRead();
    }

    @Override
    public ResultVO<?> addClasses(Classes classes) {
        classesMapper.addClasses(classes);
        return ResultVO.ok("添加成功!");
    }

    @Override
    public void importClassesExcel(MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), Classes.class, new ClassesDataListener(classesMapper)).sheet().doRead();
    }

    @Override
    public PageInfo<Classes> pageClasses(Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        List<Classes> classes = classesMapper.listAll();
        return new PageInfo<>(classes);
    }

    @Override
    public ResultVO<?> changePassword(String username, String oldPassword, String newPassword) {
        int i = adminMapper.changePassword(username, oldPassword, newPassword);
        if (i == 0){
            throw new UserException("旧密码不正确!");
        }
        return ResultVO.ok("密码修改成功!");
    }
}
