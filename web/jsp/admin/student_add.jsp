<%--
  Created by IntelliJ IDEA.
  User: liuwenxuan
  Date: 2023/5/9
  Time: 17:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="/css/student.css"/>
<div id="studentAddDiv">
    <form id="studentAddForm" enctype="multipart/form-data" method="post">
        <div>
            <span class="label">学号:</span>
            <span class="inputControl">
				<input class="textbox" type="text" id="sno" name="sno" style="width:200px"/>
			</span>
        </div>
        <div>
            <span class="label">用户名:</span>
            <span class="inputControl">
				<input class="textbox" type="text" id="username" name="username" style="width:200px"/>
			</span>
        </div>

        <div>
            <span class="label">密码:</span>
            <span class="inputControl">
				<input class="textbox" type="text" id="password" name="password" style="width:200px"/>
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
                    <option value="上海">上海</option>
                    <option value="天津">天津</option>
                    <option value="重庆">重庆</option>
                    <option value="河北">河北</option>
                    <option value="山西">山西</option>
                    <option value="辽宁">辽宁</option>
                    <option value="吉林">吉林</option>
                      <option value="黑龙江">黑龙江</option>
                      <option value="江苏">江苏</option>
                      <option value="浙江">浙江</option>
                      <option value="安徽">安徽</option>
                      <option value="福建">福建</option>
                      <option value="江西">江西</option>
                      <option value="山东">山东</option>
                      <option value="河南">河南</option>
                      <option value="湖北">湖北</option>
                      <option value="湖南">湖南</option>
                      <option value="广东">广东</option>
                      <option value="海南">海南</option>
                      <option value="四川">四川</option>
                      <option value="贵州">贵州</option>
                      <option value="云南">云南</option>
                      <option value="陕西">陕西</option>
                      <option value="甘肃">甘肃</option>
                      <option value="青海">青海</option>
                      <option value="台湾">台湾</option>
                      <option value="香港">香港</option>
                      <option value="澳门">澳门</option>
                </select>
			</span>
        </div>

        <div>
            <span class="label">学分:</span>
            <span class="inputControl">
                <input class="textbox" type="text" id="mark" name="mark"/>
			</span>
        </div>

        <div>
            <span class="label">学生照片:</span>
            <span class="inputControl">
				<input id="studentPhotoFile" name="studentPhotoFile" type="file" size="50"/>
			</span>
        </div>

        <div>
            <span class="label">学生邮箱:</span>
            <span class="inputControl">
				<input class="textbox" type="text" id="email" name="email" style="width:200px"/>
			</span>
        </div>

        <div>
            <span class="label">联系电话:</span>
            <span class="inputControl">
				<input class="textbox" type="text" id="tel" name="tel" style="width:200px"/>
			</span>
        </div>

        <div>
            <span class="label">最大选课数:</span>
            <span class="inputControl">
				<input class="textbox" type="text" id="maxClasses" name="maxClasses"/>
			</span>
        </div>

        <div class="operation">
            <a id="studentAddButton" class="easyui-linkbutton">添加</a>
            <a id="studentClearButton" class="easyui-linkbutton">重填</a>
        </div>
    </form>
</div>
<script src="/js/student_add.js"></script>