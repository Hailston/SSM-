package com.hngy.controller;


import com.alibaba.fastjson.JSON;
import com.hngy.service.SystemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @name: SystemController
 * @author: liuwenxuan
 * @date: 2023-05-09 15:12
 **/
@Controller
public class SystemController {

    @Autowired
    private SystemService systemService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public void handleLogin(@RequestParam String username, @RequestParam String password,
                            @RequestParam String identify, HttpServletResponse response,
                            HttpSession session) throws IOException {

        Map<String, Object> m = new HashMap<>();
        String addr = systemService.login(username, password, identify);
        boolean success = addr != null;

        if (success) {
            session.setAttribute("username", username);
            session.setAttribute("identify", identify);
            m.put("addr", addr);
        }

        response.setContentType("text/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        System.out.println(success);
        m.put("success", success);
        m.put("msg", success ? "登录成功" : "登录失败");

        out.println(JSON.toJSONString(m));
        out.flush();
        out.close();

    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("username");
        session.removeAttribute("identify");
        return "login";
    }
}