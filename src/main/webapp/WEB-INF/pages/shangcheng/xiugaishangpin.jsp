<%--
  Created by IntelliJ IDEA.
  User: libra
  Date: 2020/12/26
  Time: 18:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>修改商品属性</title>
    <link rel="stylesheet" href="${appContext}/css/bootstrap.css" />
</head>
<body>
<div class="container">
    <form method="post" action="${appContext}/goods/xiugaishangpinshuxing?itemid=${goods.itemid}" class="form-horizontal" role="form">
        <div class="form-group">
            <label for="itemnameInput" class="col-sm-2 control-label">商品名</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" id="itemnameInput" name="itemname" placeholder="${goods.itemname}">
            </div>
<%--            <div id="itemnameTips" class="help-block col-sm-2"></div>--%>
        </div>
        <div class="form-group">
            <label for="itempriceInput" class="col-sm-2 control-label">商品单价</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" id="itempriceInput" name="itemprice" placeholder="${goods.itemprice}">
            </div>
<%--            <div id="usernameTips" class="help-block col-sm-2"></div>--%>
        </div>
        <div class="form-group">
            <label for="goodsnunber" class="col-sm-2 control-label">库存数量</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" id="goodsnunber" name="nunber" placeholder="${goods.number}">
            </div>
            <div class="help-block col-sm-2"></div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-block btn-primary">确认修改</button>
            </div>
        </div>
    </form>
</div>

<script src="${appContext}/js/jquery-3.3.1.js"></script>
<script src="${appContext}/js/bootstrap.js"></script>


</body>
</html>

