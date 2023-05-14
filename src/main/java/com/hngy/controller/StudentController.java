package com.hngy.controller;

import com.hngy.exception.UserException;
import com.hngy.model.Student;
import com.hngy.service.StudentService;
import com.hngy.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

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
}
