package com.hngy.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @name: StudentMapperTest
 * @author: liuwenxuan
 * @date: 2023-05-15 17:56
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:springMVC.xml")
public class StudentMapperTest {
    @Autowired
    private StudentMapper studentMapper;
    @Test
    public void test(){
        studentMapper.getElectiveCourse("1001").forEach(System.out::println);
    }
}
