<%--
  Created by IntelliJ IDEA.
  User: whc
  Date: 2020/4/13
  Time: 10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>登录界面</title>
    <base href="<%=basePath%>">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/static/css/style.css">
    <link rel="stylesheet" type="text/css" href="static/css/demo.css">
    <script type="text/javascript" src="static/js/jquery-3.4.1.js"></script>
    <script type="text/javascript" src="static/js/jquery.easyui.min.js"></script>
    <script type="text/javascript">
        function submit() {
            var username = $("#login-name").val();
            var password = $("#login-pass").val();
            if (username == "" || username.length == 0) {
                alert('用户名不能为空!');
                return false;
            }
            if (password == "" || password.length == 0) {
                alert('密码不能为空!');
                return false;
            }
            $("#loginForm").submit();
        }

        function reset() {
            $("#login-name").val("");
            $("#login-pass").val("");
        }

    </script>
</head>
<body>
<div class="login">
    <form id="loginForm" class="login-screen" action="admin/main" method="post">
        <div class="app-title">
            <h1>登录</h1>
        </div>
        <div class="login-form">
            <div class="control-group">
                <input type="text" class="login-field" value="admin" placeholder="用户名" name="username" id="login-name">
                <label class="login-field-icon fui-user" for="login-name"></label>
            </div>

            <div class="control-group">
                <input type="password" class="login-field" value="123" placeholder="密码" name="password" id="login-pass">
                <label class="login-field-icon fui-lock" for="login-pass"></label>
            </div>
            <div class="control-group">
                <button class="btn btn-primary btn-large btn-block" onclick="javascript:submit()">登录</button>
                <br>
                <button class="btn btn-primary btn-large btn-block " onclick="javascript:reset()">重置</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
