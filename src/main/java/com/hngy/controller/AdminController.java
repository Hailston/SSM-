package com.hngy.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.github.pagehelper.PageInfo;
import com.hngy.listener.StudentDataListener;
import com.hngy.model.Student;
import com.hngy.model.Teacher;
import com.hngy.service.AdminService;
import com.hngy.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
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

    @PostMapping("/student/list")
    @ResponseBody
    public Map<String, Object> listStudent(Integer page, Integer rows) throws IOException {
        PageInfo<Student> pageInfo = adminService.pageStudent(page, rows);
        HashMap<String, Object> map = new HashMap<>();
        map.put("total", pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }

    @PostMapping("/student/import")
    @ResponseBody
    public ResultVO<?> importExcel(MultipartFile file) throws IOException {
        adminService.importStudentExcel(file);
        return ResultVO.ok("导入成功！");
    }

    @PostMapping("/teacher/add")
    @ResponseBody
    public ResultVO<?> addTeacher(Teacher teacher){
        return adminService.addTeacher(teacher);
    }

    @PostMapping("/teacher/list")
    @ResponseBody
    public Map<String, Object> listTeacher(Integer page, Integer rows){
        PageInfo<Teacher> pageInfo = adminService.pageTeacher(page, rows);
        HashMap<String, Object> map = new HashMap<>();
        map.put("total", pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }

    @PostMapping("/teacher/import")
    @ResponseBody
    public ResultVO<?> importTeacherExcel(MultipartFile file) throws IOException{
        adminService.importTeacherExcel(file);
        return ResultVO.ok("导入成功！");
    }
}
