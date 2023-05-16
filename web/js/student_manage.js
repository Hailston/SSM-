var student_manage_tool = null;
$(function () {
    initStudentManageTool(); //建立Student管理对象
    $('#fb').filebox({
        buttonText: '选择文件',
        buttonAlign: 'right',
        accept:'.xlsx'
    })
    $("#student_manage").datagrid({
        url : '/admin/student/list',
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
        sortName : "sno",
        sortOrder : "desc",
        toolbar : "#student_manage_tool",
        columns : [[
            {
                field : "sno",
                title : "学号",
                width : 140,
            },
            {
                field : "username",
                title : "姓名",
                width : 140,
            },
            {
                field : "sex",
                title : "性别",
                width : 40,
            },
            {
                field : "department",
                title : "院系",
                width : 140,
            },
            {
                field : "jiguan",
                title : "籍贯",
                width : 140,
            },
            {
                field : "mark",
                title : "学分",
                width : 140,
            },
            {
                field : "image",
                title : "学生照片",
                width : "70px",
                height: "65px",
                formatter: function(val,row) {
                    return "<img src='" + val + "' width='65px' height='55px' />";
                }
            },
            {
                field : "email",
                title : "学生邮箱",
                width : 140,
            },
            {
                field : "tel",
                title : "联系电话",
                width : 140,
            },
            {
                field : "maxClasses",
                title : "最大选课数",
                width : 140,
            },
        ]],
    });

});

function initStudentManageTool() {
    student_manage_tool = {
        reload : function () {
            $("#student_manage").datagrid("reload");
        },
        search: function() {
            var queryParams = $("#student_manage").datagrid("options").queryParams;
            queryParams["keyword"] = $("#studentName").val();

            $("#student_manage").datagrid("options").queryParams = queryParams;
            $("#student_manage").datagrid("load");
        },
        importExcel: function() {
            $("#studentImport").form({
                url:"/admin/student/import",
                success:function(data){
                    var obj = jQuery.parseJSON(data);
                    if(obj.success){
                        $.messager.alert("消息","导入成功！");
                        $(".messager-window").css("z-index",10000);
                        $("#studentImport").form("clear");
                    }else{
                        $.messager.alert("消息",obj.message);
                        $(".messager-window").css("z-index",10000);
                    }
                    $("#student_manage").datagrid("reload");
                }
            });
            //提交表单
            $("#studentImport").submit();
        },
    };
}
