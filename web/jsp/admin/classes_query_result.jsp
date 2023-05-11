<%--
  Created by IntelliJ IDEA.
  User: liuwenxuan
  Date: 2023/5/11
  Time: 09:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="/css/classes.css" />

<div id="classes_manage"></div>
<div id="classes_manage_tool" style="padding:5px;">
    <div style="margin-bottom:5px;">
        <form id="classesImport" method="post" enctype="multipart/form-data">
            <input id="fb" type="text" name="file" style="width:200px">
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-export" plain="true"
               onclick="classes_manage_tool.importExcel();">导入excel</a>
        </form>
    </div>
    <div style="padding:0 0 0 7px;color:#333;">
        <form id="courseInfoQueryForm" method="post">
            教师号：<input class="textbox" type="text" id="courseTeacher_teacherNumber_query" name="courseTeacher.teacherNumber" style="width: auto"/>
            <a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="courseInfo_manage_tool.search();">查询</a>
        </form>
    </div>
</div>

<script type="text/javascript" src="/js/classes_manage.js"></script>
