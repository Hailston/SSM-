var classes_manage_tool = null;
$(function () {
    initCourseInfoManageTool(); //建立CourseInfo管理对象
    classes_manage_tool.init(); //如果需要通过下拉框查询，首先初始化下拉框的值
    $('#fb').filebox({
        buttonText: '选择文件',
        buttonAlign: 'right',
        accept:'.xlsx'
    })
    $("#classes_manage").datagrid({
        url : '/admin/classes/list',
        fit : true,
        fitColumns : true,
        striped : true,
        rownumbers : true,
        border : false,
        pagination : true,
        singleSelect: true,
        pageSize : 5,
        pageList : [5, 10, 15, 20, 25],
        pageNumber : 1,
        sortName : "courseNumber",
        sortOrder : "desc",
        toolbar : "#classes_manage_tool",
        columns : [[
            {
                field : "teacherId",
                title : "教师号",
                width : 140,
            },
            {
                field : "cname",
                title : "课程名称",
                width : 140,
            },
            {
                field : "chooseMax",
                title : "最大选课人数",
                width : 140,
            },
            {
                field : "chooseCurNum",
                title : "已选人数",
                width : 140,
            },
            {
                field : "courTime",
                title : "上课时间",
                width : 140,
            },
            {
                field : "room",
                title : "上课地点",
                width : 140,
            },
            {
                field : "cmark",
                title : "课程学分",
                width : 70,
            },
            {
                field : "ctype",
                title : "课程类别",
                width : 70,
            },
        ]],
    });

});

function initCourseInfoManageTool() {
    classes_manage_tool = {
        init: function() {
        },
        reload : function () {
            $("#classes_manage").datagrid("reload");
        },
        search: function() {
            var queryParams = $("#classes_manage").datagrid("options").queryParams;
            queryParams["courseNumber"] = $("#courseNumber").val();
            queryParams["courseName"] = $("#courseName").val();
            queryParams["courseTeacher.teacherNumber"] = $("#courseTeacher_teacherNumber_query").combobox("getValue");
            $("#classes_manage").datagrid("options").queryParams=queryParams;
            $("#classes_manage").datagrid("load");
        },
        importExcel: function() {
            $("#classesImport").form({
                url:"/admin/classes/import",
                success:function(data){
                    var obj = jQuery.parseJSON(data);
                    if(obj.success){
                        $.messager.alert("消息","导入成功！");
                        $(".messager-window").css("z-index",10000);
                        $("#classesImport").form("clear");
                    }else{
                        $.messager.alert("消息",obj.message);
                        $(".messager-window").css("z-index",10000);
                    }
                    $("#classes_manage").datagrid("reload");
                }
            });
            //提交表单
            $("#classesImport").submit();
        },
    };
}
