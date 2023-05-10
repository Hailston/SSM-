<%--
  Created by IntelliJ IDEA.
  User: liuwenxuan
  Date: 2023/5/9
  Time: 19:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="/css/student.css"/>

<div id="student_manage"></div>
<div id="student_manage_tool" style="padding:5px;">
    <div style="margin-bottom:5px;">
        <form id="studentImport" method="post" enctype="multipart/form-data">
                <input id="fb" type="text" name="file" style="width:200px">

            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-export" plain="true"
               onclick="student_manage_tool.importExcel();">导入excel</a>
        </form>
        <%--        <a href="#" class="easyui-linkbutton" iconCls="icon-export" plain="true" onclick="student_manage_tool.exportExcel();">导出到excel</a>--%>
    </div>
    <div style="padding:0 0 0 7px;color:#333;">
        <form id="studentQueryForm" method="post">
            姓名：<input type="text" class="textbox" id="studentName" name="studentName" style="width:110px"/>
            <a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="student_manage_tool.search();">查询</a>
        </form>
    </div>
</div>

<script type="text/javascript" src="/js/student_manage.js"></script>
