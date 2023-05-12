package com.hngy.service;

import com.hngy.model.Teacher;
import com.hngy.vo.ResultVO;

/**
 * @name: TeacherService
 * @author: liuwenxuan
 * @date: 2023-05-12 17:08
 **/
public interface TeacherService {
    Teacher getOneBySno(String tno);

    ResultVO<?> modifyInfo(Teacher teacher);

    ResultVO<?> changePassword(String tno, String oldPassword, String newPassword);
}
