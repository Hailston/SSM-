package com.hngy.service.impl;

import com.hngy.exception.UserException;
import com.hngy.mapper.TeacherMapper;
import com.hngy.model.Teacher;
import com.hngy.service.TeacherService;
import com.hngy.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 * @name: TeacherServiceImpl
 * @author: liuwenxuan
 * @date: 2023-05-12 17:08
 **/
@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public Teacher getOneBySno(String tno) {
        Teacher teacher = teacherMapper.selectOneByTno(tno);
        teacher.setPassword(null);
        return teacher;
    }

    @Override
    public ResultVO<?> modifyInfo(Teacher teacher) {
        int i  = teacherMapper.updateTeacher(teacher);
        if (i == 0) {
            return new ResultVO<>(HttpStatus.BAD_REQUEST.value(), "修改失败!", false);
        }
        return ResultVO.ok("修改成功!");
    }

    @Override
    public ResultVO<?> changePassword(String tno, String oldPassword, String newPassword) {
        int i = teacherMapper.changePassword(tno, oldPassword, newPassword);
        if (i == 0){
            throw new UserException("旧密码不正确!");
        }
        return ResultVO.ok("密码修改成功!");
    }
}
