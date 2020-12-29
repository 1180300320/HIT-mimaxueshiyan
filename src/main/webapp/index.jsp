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
    <link rel="stylesheet" href="${appContext}/css/bootstrapgai.css" />
    <style type="text/css">
            .setbg{
                background: url("css/beijing.jpg");
                height: 572px;
            }
    </style>

</head>
<body>
    <div class=".text-center">
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-12">
                <h1>          欢迎使用电子商城!请先登录</h1>
            </div>
        </div>

        <%--<a href="${appContext}/user/shop">电子商城系统</a>--%>
        <%--<br>--%>
        <br><br><br><br><br>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-12">
                <a class="btn btn-lg btn-block btn-primary" href="${appContext}/user/register">用户注册</a>
            </div>
        </div>

        <br><br><br><br>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-12">
                <a class="btn btn-lg btn-block btn-primary" href="${appContext}/user/login">用户登录</a>
            </div>
        </div>

        <%--<br>--%>
        <%--<a href="${appContext}/user/admin">跳转至后台管理</a>--%>
    </div>



<script src="${appContext}/js/jquery-3.3.1.js"></script>
<script src="${appContext}/js/bootstrap.js"></script>
</body>
</html>
