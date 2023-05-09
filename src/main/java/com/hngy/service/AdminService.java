package com.hngy.service;

import com.hngy.model.Student;
import com.hngy.vo.ResultVO;

/**
 * @name: AdminService
 * @author: liuwenxuan
 * @date: 2023-05-08 12:36
 **/
public interface AdminService {

    ResultVO<?> addStudent(Student student);
}
