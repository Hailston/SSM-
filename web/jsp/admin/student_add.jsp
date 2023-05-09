<%--
  Created by IntelliJ IDEA.
  User: liuwenxuan
  Date: 2023/5/9
  Time: 17:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="/css/student.css" />
<div id="studentAddDiv">
    <form id="studentAddForm" enctype="multipart/form-data"  method="post">
        <div>
            <span class="label">学号:</span>
            <span class="inputControl">
				<input class="textbox" type="text" id="sno" name="sno" style="width:200px" />
			</span>
        </div>
        <div>
            <span class="label">用户名:</span>
            <span class="inputControl">
				<input class="textbox" type="text" id="username" name="username" style="width:200px" />
			</span>
        </div>

        <div>
            <span class="label">密码:</span>
            <span class="inputControl">
				<input class="textbox" type="text" id="password" name="password" style="width:200px" />
			</span>
        </div>
        <div>
            <span class="label">性别:</span>
            <span class="inputControl">
				<input type="radio" name="sex" value="男" checked/> 男
				<input type="radio" name="sex" value="女"/> 女
			</span>
        </div>

        <div>
            <span class="label">院系:</span>
            <span class="inputControl">
                <select class="textbox" name="department">
                    <option value="汽车工程学院" selected>汽车工程学院</option>
                    <option value="机械工程学院">机械工程学院</option>
                    <option value="电气工程学院">电气工程学院</option>
                    <option value="信息工程学院">信息工程学院</option>
                    <option value="经济管理学院">经济管理学院</option>
                    <option value="商务贸易学院">商务贸易学院</option>
                    <option value="工业设计与艺术学院">工业设计与艺术学院</option>
                </select>
			</span>
        </div>

        <div>
            <span class="label">籍贯:</span>
            <span class="inputControl">
                <select class="textbox" name="jiguan">
                    <option value="北京" selected>北京</option>
                </select>
			</span>
        </div>

        <div>
            <span class="label">学分:</span>
            <span class="inputControl">
                <input class="textbox" type="text" name="mark" />
			</span>
        </div>

<%--        <div>--%>
<%--            <span class="label">学生照片:</span>--%>
<%--            <span class="inputControl">--%>
<%--				<input id="studentPhotoFile" name="studentPhotoFile" type="file" size="50" />--%>
<%--			</span>--%>
<%--        </div>--%>

        <div>
            <span class="label">学生邮箱:</span>
            <span class="inputControl">
				<input class="textbox" type="text" id="email" name="email" style="width:200px" />
			</span>
        </div>

        <div>
            <span class="label">联系电话:</span>
            <span class="inputControl">
				<input class="textbox" type="text" id="tel" name="tel" style="width:200px" />
			</span>
        </div>

        <div>
            <span class="label">最大选课数:</span>
            <span class="inputControl">
				<input class="textbox" type="text" id="maxClasses" name="maxClasses" />
			</span>
        </div>

        <div class="operation">
            <a id="studentAddButton" class="easyui-linkbutton">添加</a>
            <a id="studentClearButton" class="easyui-linkbutton">重填</a>
        </div>
    </form>
</div>
<script src="/js/student_add.js"></script>