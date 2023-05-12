<%--
  Created by IntelliJ IDEA.
  User: liuwenxuan
  Date: 2023/5/12
  Time: 19:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head><title>修改密码</title>
    <style type=text/css>
        BODY {
            MARGIN-LEFT: 0px;
            BACKGROUND-COLOR: #ffffff
        }

        .STYLE1 {
            color: #ECE9D8
        }

        .label {
            font-style: italic;
        }

        .errorLabel {
            font-style: italic;
            color: red;
        }

        .errorMessage {
            font-weight: bold;
            color: red;
        }
    </style>

</head>

<body>

<table align="center" cellSpacing=0 cellPadding=0 width="80%" border=0>
    <tbody>
    <tr>
        <td align="left" vAlign=top><br>
            <form id="infoEditForm" method="post" name="form1">
                <table width='100%' cellspacing='1' cellpadding='3' bgcolor='#CCCCCC' class="tablewidth">
                    <tr>
                        <td align="right" width="35%">教师编号:</td>
                        <td width=65%>${teacher.tno}</td>
                    </tr>
                    <tr>
                        <td align="right" width="35%">姓名:</td>
                        <td width=65%>${teacher.tname}</td>
                    </tr>
                    <tr>
                        <td align="right" width="35%">年龄:</td>
                        <td width=65%><input name="age" type='text' id="age" value="${teacher.age}" /></td>
                    </tr>
                    <tr>
                        <td align="right" width="35%">电子邮箱:</td>
                        <td width=65%><input name="email" type='text' id="email" value="${teacher.email}"/></td>
                    </tr>
                    <tr>
                        <td align="right" width="35%">联系电话:</td>
                        <td width=65%><input name="tel" type='text' id="tel" value="${teacher.tel}" /></td>
                    </tr>
                    <tr>
                        <td align="right" width="35%">职称:</td>
                        <td width=65%>${teacher.teaType}</td>
                    </tr>
                    <tr bgcolor='#FFFFFF'>
                        <td colspan="4" align="center">
                            <input type='button' name='button' id="editButton" value='修改'>
                            &nbsp;&nbsp;
                        </td>
                    </tr>

                </table>
            </form>
        </td>
    </tr>
    </tbody>
</table>
<script src="/js/teacher_info_modify.js" />
</body>
</html>