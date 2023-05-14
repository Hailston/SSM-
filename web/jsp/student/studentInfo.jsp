<%--
  Created by IntelliJ IDEA.
  User: liuwenxuan
  Date: 2023/5/14
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    #studentInfo td {
        width: 100px;
        text-align: center;
        border: 1px solid black;
    }

    #studentInfo td:first-child {
        text-align: right;
    }
    #studentInfo td:nth-child(2) {
        width: 150px;
    }

    #studentInfo tr {
        margin-top: 10px;
    }
    #studentInfo {
        font-size: large;
        border-collapse: collapse;
        margin: auto;
    }
</style>
<table id="studentInfo">
    <tr>
        <td>学号</td>
        <td>${student.sno}</td>
    </tr>
    <tr>
        <td>姓名</td>
        <td>${student.username}</td>
    </tr>
    <tr>
        <td>性别</td>
        <td>${student.sex}</td>
    </tr>
    <tr>
        <td>学院</td>
        <td>${student.department}</td>
    </tr>
    <tr>
        <td>籍贯</td>
        <td>${student.jiguan}</td>
    </tr>
    <tr>
        <td>电子邮箱</td>
        <td>${student.email}</td>
    </tr>
    <tr>
        <td>联系电话</td>
        <td>${student.tel}</td>
    </tr>
    <tr>
        <td>照片</td>
        <td><img src="${student.image}" /></td>
    </tr>
</table>
