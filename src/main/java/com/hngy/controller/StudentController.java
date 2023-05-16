package com.hngy.controller;

import com.github.pagehelper.PageInfo;
import com.hngy.exception.UserException;
import com.hngy.model.Student;
import com.hngy.model.StudentCourseInfo;
import com.hngy.model.StudentElectiveCourse;
import com.hngy.service.StudentService;
import com.hngy.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @name: StudentController
 * @author: liuwenxuan
 * @date: 2023-05-14 20:49
 **/
@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/index")
    public String index() {
        return "student/index";
    }

    @GetMapping("/info")
    public String info(HttpSession session, Model model) {
        String sno = (String) session.getAttribute("username");
        Student student = studentService.getStudent(sno);
        model.addAttribute("student", student);
        return "student/studentInfo";
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
        String sno = (String) session.getAttribute("username");
        // TODO 教师密码修改接口返回到前端的JSON数据未被处理
        return studentService.changePassword(sno, oldPassword, newPassword);
    }

    @PostMapping("/require/page")
    @ResponseBody
    public Map<String, Object> pageRequire(Integer page, Integer rows, @RequestParam(value = "keyword", required = false) String cname, HttpSession session) {
        String sno = (String) session.getAttribute("username");

        PageInfo<StudentCourseInfo> pageInfo = studentService.pageRequireCourse(sno, cname, page, rows);

        HashMap<String, Object> map = new HashMap<>();
        map.put("total", pageInfo.getTotal());
        map.put("rows", pageInfo.getList());
        return map;
    }

    @PostMapping("/elective/page")
    @ResponseBody
    public Map<String, Object> pageElective(Integer page, Integer rows, @RequestParam(value = "keyword", required = false) String cname, HttpSession session) {
        String sno = (String) session.getAttribute("username");
        PageInfo<StudentCourseInfo> pageInfo = studentService.pageElectiveCourse(sno, cname, page, rows);
        HashMap<String, Object> map = new HashMap<>();
        map.put("total", pageInfo.getTotal());
        map.put("rows", pageInfo.getList());
        return map;
    }

    @GetMapping("/course/select")
    @ResponseBody
    public Map<String, Object> selectCourseInfo(HttpSession session) {
        String sno = (String) session.getAttribute("username");
        HashMap<String, Object> map = new HashMap<>();
        map.put("rows", studentService.selectCourseInfo(sno));
        return map;
    }

    @PostMapping("/course/select")
    @ResponseBody
    public ResultVO<?> submitSelectCourse(@RequestBody StudentElectiveCourse studentElectiveCourse, HttpSession session) {
        String sno = (String) session.getAttribute("username");
        System.out.println(studentElectiveCourse);
        return studentService.submitSelectCourse(sno, studentElectiveCourse.getId());
    }
}
