package com.hngy.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * @name: AuthInterceptor
 * @author: liuwenxuan
 * @date: 2023-05-09 17:08
 **/
@Component
public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String identify = (String) request.getSession().getAttribute("identify");
        String uri = request.getRequestURI();

        if (uri.matches("/admin/.*") || uri.matches("/teacher/.*") || uri.matches("/student/.*")) {
            // 未登录
            if (Objects.isNull(identify)) {
                response.sendRedirect("/login");
                return false;
            }
            // 没有权限
            if (!uri.contains(identify)) {
                response.sendRedirect(String.format("/%s/index", identify));
                return false;
            }
        }

        return true;
    }
}
