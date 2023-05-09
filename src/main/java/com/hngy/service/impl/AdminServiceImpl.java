package com.hngy.service.impl;

import com.hngy.exception.StudentException;
import com.hngy.mapper.StudentMapper;
import com.hngy.model.Student;
import com.hngy.service.AdminService;
import com.hngy.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @name: AdminServiceImpl
 * @author: liuwenxuan
 * @date: 2023-05-08 12:36
 **/
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private StudentMapper studentMapper;

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

}
