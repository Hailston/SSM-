package com.hngy.service.impl;

import com.hngy.exception.UserException;
import com.hngy.mapper.StudentMapper;
import com.hngy.model.Student;
import com.hngy.service.StudentService;
import com.hngy.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
