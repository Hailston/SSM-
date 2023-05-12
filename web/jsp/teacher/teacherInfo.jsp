<%--
  Created by IntelliJ IDEA.
  User: liuwenxuan
  Date: 2023/5/12
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<style>
    #teacherInfo td {
        width: 100px;
        text-align: center;
        border: 1px solid black;
    }

    #teacherInfo td:first-child {
        text-align: right;
    }
    #teacherInfo td:nth-child(2) {
        width: 150px;
    }

    #teacherInfo tr {
        margin-top: 10px;
    }
    #teacherInfo {
        font-size: large;
        border-collapse: collapse;
        margin: auto;
    }
</style>
<table id="teacherInfo">
    <tr>
        <td>教师编号</td>
        <td>${teacher.tno}</td>
    </tr>
    <tr>
        <td>姓名</td>
        <td>${teacher.tname}</td>
    </tr>
    <tr>
        <td>年龄</td>
        <td>${teacher.age}</td>
    </tr>
    <tr>
        <td>电子邮件</td>
        <td>${teacher.email}</td>
    </tr>
    <tr>
        <td>电话</td>
        <td>${teacher.tel}</td>
    </tr>
    <tr>
        <td>职称</td>
        <td>${teacher.teaType}</td>
    </tr>
</table>
