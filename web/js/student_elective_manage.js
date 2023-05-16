var student_elective_manage_tool = {
    reload: () => {
        $("#student_elective_course_manage").datagrid("reload");
    },
    search: () => {
        var queryParams = $("#student_elective_course_manage").datagrid("options").queryParams;
        queryParams["keyword"] = $("#courseName").val();
        $("#student_elective_course_manage").datagrid("options").queryParams = queryParams;
        $("#student_elective_course_manage").datagrid("load");
    },
    selectCourse: () => {
        $("#elective_course_info").datagrid({
            url: '/student/course/select',
            fit: true,
            fitColumns: true,
            method: 'get',
            striped: true,
            border: false,
            rownumbers: true,
            singleSelect: true,
            columns: [
                [
                    {
                        field: "cname",
                        title: "课程名",
                        width: '80px'
                    },
                    {
                        field: "tname",
                        title: "授课教师",
                        width: '80px'
                    },
                    {
                        field: "cmark",
                        title: "学分",
                        width: '80px'
                    },
                    {
                        field: "chooseMax",
                        title: "最大选课人数",
                        width: '80px',
                    },
                    {
                        field: "chooseCurNum",
                        title: "已选人数",
                        width: '80px',
                    },
                ]
            ]
        })
        $("#select_course_dialog").dialog("open");
    }
};

$(() => {

    $("#student_elective_course_manage").datagrid({
        url: '/student/elective/page',
        fit: true,
        fitColumns: true,
        striped: true,
        rownumbers: true,
        border: false,
        pagination: true,
        singleSelect: true,
        pageSize: 5,
        pageList: [5, 10, 15, 20, 25],
        pageNumber: 1,
        sortName: "id",
        sortOrder: "desc",
        toolbar: "#student_elective_course_manage_tool",
        columns: [[
            {
                field: "id",
                title: "课程编号",
                width: 140,
            },
            {
                field: "cname",
                title: "课程名",
                width: 140,
            },
            {
                field: "room",
                title: "教室",
                width: 140,
            },
            {
                field: "courTime",
                title: "上课时间",
                width: 140,
            },
            {
                field: "cmark",
                title: "学分",
                width: 140,
            },
            {
                field: "cscore",
                title: '成绩',
                width: 140,
            }
        ]],
    });

    $("#select_course_dialog").dialog({
        title: "选课",
        top: "50px",
        width: 400,
        height: 515,
        modal: true,
        closed: true,
        iconCls: "icon-edit-new",
        buttons: [
            {
                text: "选择",
                iconCls: "icon-edit-new",
                handler: () => {

                    // TODO 选课请求未完成
                    const data = $('#elective_course_info').datagrid('getSelections');
                    console.log(data)
                    if (data.length === 0) {
                        $.messager.alert("获取失败！", "未知错误导致失败，请重试！", "warning");
                    }
                    $.ajax({
                        url: "/student/course/select",
                        type: "post",
                        contentType: 'application/json',
                        data: JSON.stringify(data[0]),
                        dataType: 'json',
                        beforeSend: () => {
                            $.messager.progress({
                                text: "正在提交中...",
                            });
                        },
                        success: (res) => {
                            $.messager.progress("close");
                            if (res.success) {
                                $("#elective_course_info").datagrid("reload");
                                $.messager.alert("成功", res.message, "success");
                            } else {
                                $.messager.alert("获取失败！", "未知错误导致失败，请重试！", "warning");
                            }
                        }
                    });
                },
            },
            {
                text: "取消",
                iconCls: "icon-redo",
                handler: () => {
                    $("#select_course_dialog").dialog("close");
                },
            }
        ],
    });
});
