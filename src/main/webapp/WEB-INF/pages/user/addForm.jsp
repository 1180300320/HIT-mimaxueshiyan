<%--
  Created by IntelliJ IDEA.
  User: libra
  Date: 2020/12/18
  Time: 19:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8" />
    <title>添加一个新用户</title>
</head>
<body>
    <form method="post" action="${appContext}/user/add" />
        <input type="text" name="username" placeholder="请输入用户名" />
        <input type="text" name="password" placeholder="请输入密码" /><br>

        <input type="radio" name="usertype" value="user">用户
        <input type="radio" name="usertype" value="shopper">商家<br>

        <input type="submit" value="添加" />
</body>
</html>
