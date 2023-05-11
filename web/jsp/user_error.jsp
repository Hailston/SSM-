<%--
  Created by IntelliJ IDEA.
  User: liuwenxuan
  Date: 2023/5/11
  Time: 22:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>错误提示</title>
    <link href="/css/style.css" rel="stylesheet">
</head>
<body>
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
    <tr>
        <td align="center">
            <table width="419" height="226" border="0" cellpadding="0" cellspacing="0">
                <tr>
                    <td align="center" background="/images/error.jpg">
                        <table width="388" height="194" border="0" cellpadding="0" cellspacing="0">
                            <tr>
                                <td align="center"><img src="/images/error_b.gif" width="31"
                                                        height="31">&nbsp;&nbsp;${exception.message }<br>
                                    <br>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>
</body>
</html>
