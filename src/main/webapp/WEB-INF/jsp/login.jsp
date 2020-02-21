<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>登录配置中心</title>
  <meta name="author" content="Vincent Garreau" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
  <link rel="stylesheet" media="screen" href="login/css/style.css">
  <link rel="stylesheet" type="text/css" href="login/css/reset.css"/>
</head>
<body>

<div id="particles-js">
		<div id="login" class="login">
			<div class="login-top">
				登录配置中心
			</div>
			<div class="login-center clearfix">
				<div class="login-center-img"><svg t="1581328639443" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="2525" width="25" height="25"><path d="M510.958 555.761c133.137 0 241.194-110.1 241.194-245.811C752.152 174.207 644.095 64 510.958 64c-133.206 0-241.263 110.1-241.263 245.95s108.057 245.811 241.263 245.811z m148.441 3.669c-35.891 1.54-75.231 40.057-148.441 40.057s-128.549-40.281-144.4-40.057c-127.714 0-233.559 177.217-233.559 308.721 18.033 68.406 73.512 80.26 171.517 85.464 162.6 9.236 393.469 9.236 477.345-5.2 74.825-11.82 113.48-24.984 111.028-80.26 0.035-130.194-104.5-308.722-233.491-308.722z" p-id="2526" fill="#707070"></path></svg></div>
				<div class="login-center-input">
					<input type="text" id="userName" name="userName" value="" placeholder="请输入您的用户名" onfocus="this.placeholder=''" onblur="this.placeholder='请输入您的用户名'"/>
					<div class="login-center-input-text">用户名</div>
				</div>
			</div>
			<div class="login-center clearfix">
				<div class="login-center-img"><svg t="1581328844031" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="5058" width="25" height="25"><path d="M821.272297 445.829951l-84.699054 0L736.573243 291.183825c0-125.374452-91.90313-227.065506-205.340715-227.065506l-38.488593 0c-113.420189 0-205.322295 101.691053-205.322295 227.065506l0 154.647149-84.699054 0c-22.694885 0-41.074487 20.301372-41.074487 45.428655l0 422.806585c0 25.052582 18.379603 45.390793 41.074487 45.390793l618.548688 0c22.695908 0 41.076534-20.338211 41.076534-45.390793L862.347808 491.258607C862.348831 466.131323 843.968206 445.829951 821.272297 445.829951zM511.998465 880.003422c-42.863227 0-77.647451-38.394449-77.647451-85.837994 0-30.145577 14.066367-56.56632 35.297924-71.888284L469.648938 573.940724c0-23.757077 18.361183-42.957371 41.076534-42.957371 22.694885 0 41.037648 19.200294 41.037648 42.957371l0 146.589636c22.658046 14.976086 37.883819 42.348504 37.883819 73.635067C589.645916 841.609996 554.861692 880.003422 511.998465 880.003422zM670.674371 445.829951 360.545054 445.829951 360.545054 308.136939c0-84.278475 63.504336-152.630213 141.797493-152.630213l26.572192 0c78.293157 0 141.759631 68.351738 141.759631 152.630213L670.674371 445.829951z" p-id="5059" fill="#707070"></path></svg></div>
				<div class="login-center-input">
					<input type="password" id="userPass" name="userPass"value="" placeholder="请输入您的密码" onfocus="this.placeholder=''" onblur="this.placeholder='请输入您的密码'"/>
					<div class="login-center-input-text">密码</div>
				</div>
			</div>
			<div class="login-center clearfix" style=" text-align: right; "></div>
			<div class="login-button" id="login-button">
				登　录
			</div>
		</div>
		<div class="sk-rotating-plane"></div>
</div>

<!-- scripts -->
<script src="login/js/particles.min.js"></script>
<script src="login/js/app.js"></script>
<script src="/layuiadmin/layui/layui.js"></script>
<script src="/js/common.js?v=1.1"></script>
<script src="/js/login.js?v=1.1"></script>
</body>
</html>


