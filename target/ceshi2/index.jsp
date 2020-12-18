<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<%--获取应用名以方便接下来地址跳转--%>
<%
    String appPath = request.getContextPath();
    request.getSession().setAttribute("appContext",appPath);
%>

<html>
<body>
<h2>Hello World!</h2>
<a href="WEB-INF/welcome.jsp">welcome </a>
fhf
<a href="user/login">用户注册登录</a>
pppp
<a href="user/admin">跳转至后台管理</a>
</body>
</html>
