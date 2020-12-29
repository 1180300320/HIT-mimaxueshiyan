<%--
  Created by IntelliJ IDEA.
  User: libra
  Date: 2020/12/13
  Time: 9:09
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>购物车</title>
    <link rel="stylesheet" href="${appContext}/css/bootstrap.css" />
</head>
<body>
<div class="form-group">
    <div class="col-sm-12">
<%--        <a class="btn btn-block btn-primary" href="${appContext}/goods/jiesuan?gouwuchexianshi=${gouwuchexianshi}">结算</a>--%>
    <a class="btn btn-block btn-primary" href="${appContext}/goods/jiesuan?uid=${sessionScope.USER_SESSION.uid}">结算</a>
    </div>
</div>
<div class="form-group">
    <div class="col-sm-12">
        <a class="btn btn-block btn-primary" href="${appContext}/goods/shangcheng">跳转回商城继续购买</a>
    </div>
</div>
<table class="table table-bordered table-striped table-hover">
    <thead>
    <tr class="bg-info">
        <th>序号</th>
        <th>商品名</th>
        <th>商品单价</th>
        <th>所属商家</th>
        <th>购买商品数</th>
        <th>操作(删除)</th>
    </tr>
    </thead>
    <tbody>
    <%--    循环遍历输出数据,使用jstl--%>
    <c:forEach items="${gouwuchexianshi}" var="gouwuchexianshi" varStatus="status">
        <tr>
            <th>${status.count}</th>
            <td>${gouwuchexianshi.itemname}</td>
            <td>${gouwuchexianshi.itemprice}</td>
            <td>${gouwuchexianshi.owner}</td>
            <td>${gouwuchexianshi.number}</td>
            <td ><a class="btn btn-danger btn-sm" href="${appContext}/goods/minusnum?uid=${sessionScope.USER_SESSION.uid}&gouwucheid=${gouwuchexianshi.gouwucheid}&num=1">-</a></td>
        </tr>
    </c:forEach>

    </tbody>
</table>

<script src="${appContext}/js/jquery-3.3.1.js"></script>
<script src="${appContext}/js/bootstrap.js"></script>
</body>
</html>
