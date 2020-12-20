<%--
  Created by IntelliJ IDEA.
  User: libra
  Date: 2020/12/13
  Time: 9:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>后台管理系统</title>
    <base target="mainF" />
    <style type="text/css">
        *{
            margin: 0;padding: 0;
        }
        .top{
            width: 100%;
            height: 60px;
            background-color: #8341b6;
        }
        .left{
            width: 30%;
            background-color: #bd8139;
            float: left;
        }
        .main{
            width: 70%;
            background-color: #ffffff;
            float: left;
        }
    </style>
</head>
<body>
<div class="top">
    电子商城后台管理系统    欢迎您:xxx       <li><a target="_self" href="${appContext}/user/logout">退出登录</a></li>
</div>
<div class="left">
    <ul>
        <h4>用户管理</h4>
        <ul>
            <li><a href="${appContext}/admin/userList">用户列表</a></li>
            <li><a href="${appContext}/user/addForm">添加新用户</a></li>
        </ul>
        <h4>商品管理</h4>
        <ul>
            <li>商品列表</li>
            <li>商品修改</li>
        </ul>
    </ul>
</div>
<div class="main">主功能区
    <iframe name="mainF" width="100%" height="500"></iframe>
</div>
</body>
</html>
