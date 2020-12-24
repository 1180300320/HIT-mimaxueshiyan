<%--
  Created by IntelliJ IDEA.
  User: libra
  Date: 2020/12/13
  Time: 9:08
  To change this template use File | Settings | File Templates.
--%>
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
    <title>添加一个新用户</title>
    <link rel="stylesheet" href="${appContext}/css/bootstrap.css" />
</head>
<body>
<div class="container">
    <form method="post" action="${appContext}/user/logincompare" class="form-horizontal" role="form">
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


        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-block btn-success">登录</button>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="reset" class="btn btn-block btn-primary">重置</button>
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <a class="btn btn-block btn-primary" href="${appContext}/user/register">注册新用户</a>
            </div>
        </div>
    </form>
</div>
<%--<script>--%>
<%--    if(${requestScope.msg}!= null)--%>
<%--        alert(${requestScope.msg})--%>
<%--</script>--%>
${requestScope.msg}

<script src="${appContext}/js/jquery-3.3.1.js"></script>
<script src="${appContext}/js/bootstrap.js"></script>
</body>
</html>
