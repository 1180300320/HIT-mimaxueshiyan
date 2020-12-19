<%--
  Created by IntelliJ IDEA.
  User: libra
  Date: 2020/12/19
  Time: 13:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>新用户注册</title>
    <link rel="stylesheet" href="${appContext}/css/bootstrap.css" />
</head>
<body>
<div class="container">
    <form method="post" action="${appContext}/user/add" class="form-horizontal" role="form">
        <div class="form-group">
            <label for="usernameInput" class="col-sm-2 control-label">名字</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" id="usernameInput" name="username" placeholder="请输入名字">
            </div>
            <div id="usernameTips" class="help-block col-sm-2"></div>
        </div>
        <div class="form-group">
            <label for="password" class="col-sm-2 control-label">密码</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" id="password" name="password" placeholder="请输入密码">
            </div>
            <div class="help-block col-sm-2"></div>
        </div>

        <div class="radio">
            <label>
                <input type="radio" name="usertype" id="optionsRadios1" value="user" checked> 用户
            </label>
        </div>
        <div class="radio">
            <label>
                <input type="radio" name="usertype" id="optionsRadios2" value="shopper" checked> 商家
            </label>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-block btn-primary">注册</button>
            </div>
        </div>
    </form>
</div>

<script src="${appContext}/js/jquery-3.3.1.js"></script>
<script src="${appContext}/js/bootstrap.js"></script>
</body>
</html>
