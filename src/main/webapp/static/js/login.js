function login() {
    var userName = $("#userName").val();
    var password = $("#password").val();
    var roleName = $("#roleName").val();
    if (userName == null || userName == "") {
        alert("用户名不能为空！");
        return;
    }
    if (password == null || password == "") {
        alert("密码不能为空！");
        return;
    }
    // alert($('#adminlogin').serialize());
    $.ajax({
        type: "POST",
        dataType: "json",// 这里设置为json，如果设置为text，则只能显示result有什么，而不能读取具体的k-v对
        //async: false,
        url: "users/cookie",// 这里不能多加个/,会出错
        data: $('#adminlogin').serialize(),
        success: function (result) {  // 这里一直进不去，是因为在springMVC配置文件中没有配置json消息转换器 & 参数解析
        	if (result.resultCode == 200) {// 登录成功，设置cookie
        		setCookie("userName",result.data.currentUser.userName);
        		setCookie("roleName",result.data.currentUser.roleName);
        		window.location.href = "main.jsp";// 设置完cookie之后跳转到main.jsp页面，即主页面
            }else{
            	alert("用户名或密码错误！");
            }
        },
        error: function (result) {
        	alert("异常！");
        }
    });

}