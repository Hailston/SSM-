package com.hngy.service;

import com.hngy.model.Student;
import com.hngy.vo.ResultVO;

/**
 * @name: StudentService
 * @author: liuwenxuan
 * @date: 2023-05-14 20:59
 **/
public interface StudentService {
    Student getStudent(String sno);

    ResultVO<?> changePassword(String sno, String oldPassword, String newPassword);
}
