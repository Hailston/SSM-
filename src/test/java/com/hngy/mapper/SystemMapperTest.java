package com.hngy.mapper;

import com.hngy.model.Admin;
import com.hngy.model.Student;
import com.hngy.model.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @name: SystemMapperTest
 * @author: liuwenxuan
 * @date: 2023-05-09 15:50
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:springMVC.xml")
public class SystemMapperTest {
    @Autowired
    private SystemMapper systemMapper;
    @Test
    public void testLoginAdmin(){
        Admin admin = systemMapper.loginAdmin("aa", "a");
        System.out.println(admin);
    }

    @Test
    public void testLoginStudent(){
        Student student = systemMapper.loginStudent("a", "a");
        System.out.println(student);
    }

    @Test
    public void testLoginTeacher(){
        Teacher teacher = systemMapper.loginTeacher("a", "a");
        System.out.println(teacher);
    }
}
