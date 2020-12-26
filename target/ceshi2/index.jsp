<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<%--获取应用名以方便接下来地址跳转--%>
<%
    String appPath = request.getContextPath();
    request.getSession().setAttribute("appContext",appPath);
%>

<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>欢迎使用电子商城!</title>
    <link rel="stylesheet" href="${appContext}/css/bootstrap.css" />

</head>
<body>
<div class=".text-center">
    <h2>欢迎使用电子商城!请先登录</h2>
    <%--<a href="${appContext}/user/shop">电子商城系统</a>--%>
    <%--<br>--%>
    <a href="${appContext}/user/register">用户注册</a>
    <br>
    <a href="${appContext}/user/login">用户登录</a>
    <%--<br>--%>
    <%--<a href="${appContext}/user/admin">跳转至后台管理</a>--%>
</div>


<script src="${appContext}/js/jquery-3.3.1.js"></script>
<script src="${appContext}/js/bootstrap.js"></script>
</body>
</html>
