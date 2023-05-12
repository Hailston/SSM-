$(
    () => {
        $("#age").validatebox({
            required: false,
            validType: 'age'
        });
        $("#email").validatebox({
            required: false,
            validType: 'email'
        });
        $("#tel").validatebox({
            required: false,
            validType: 'mobile'
        });
        $("#editButton").click(()=>{
            if ($("#infoEditForm").form("validate")){
                $("#infoEditForm").form({
                    url:"/teacher/infoEdit",
                    onSubmit:()=>{
                        $.messager.progress({
                            text:"正在提交数据中..."
                        });
                        return true;
                    },
                    success:(response)=>{
                        $.messager.progress("close");
                       const data = jQuery.parseJSON(response);
                       if (data.success){
                           $.messager.alert("消息","保存成功！");
                           $(".messager-window").css("z-index",10000);
                           $("#studentAddForm").form("clear");
                       }else {
                           $.messager.alert("消息",obj.message);
                           $(".messager-window").css("z-index",10000);
                       }
                    }
                })

                $("#infoEditForm").submit();
            }else {
                $.messager.alert("错误提示","你输入的信息还有错误", "warning");
                $(".messager-window").css("z-index",10000);
            }
        })
    }
);