<%--
  Created by IntelliJ IDEA.
  User: liuwenxuan
  Date: 2023/5/15
  Time: 08:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java"  contentType="text/html;charset=UTF-8"%>

<link rel="stylesheet" type="text/css" href="/css/student.css" />

<div id="student_require_course_manage"></div>
<div id="student_require_course_manage_tool" style="padding:5px;">
    <div style="padding:0 0 0 7px;color:#333;">
        <form id="studentQueryForm" method="post">
            课程名：<input type="text" class="textbox" id="courseName" name="courseName" style="width:110px" />
            <a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="student_require_manage_tool.search();">查询</a>
        </form>
    </div>
</div>


<script type="text/javascript" src="/js/student_require_manage.js"></script>

