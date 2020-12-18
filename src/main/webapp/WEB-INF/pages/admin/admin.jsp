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
            background-color: #7c7ce3;
        }
        .left{
            width: 30%;
            background-color: #ac753a;
            float: left;
        }
        .main{
            width: 70%;
            background-color: #e3d594;
            float: left;
        }
    </style>
</head>
<body>
<div class="top">
    电子商城后台管理系统    欢迎您:xxx       退出登录
</div>
<div class="left">
    <ul>
        <li>用户管理</li>
        <ul>
            <li>
                <a href="${appContext}/admin/userList">用户列表</a></li>
            <li>添加新用户</li>
        </ul>
    </ul>
</div>
<div class="main">主功能区
    <iframe name="mainF" width="100%" height="500"></iframe>
</div>
</body>
</html>
