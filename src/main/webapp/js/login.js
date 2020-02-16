layui.config({
	base : '/layuiadmin/' //静态资源所在路径
}).extend({
	index : 'lib/index' //主入口模块
}).use([ 'index', 'jquery' ], function() {
	var $ = layui.$
	, layer = layui.layer;
	$("#login-button").on('click',function(){
		$.ajax({
			url:'login',
			data:{userName:$('#userName').val(),userPass:$('#userPass').val()},
			type:'post',
			success:function(data){
				if (data.resultCode==0){
					window.location.href="/index"
				}
			}
		})
	})
	
	$('#registor-button').on('click',function(){
		var pass1 = $('#r-userPass').val();
		var pass2 = $('#r-userPass2').val();
		if (pass1 !== pass2){
			layer.msg('两次密码不一致！')
			return;
		}

		$.ajax({
			url:'login/add',
			data:{userName:$('#r-userName').val(),userPass:$('#r-userPass2').val(),realName:$('#r-realName').val(),email:$('#r-r-email').val()},
			type:'post',
			success:function(data){
				console.log(data);
			}
		})
	})
	
	$('#registor').on('click',function(){
		$('#login').addClass('hide');
		$('#regist').removeClass('hide');
	})
	
	$('#loginor').on('click',function(){
		$('#regist').addClass('hide');
		$('#login').removeClass('hide');
	})
	
})
