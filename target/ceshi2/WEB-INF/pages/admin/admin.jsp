<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>后台管理系统</title>
    <link rel="stylesheet" href="${appContext}/css/bootstrap.css" />
    <base target="mainF" />

</head>
<body>
<div class="container-fluid">
    <div class="row">
        电子商城后台管理系统    欢迎您:${sessionScope.USER_SESSION.username}
        <a target="_self" href="${appContext}/user/logout">退出登录</a>
    </div>
</div>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-12 col-md-2">
            <ul>
                <h4>用户管理</h4>
                <ul>
                    <li><a href="${appContext}/admin/userList">用户列表</a></li>
                    <li><a href="${appContext}/user/addForm">添加新用户</a></li>
                </ul>
                <h4>商品管理</h4>
                <ul>
                    <li><a href="${appContext}/admin/goodsList">商品列表</a></li>
                    <li>商品修改</li>
                </ul>
            </ul>
        </div>
        <div class="col-sm-12 col-md-10">
            <iframe name="mainF" width="100%" height="500" frameborder="0"></iframe>
        </div>
    </div>
</div>

<script src="${appContext}/js/jquery-3.3.1.js"></script>
<script src="${appContext}/js/bootstrap.js"></script>
</body>
</html>
