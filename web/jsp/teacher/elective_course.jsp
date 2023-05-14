<%--
  Created by IntelliJ IDEA.
  User: liuwenxuan
  Date: 2023/5/14
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java"  contentType="text/html;charset=UTF-8"%>

<link rel="stylesheet" type="text/css" href="/css/teacher.css" />

<div id="elective_course_manage"></div>
<div id="elective_course_manage_tool" style="padding:5px;">
    <div style="margin-bottom:5px;">
        <a href="#" class="easyui-linkbutton" iconCls="icon-edit-new" plain="true" onclick="elective_manage_tool.enterScore();">录入成绩</a>
    </div>
    <div style="padding:0 0 0 7px;color:#333;">
        <form id="teacherQueryForm" method="post">
            课程名：<input type="text" class="textbox" id="teacherName" name="teacherName" style="width:110px" />
            <a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="teacher_manage_tool.search();">查询</a>
        </form>
    </div>
</div>

<div id="enter_elective_score_dialog">
    <div id="elective_student_score"></div>
    <div id="tb">
        <a href="javascript:void(0)" id="saveBtn" onclick="elective_manage_tool.save()">保存</a>
    </div>
</div>

<script type="text/javascript" src="/js/elective_manage.js"></script>
