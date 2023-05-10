<%--
  Created by IntelliJ IDEA.
  User: liuwenxuan
  Date: 2023/5/10
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="/css/teacher.css" />
<div id="teacherAddDiv">
    <form id="teacherAddForm" enctype="multipart/form-data"  method="post">
        <div>
            <span class="label">教师编号:</span>
            <span class="inputControl">
				<input class="textbox" type="text" id="tno" name="tno" style="width:200px" />
			</span>
        </div>

        <div>
            <span class="label">教师姓名:</span>
            <span class="inputControl">
				<input class="textbox" type="text" id="tname" name="tname" style="width:200px" />
			</span>
        </div>

        <div>
            <span class="label">年龄:</span>
            <span class="inputControl">
				<input class="textbox" type="text" id="age" name="age" style="width:200px" />
			</span>
        </div>

        <div>
            <span class="label">教师类型:</span>
            <span class="inputControl">
                <select class="textbox" name="teaType">
                    <option value="助教" selected>助教</option>
                    <option value="讲师">讲师</option>
                    <option value="副教授">副教授</option>
                    <option value="教授">教授</option>
                </select>
			</span>
        </div>

        <div>
            <span class="label">登录密码:</span>
            <span class="inputControl">
				<input class="textbox" type="text" id="password" name="password" style="width:200px" />
			</span>
        </div>

        <div>
            <span class="label">联系电话:</span>
            <span class="inputControl">
				<input class="textbox" type="text" id="tel" name="tel" style="width:200px" />
			</span>
        </div>

        <div>
            <span class="label">电子邮箱:</span>
            <span class="inputControl">
				<input class="textbox" type="text" id="email" name="email" style="width:200px" />
			</span>
        </div>

        <div class="operation">
            <a id="teacherAddButton" class="easyui-linkbutton">添加</a>
            <a id="teacherClearButton" class="easyui-linkbutton">重填</a>
        </div>
    </form>
</div>
<script src="/js/teacher_add.js"></script>