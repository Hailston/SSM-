package com.hngy.controller;

import com.hngy.exception.UserException;
import com.hngy.model.Teacher;
import com.hngy.service.TeacherService;
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
 * @name: TeacherController
 * @author: liuwenxuan
 * @date: 2023-05-12 01:01
 **/
@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping("/index")
    public String index(){
        return "teacher/index";
    }

    @GetMapping("/info")
    public String info(HttpSession session, Model model){
        String username = (String) session.getAttribute("username");
        Teacher teacher = teacherService.getOneBySno(username);
        model.addAttribute("teacher", teacher);
        return "teacher/teacherInfo";
    }

    @GetMapping("/infoEdit")
    public String infoEdit(HttpSession session, Model model){
        String username = (String) session.getAttribute("username");
        Teacher teacher = teacherService.getOneBySno(username);
        model.addAttribute("teacher", teacher);
        return "teacher/info_modify";
    }

    @PostMapping("/infoEdit")
    @ResponseBody
    public ResultVO<?> handleEditInfo(Teacher teacher, HttpSession session){
        String username = (String) session.getAttribute("username");
        teacher.setTno(username);
        return teacherService.modifyInfo(teacher);
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
        // TODO 教师密码修改接口返回到前端的JSON数据未被处理
        return teacherService.changePassword(username, oldPassword, newPassword);
    }
}
