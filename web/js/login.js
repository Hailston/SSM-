

$(function () {
	//登录界面
	$('#login').dialog({
		title : '登录',
		width : 300,
		height : 215,
		modal : true,
		iconCls : 'icon-login',
		buttons : '#btn',
	});
	
	//管理员帐号验证
	$('#manager').validatebox({
		required : true,
		missingMessage : '请输入帐号',
		invalidMessage : '帐号不得为空',
	});
	
	//管理员密码验证
	$('#password').validatebox({
		required : true,
		validType : 'length[1,30]',
		missingMessage : '请输入密码',
		invalidMessage : '密码长度1-30',
	});
	
	//加载时判断验证
	if (!$('#manager').validatebox('isValid')) {
		$('#manager').focus();
	} else if (!$('#password').validatebox('isValid')) {
		$('#password').focus();
	}
	
	
	//单击登录
	$('#btn a').click(function () {
		if (!$('#manager').validatebox('isValid')) {
			$('#manager').focus();
		} else if (!$('#password').validatebox('isValid')) {
			$('#password').focus();
		} else {
			$.ajax({
				url : '/login',
				type : 'post',
				data : {
					"username" : $('#manager').val(),
					"password" : $('#password').val(),
					"identify" : $('input:radio:checked').val()
				},
				beforeSend : function () {
					$.messager.progress({
						text : '正在登录中...',
					});
				},
				success : function (data, response, status) {
					$.messager.progress('close');  
					var obj = eval(data);
					if (obj.success) {
						location.href = obj.addr;
					} else {
						$.messager.alert('登录失败！', obj.msg, 'warning', function () {
							$('#password').select();
						});
					}
				}
			});
		}
	});
	
});