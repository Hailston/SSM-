package com.hngy.service;

import com.github.pagehelper.PageInfo;
import com.hngy.model.Classes;
import com.hngy.model.StudentClasses;
import com.hngy.model.Teacher;
import com.hngy.vo.ResultVO;

import java.util.List;

/**
 * @name: TeacherService
 * @author: liuwenxuan
 * @date: 2023-05-12 17:08
 **/
public interface TeacherService {
    Teacher getOneBySno(String tno);

    ResultVO<?> modifyInfo(Teacher teacher);

    ResultVO<?> changePassword(String tno, String oldPassword, String newPassword);

    PageInfo<Classes> pageRequireCourse(String tno, Integer page, Integer rows);
    PageInfo<Classes> pageElectiveCourse(String tno, Integer page, Integer rows);

    ResultVO<List<StudentClasses>> getRequireStudent(Integer courseId);

    ResultVO<?> enterScore(List<StudentClasses> scores);
}
