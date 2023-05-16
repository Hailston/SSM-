package com.hngy.service;

import com.github.pagehelper.PageInfo;
import com.hngy.model.Classes;
import com.hngy.model.Student;
import com.hngy.model.Teacher;
import com.hngy.vo.ResultVO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @name: AdminService
 * @author: liuwenxuan
 * @date: 2023-05-08 12:36
 **/
public interface AdminService {

    ResultVO<?> addStudent(Student student);
    PageInfo<Student> pageStudent(Integer page, Integer rows, String sname);

    void importStudentExcel(MultipartFile file) throws IOException;

    ResultVO<?> addTeacher(Teacher teacher);

    PageInfo<Teacher> pageTeacher(Integer page, Integer rows);

    void importTeacherExcel(MultipartFile file) throws IOException;

    ResultVO<?> addClasses(Classes classes);

    void importClassesExcel(MultipartFile file) throws IOException;

    PageInfo<Classes> pageClasses(Integer page, Integer rows);

    ResultVO<?> changePassword(String username, String oldPassword, String newPassword);
}
