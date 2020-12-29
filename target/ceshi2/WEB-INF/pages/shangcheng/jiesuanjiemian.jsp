<%--
  Created by IntelliJ IDEA.
  User: libra
  Date: 2020/12/27
  Time: 23:33
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>\
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>订单结算</title>
    <link rel="stylesheet" href="${appContext}/css/bootstrap.css" />
    <link rel="stylesheet" href="${appContext}/css/bootstrap.min.css" rel="external nofollow" target="_blank"  rel="external nofollow" target="_blank"  rel="external nofollow" target="_blank"  rel="external nofollow" target="_blank"  rel="external nofollow" target="_blank"  rel="external nofollow" target="_blank"  rel="external nofollow" target="_blank"  rel="external nofollow" target="_blank"  rel="external nofollow" target="_blank"  rel="external nofollow" target="_blank"  rel="external nofollow" target="_blank" >
    <script src="${appContext}/js/jquery-3.3.1.js" rel="external nofollow"  rel="external nofollow"  rel="external nofollow"  rel="external nofollow"  rel="external nofollow"  rel="external nofollow"  rel="external nofollow"  rel="external nofollow"  rel="external nofollow"  rel="external nofollow"  rel="external nofollow" ></script>
    <script src="${appContext}/js/bootstrap.min.js" rel="external nofollow"  rel="external nofollow"  rel="external nofollow"  rel="external nofollow"  rel="external nofollow"  rel="external nofollow"  rel="external nofollow"  rel="external nofollow"  rel="external nofollow"  rel="external nofollow"  rel="external nofollow" ></script>
</head>
<body>

<%--var summoney = getnum()--%>
<script>
        var sum = 0;
        var price=0;
        var num=0;
        <c:forEach items="${gouwuchexianshi}" var="gouwuchexianshi">
        price=${gouwuchexianshi.itemprice};
        num=${gouwuchexianshi.number};
        sum+=price*num;
        <%--sum= sum+${gouwuchexianshi.itemprice}*${gouwuchexianshi.number};--%>
        </c:forEach>
        // print(sum);
        <%--document.getElementsByTagName("form")[0].setAttribute("action","${appContext}/jiesuan/tijiaoyinhang?uid=${sessionScope.USER_SESSION.uid}&num="+sum);--%>
        <%--$("#biaodan").attr("action","${appContext}/jiesuan/tijiaoyinhang?uid=${sessionScope.USER_SESSION.uid}&num="+sum);--%>
        $(document).ready(function(){
            $("#biaodan").mouseenter(function(){
                $("#biaodan").attr({
                    "action" : "${appContext}/jiesuan/tijiaoyinhang?uid=${sessionScope.USER_SESSION.uid}&num="+sum
                });
            });
        })
</script>

<%--action="${appContext}/index.jsp"--%>
<div class="container">
    <form id="biaodan" method="post" class="form-horizontal" role="form">
        <div class="form-group">
            <label for="usernameInput" class="col-sm-2 control-label">名字</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" id="usernameInput" name="username" placeholder="请输入名字">
            </div>
            <div id="usernameTips" class="help-block col-sm-2"></div>
        </div>

        <div class="form-group">
            <label for="disabledTextInput"  class="col-sm-2 control-label">
                禁用输入（Fieldset disabled）         </label>
            <div class="col-sm-10">
                <input type="text" id="disabledInput" class="form-control"
                       placeholder="禁止输入">
            </div>
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
                <button type="submit" class="btn btn-block btn-success">确认</button>
            </div>
        </div>

    </form>
</div>




<form role="form">
    <div class="form-group">
        <div class="col-sm-12">
            <a class="btn btn-block btn-primary" href="${appContext}/jiesuan/tijiaoyinhang">结算</a>
        </div>

        <label class="col-sm-2 control-label">用户      </label>
        <div class="col-sm-10">
            <input class="form-control" id="username" type="text" disabled>
        </div>
    </div>
    <fieldset disabled>
        <div class="form-group">
            <label for="disabledTextInput"  class="col-sm-2 control-label">
                禁用输入（Fieldset disabled）         </label>
            <div class="col-sm-10">
                <input type="text" id="disabledTextInput" class="form-control"
                       placeholder="禁止输入">
            </div>
        </div>
        <div class="form-group">
            <label for="disabledSelect"  class="col-sm-2 control-label">
                禁用选择菜单（Fieldset disabled）         </label>
            <div class="col-sm-10">
                <select id="disabledSelect" class="form-control">
                    <option>禁止选择</option>
                </select>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-block btn-success">确认</button>
            </div>
        </div>
    </fieldset>

</form>



<script src="${appContext}/js/jquery-3.3.1.js"></script>
<script src="${appContext}/js/bootstrap.js"></script>
</body>
</html>
