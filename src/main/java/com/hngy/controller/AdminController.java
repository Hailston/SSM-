package com.hngy.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.github.pagehelper.PageInfo;
import com.hngy.exception.UserException;
import com.hngy.listener.StudentDataListener;
import com.hngy.model.Classes;
import com.hngy.model.Student;
import com.hngy.model.Teacher;
import com.hngy.service.AdminService;
import com.hngy.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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
    public String index() {
        return "admin/index";
    }

    @PostMapping("/student/add")
    @ResponseBody
    public ResultVO<?> addStudent(Student student, MultipartFile studentPhotoFile, HttpSession session) throws IOException {
        String realPath = session.getServletContext().getRealPath("/upload");
        File uploadDirectory = new File(realPath);
        if (!uploadDirectory.exists()) {
            uploadDirectory.mkdirs();
        }
        if (!studentPhotoFile.isEmpty()) {
            String suffix = studentPhotoFile.getOriginalFilename()
                    .substring(studentPhotoFile.getOriginalFilename().lastIndexOf("."));
            String fileName = UUID.randomUUID().toString() + suffix;
            File file = new File(uploadDirectory + File.separator + fileName);
            studentPhotoFile.transferTo(file);
            student.setImage("/upload/" + fileName);
        }
        return adminService.addStudent(student);
    }

    @PostMapping("/student/list")
    @ResponseBody
    public Map<String, Object> listStudent(Integer page, Integer rows, @RequestParam(value = "keyword", required = false)String keyword) throws IOException {
        PageInfo<Student> pageInfo = adminService.pageStudent(page, rows, keyword);
        HashMap<String, Object> map = new HashMap<>();
        map.put("total", pageInfo.getTotal());
        map.put("rows", pageInfo.getList());
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
    public ResultVO<?> addTeacher(Teacher teacher) {
        return adminService.addTeacher(teacher);
    }

    @PostMapping("/teacher/list")
    @ResponseBody
    public Map<String, Object> listTeacher(Integer page, Integer rows) {
        PageInfo<Teacher> pageInfo = adminService.pageTeacher(page, rows);
        HashMap<String, Object> map = new HashMap<>();
        map.put("total", pageInfo.getTotal());
        map.put("rows", pageInfo.getList());
        return map;
    }

    @PostMapping("/teacher/import")
    @ResponseBody
    public ResultVO<?> importTeacherExcel(MultipartFile file) throws IOException {
        adminService.importTeacherExcel(file);
        return ResultVO.ok("导入成功！");
    }

    @PostMapping("/classes/add")
    @ResponseBody
    public ResultVO<?> addClasses(Classes classes) {
        return adminService.addClasses(classes);
    }

    @PostMapping("/classes/list")
    @ResponseBody
    public Map<String, Object> listClasses(Integer page, Integer rows) {
        PageInfo<Classes> pageInfo = adminService.pageClasses(page, rows);
        HashMap<String, Object> map = new HashMap<>();
        map.put("total", pageInfo.getTotal());
        map.put("rows", pageInfo.getList());
        return map;
    }

    @PostMapping("/classes/import")
    @ResponseBody
    public ResultVO<?> importClassesExcel(MultipartFile file) throws IOException {
        adminService.importClassesExcel(file);
        return ResultVO.ok("导入成功！");
    }

    @PostMapping("/changePassword")
    @ResponseBody
    public ResultVO<?> changePassword(String oldPassword, String newPassword, String newPassword2, HttpSession session) {
        if (StringUtils.isEmpty(oldPassword)) {
            throw new UserException("请输入旧密码!");
        }
        if (StringUtils.isEmpty(newPassword) || StringUtils.isEmpty(newPassword2)) {
            throw new UserException("请输入新密码!");
        }
        if (!newPassword.equals(newPassword2)) {
            throw new UserException("再次新密码输入不一致!");
        }
        String username = (String) session.getAttribute("username");
        // TODO 密码修改成功响应到页面的数据未处理
        return adminService.changePassword(username, oldPassword, newPassword);
    }
}
