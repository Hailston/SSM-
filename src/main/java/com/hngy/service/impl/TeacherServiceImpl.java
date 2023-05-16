package com.hngy.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hngy.exception.UserException;
import com.hngy.mapper.TeacherMapper;
import com.hngy.model.Classes;
import com.hngy.model.StudentClasses;
import com.hngy.model.Teacher;
import com.hngy.service.TeacherService;
import com.hngy.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

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

    @Override
    public PageInfo<Classes> pageRequireCourse(String tno, Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        List<Classes> classes = teacherMapper.selectCourseByCtype(tno, 1);
        return new PageInfo<>(classes);
    }

    @Override
    public ResultVO<List<StudentClasses>> getRequireStudent(Integer courseId) {
        List<StudentClasses> students = teacherMapper.selectRequireCourseStudent(courseId);
        return new ResultVO<>(HttpStatus.OK.value(), "操作成功", students,true);
    }

    @Override
    @Transactional
    public ResultVO<?> enterScore(List<StudentClasses> scores) {
        teacherMapper.updateBatchScore(scores);
        return ResultVO.ok("提交成功！");
    }

    @Override
    public PageInfo<Classes> pageElectiveCourse(String tno, Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        List<Classes> classes = teacherMapper.selectCourseByCtype(tno, 2);
        return new PageInfo<>(classes);
    }

}
