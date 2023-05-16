<%@ page language="java"  contentType="text/html;charset=UTF-8"%>
<link rel="stylesheet" type="text/css" href="/css/teacher.css" />

<div id="teacher_manage"></div>
<div id="teacher_manage_tool" style="padding:5px;">
    <div style="margin-bottom:5px;">
        <form id="teacherImport" method="post" enctype="multipart/form-data">
            <input id="fb" name="file" style="width:200px">
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-export" plain="true"
               onclick="teacher_manage_tool.importExcel();">导入excel</a>
        </form>
    </div>
    <div style="padding:0 0 0 7px;color:#333;">
        <form id="teacherQueryForm" method="post">
            教师姓名：<input type="text" class="textbox" id="teacherName" name="teacherName" style="width:110px" />
            <a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="teacher_manage_tool.search();">查询</a>
        </form>
    </div>
</div>

<script type="text/javascript" src="/js/teacher_manage.js"></script>
