var student_require_manage_tool = {
    reload: function () {
        $("#student_require_course_manage").datagrid("reload");
    },
    search: function () {
        var queryParams = $("#student_require_course_manage").datagrid("options").queryParams;
        queryParams["keyword"] = $("#courseName").val();
        $("#student_require_course_manage").datagrid("options").queryParams=queryParams;
        $("#student_require_course_manage").datagrid("load");
    },
};

$(() => {

    $("#student_require_course_manage").datagrid({
        url: '/student/require/page',
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
        toolbar: "#student_require_course_manage_tool",
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

});
