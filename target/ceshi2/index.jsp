<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<%--获取应用名以方便接下来地址跳转--%>
<%
    String appPath = request.getContextPath();
    request.getSession().setAttribute("appContext",appPath);
%>

<html>
<body>
<h2>欢迎使用电子商城!请先登录</h2>
<a href="user/shop">电子商城系统</a>
<br>
<a href="user/register">用户注册</a>
<br>
<a href="user/login">用户登录</a>
<br>
<a href="user/admin">跳转至后台管理</a>
</body>
</html>
