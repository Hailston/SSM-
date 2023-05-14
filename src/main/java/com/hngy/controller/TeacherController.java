package com.hngy.controller;

import com.github.pagehelper.PageInfo;
import com.hngy.exception.UserException;
import com.hngy.model.Classes;
import com.hngy.model.Student;
import com.hngy.model.StudentClasses;
import com.hngy.model.Teacher;
import com.hngy.service.TeacherService;
import com.hngy.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.*;

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

    @PostMapping("/require/page")
    @ResponseBody
    public Map<String, Object> pageRequireCourse(Integer page, Integer rows, HttpSession session) {
        String tno = (String) session.getAttribute("username");
        PageInfo<Classes> pageInfo = teacherService.pageRequireCourse(tno , page, rows);
        HashMap<String, Object> map = new HashMap<>();
        map.put("total", pageInfo.getTotal());
        map.put("rows", pageInfo.getList());
        return map;
    }

    @GetMapping("/require/{courseId}/student")
    @ResponseBody
    public ResultVO<List<StudentClasses>> getStudent(@PathVariable("courseId")Integer courseId){
        return teacherService.getRequireStudent(courseId);
    }

    @PostMapping("/score")
    @ResponseBody
    public ResultVO<?> score(@RequestBody List<StudentClasses> scores){
        return teacherService.enterScore(scores);
    }

    @PostMapping("/elective/page")
    @ResponseBody
    public Map<String, Object> pageElectiveCourse(Integer page, Integer rows, HttpSession session) {
        String tno = (String) session.getAttribute("username");
        PageInfo<Classes> pageInfo = teacherService.pageElectiveCourse(tno , page, rows);
        HashMap<String, Object> map = new HashMap<>();
        map.put("total", pageInfo.getTotal());
        map.put("rows", pageInfo.getList());
        return map;
    }
}
