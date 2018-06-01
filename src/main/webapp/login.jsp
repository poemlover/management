<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>management-登录</title>

<meta content="management" name="keywords">
<meta content="management" name="description">

<link href="${APP_PATH }/static/css/bootstrap.min14ed.css" rel="stylesheet">
<link href="${APP_PATH }/static/css/font-awesome.min93e3.css" rel="stylesheet">

<link href="${APP_PATH }/static/css/animate.min.css" rel="stylesheet">
<link href="${APP_PATH }/static/css/style.min862f.css" rel="stylesheet">

<script src="${APP_PATH }/static/js/jquery.min.js"></script>
<script src="${APP_PATH }/static/js/bootstrap.min.js"></script>
<script src="${APP_PATH }/static/js/login.js"></script>
<script src="${APP_PATH }/static/js/common.js"></script>



</head>
<body class="gray-bg">
<div class="middle-box text-center loginscreen  animated fadeInDown">
    <div>
        <div>

            <h1 class="logo-name">Cool</h1>

        </div>
        <h3>欢迎使用 management</h3>

        <form class="m-t" role="form" id="adminlogin" method="post"
              name="adminlogin" onsubmit="return false" action="##">
            <div class="form-group">
                <input type="text" class="form-control" placeholder="用户名" name="userName" id="userName" required="">

            </div>
            <div class="form-group">
                <input type="password" class="form-control" placeholder="密码" name="password" id="password" required="">

            </div>
            <button type="button" class="btn btn-primary block full-width m-b" onclick="javascript:login();">登 录
            </button>
            <p class="text-muted text-center"><a href="##" onclick="javascript:adminlogin.reset();return false;">
                <small>重置</small>
            </a>
            </p>

        </form>
    </div>
</div>

	<%-- <form action="${APP_PATH }/users/cookie" method="post">
	
		id: <input type="text" name="id"/>
		<br>
		username: <input type="text" name="userName"/>
		<br>
		password: <input type="password" name="password"/>
		<br>
		roleName: <input type="text" name="roleName"/>
		<br>
		<input type="submit" value="Submit"/>
		
	</form> --%>

</body>
</html>