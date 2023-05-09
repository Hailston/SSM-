package com.hngy.mapper;

import com.hngy.model.Admin;
import com.hngy.model.Student;
import com.hngy.model.Teacher;
import org.apache.ibatis.annotations.Param;

/**
 * @name: SystemMapper
 * @author: liuwenxuan
 * @date: 2023-05-09 15:43
 **/
public interface SystemMapper {
    Admin loginAdmin(@Param("username") String username, @Param("password") String password);
    Student loginStudent(@Param("username") String username, @Param("password") String password);
    Teacher loginTeacher(@Param("username") String username, @Param("password") String password);
}
