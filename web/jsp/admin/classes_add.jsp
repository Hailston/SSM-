<%--
  Created by IntelliJ IDEA.
  User: liuwenxuan
  Date: 2023/5/11
  Time: 09:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="/css/classes.css" />
<div id="courseInfoAddDiv">
    <form id="courseInfoAddForm" enctype="multipart/form-data"  method="post">

        <div>
            <span class="label">课程名称:</span>
            <span class="inputControl">
				<input class="textbox" type="text" id="cname" name="cname" style="width:200px" />
			</span>
        </div>
        <div>
            <span class="label">教师号:</span>
            <span class="inputControl">
				<input class="textbox" type="text" id="teacherId" name="teacherId" style="width: auto"/>
			</span>
        </div>

        <div>
            <span class="label">课程学分:</span>
            <span class="inputControl">
				<input class="textbox" type="text" id="cmark" name="cmark" style="width:auto" />
			</span>
        </div>
        <div>
            <span class="label">最大选课容量:</span>
            <span class="inputControl">
				<input class="textbox" type="text" id="chooseMax" name="chooseMax" style="width:auto" />
			</span>
        </div>

        <div>
            <span class="label">上课时间:</span>
            <span class="inputControl">
				<input class="textbox" type="text" id="courTime" name="courTime" style="width:200px" />
			</span>
        </div>
        <div>
            <span class="label">上课地点:</span>
            <span class="inputControl">
				<input class="textbox" type="text" id="room" name="room" style="width:200px" />
			</span>
        </div>

        <div class="operation">
            <a id="courseInfoAddButton" class="easyui-linkbutton">添加</a>
            <a id="courseInfoClearButton" class="easyui-linkbutton">重填</a>
        </div>

    </form>
</div>
<script src="/js/classes_add.js"></script>
