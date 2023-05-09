package com.hngy.controller;

import com.hngy.model.Student;
import com.hngy.service.AdminService;
import com.hngy.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @name: AdminController
 * @author: liuwenxuan
 * @date: 2023-05-08 12:35
 **/
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/index")
    public String index(){
        return "admin/index";
    }

    @PostMapping("/student/add")
    @ResponseBody
    public ResultVO<?> addStudent(Student student){
        return adminService.addStudent(student);
    }
}
