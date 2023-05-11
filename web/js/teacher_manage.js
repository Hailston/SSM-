var teacher_manage_tool = null;
$(function () {
    initTeacherManageTool(); //建立Teacher管理对象
    $('#fb').filebox({
        buttonText: '选择文件',
        buttonAlign: 'right',
        accept:'.xlsx'
    })
    $("#teacher_manage").datagrid({
        url : '/admin/teacher/list',
        fit : true,
        fitColumns : true,
        striped : true,
        rownumbers : true,
        border : false,
        pagination : true,
        pageSize : 5,
        pageList : [5, 10, 15, 20, 25],
        pageNumber : 1,
        sortName : "tno",
        sortOrder : "desc",
        toolbar : "#teacher_manage_tool",
        columns : [[
            {
                field : "tno",
                title : "教师编号",
                width : 140,
            },
            {
                field : "tname",
                title : "教师姓名",
                width : 140,
            },
            {
                field : "age",
                title : "年龄",
                width : 140,
            },
            {
                field : "email",
                title : "电子邮箱",
                width : 140,
            },
            {
                field : "tel",
                title : "联系电话",
                width : 140,
            },
            {
                field : "teaType",
                title : "教师类型",
                width : 140,
            },
        ]],
    });

});

function initTeacherManageTool() {
    teacher_manage_tool = {
        init: function() {
        },
        reload : function () {
            $("#teacher_manage").datagrid("reload");
        },
        search: function() {
            var queryParams = $("#teacher_manage").datagrid("options").queryParams;
            queryParams["teacherNumber"] = $("#teacherNumber").val();
            queryParams["teacherName"] = $("#teacherName").val();
            queryParams["teacherBirthday"] = $("#teacherBirthday").datebox("getValue");
            queryParams["teacherArriveDate"] = $("#teacherArriveDate").datebox("getValue");
            $("#teacher_manage").datagrid("options").queryParams=queryParams;
            $("#teacher_manage").datagrid("load");
        },
        importExcel: function() {

            $("#teacherImport").form({
                url:"/admin/teacher/import",
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
                    $("#teacher_manage").datagrid("reload");
                }
            });
            //提交表单
            $("#teacherImport").submit();
        },

    };
}
