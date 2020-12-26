<%--
  Created by IntelliJ IDEA.
  User: libra
  Date: 2020/12/13
  Time: 9:08
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>电子商城</title>
    <link rel="stylesheet" href="${appContext}/css/bootstrap.css" />
</head>
<body>
<%--<h4>商品列表页</h4>--%>
<h4>        </h4>
<div class="form-group">
    <div class="col-sm-12">
        <a class="btn btn-block btn-primary" href="${appContext}/goods/gouwuche?uid=${sessionScope.USER_SESSION.uid}">去购物车结算</a>
    </div>
</div>
<table class="table table-bordered table-striped table-hover">
    <thead>
    <tr class="bg-info">
        <th>序号#</th>
        <th>商品名</th>
        <th>商品单价</th>
        <th>所属商家</th>
        <th>剩余商品数</th>
        <th>添加到购物车</th>
        <th>点击查看图片</th>
    </tr>
    </thead>
    <tbody>
    <%--    循环遍历输出数据,使用jstl--%>
    <c:forEach items="${goods}" var="goods" varStatus="status">
        <tr>
            <th>${status.count}</th>
            <td>${goods.itemname}</td>
            <td>${goods.itemprice}</td>
            <td>${goods.owner}</td>
            <td>${goods.number}</td>
            <td><a class="btn btn-danger btn-sm" href="${appContext}/goods/addToGouwuche?itemid=${goods.itemid}">添加</a></td>
            <td>${goods.number}</td>
        </tr>
    </c:forEach>

    </tbody>
</table>

<script src="${appContext}/js/jquery-3.3.1.js"></script>
<script src="${appContext}/js/bootstrap.js"></script>
</body>
</html>