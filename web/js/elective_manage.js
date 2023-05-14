var editIndex = undefined;
const endEditing = () => {
    if (editIndex == undefined) {
        return true
    }
    if ($('#elective_student_score').datagrid('validateRow', editIndex)) {
        $('#elective_student_score').datagrid('endEdit', editIndex);
        editIndex = undefined;
        return true;
    } else {
        return false;
    }
}
const onClickRow = (index) => {
    if (editIndex != index) {
        if (endEditing()) {
            $('#elective_student_score').datagrid('selectRow', index)
                .datagrid('beginEdit', index);
            editIndex = index;
        } else {
            $('#elective_student_score').datagrid('selectRow', editIndex);
        }
    }
}

const initScoreTable = (data) => {
    $("#elective_student_score").datagrid({
        data: data.data,
        fit: true,
        fitColumns: true,
        striped: true,
        border: false,
        rownumbers: true,
        onClickRow: onClickRow,
        singleSelect: true,
        toolbar: '#tb',
        columns: [
            [
                {
                    field: "sno",
                    title: "学号",
                    width: '80px'
                },
                {
                    field: "username",
                    title: "姓名",
                    width: '130px'
                },
                {
                    field: "cscore",
                    title: "分数",
                    width: '130px',
                    editor: 'numberbox'
                },
            ]
        ]
    })
    $('#saveBtn').linkbutton({
        iconCls: 'icon-save',
        plain: true,
    });
}

var elective_manage_tool = {
    reload: function () {
        $("#elective_course_manage").datagrid("reload");
    },
    search: function () {
        // TODO 搜索课程
    },
    save: () => {
        $('#elective_student_score').datagrid('endEdit', editIndex);
    },
    enterScore: () => {
        const rows = $("#elective_course_manage").datagrid("getSelections");
        if (rows.length === 1) {
            $.ajax({
                url: "/teacher/course/" + rows[0].id + "/student",
                type: "get",
                data: {},
                dataType: 'json',
                beforeSend: () => {
                    $.messager.progress({
                        text: "正在获取中...",
                    });
                },
                success: (data) => {
                    $.messager.progress("close");
                    if (data.success) {
                        initScoreTable(data);
                        $("#enter_elective_score_dialog").dialog("open");
                    } else {
                        $.messager.alert("获取失败！", "未知错误导致失败，请重试！", "warning");
                    }
                }
            });
        } else if (rows.length === 0) {
            $.messager.alert("警告操作！", "请选择课程！", "warning");
        }
    },
};

$(() => {

    $("#elective_course_manage").datagrid({
        url: '/teacher/elective/page',
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
        toolbar: "#elective_course_manage_tool",
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
                field: "chooseCurNum",
                title: "选课总人数",
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
        ]],
    });

    $("#enter_elective_score_dialog").dialog({
        title: "成绩录入",
        top: "50px",
        width: 400,
        height: 515,
        modal: true,
        closed: true,
        iconCls: "icon-edit-new",
        buttons: [
            {
                text: "提交",
                iconCls: "icon-edit-new",
                handler: () => {
                    const data = $("#elective_student_score").datagrid('getData');
                    console.log(data)
                    $.ajax({
                        url: "/teacher/score",
                        type: "post",
                        contentType: 'application/json',
                        data: JSON.stringify(data.rows),
                        dataType: 'json',
                        beforeSend: () => {
                            $.messager.progress({
                                text: "正在提交中...",
                            });
                        },
                        success: (data) => {
                            $.messager.progress("close");
                            if (data.success) {
                                $("#enter_elective_score_dialog").dialog("close");
                                $.messager.alert("成功", "提交成功", "success");
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
                handler: function () {
                    $("#enter_elective_score_dialog").dialog("close");
                },
            }
        ],
    });
});
