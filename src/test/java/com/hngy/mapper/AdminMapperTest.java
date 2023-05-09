package com.hngy.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @name: AdminMapperTest
 * @author: liuwenxuan
 * @date: 2023-05-08 10:26
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:springMVC.xml")
public class AdminMapperTest {
    @Autowired
    private AdminMapper adminMapper;


}
