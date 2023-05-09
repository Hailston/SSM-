<%--
  Created by IntelliJ IDEA.
  User: liuwenxuan
  Date: 2023/5/8
  Time: 21:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
    <title>教务管理系统</title>

    <link rel="stylesheet" type="text/css" href="../easyui/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css" />
    <link rel="stylesheet" type="text/css" href="../css/login.css" />
</head>
<body>


<div id="login">
    <p>登录帐号：<input type="text"  id="manager" class="textbox"></p>
    <p>登录密码：<input type="password" id="password" class="textbox"></p>
    <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;身份：
        <input type="radio" name="identify" value="student" checked />&nbsp;学生
        <input type="radio" name="identify" value="teacher"/>&nbsp;教师
        <input type="radio" name="identify" value="admin"/>&nbsp;管理员
    </p>
</div>

<div id="btn">
    <a href="#" class="easyui-linkbutton">登录</a>
</div>

<script type="text/javascript" src="../easyui/jquery.min.js"></script>
<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../easyui/locale/easyui-lang-zh_CN.js" ></script>
<script type="text/javascript" src="../easyui/jquery.cookie.js"></script>
<script type="text/javascript" src="../js/login.js"></script>

</body>
</html>
</html>

