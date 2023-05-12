package com.hngy.service.impl;

import com.hngy.mapper.SystemMapper;
import com.hngy.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @name: SystemServiceImpl
 * @author: liuwenxuan
 * @date: 2023-05-09 15:39
 **/

@Service
public class SystemServiceImpl implements SystemService {
    @Autowired
    private SystemMapper systemMapper;

    @Override
    public String login(String username, String password, String identify) {
        String flag = null;
        // TODO 学生登录和教师登录未完成
        if ("student".equals(identify)) {
//            systemMapper.loginStudent(username, password) != null
        } else if ("teacher".equals(identify)) {
            flag = Objects.isNull(systemMapper.loginTeacher(username, password)) ? null : "/teacher/index";
        } else if ("admin".equals(identify)) {
            flag = Objects.isNull(systemMapper.loginAdmin(username, password))? null : "/admin/index";
        }
        return flag;
    }
}
