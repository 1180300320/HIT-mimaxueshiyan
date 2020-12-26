<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: libra
  Date: 2020/12/20
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>商品列表</title>
    <link rel="stylesheet" href="${appContext}/css/bootstrap.css" />
</head>
<body>
<h4>商品列表页</h4>
<table class="table table-bordered table-striped table-hover">
    <thead>
    <tr class="bg-info">
        <th>序号#</th>
        <th>商品id(itemid)</th>
        <th>商品名(itemname)</th>
        <th>商品单价(itemprice)</th>
        <th>所属商家(owner)</th>
        <th>商品数(number)</th>
        <th>操作(减少数量)</th>
        <th>操作(增加数量)</th>
        <th>操作(删除)</th>
    </tr>
    </thead>
    <tbody>
    <%--    循环遍历输出数据,使用jstl--%>
    <c:forEach items="${goods}" var="goods" varStatus="status">
        <tr>
            <th>${status.count}</th>
            <td>${goods.itemid}</td>
            <td>${goods.itemname}</td>
            <td>${goods.itemprice}</td>
            <td>${goods.owner}</td>
            <td>${goods.number}</td>
            <td><a class="btn btn-danger btn-lg" href="${appContext}/admin/minusnum?itemid=${goods.itemid}&num=1">-</a></td>
            <td><a class="btn btn-danger btn-lg" href="${appContext}/admin/addnum?itemid=${goods.itemid}&num=1">+</a></td>
            <td ><a class="btn btn-danger btn-sm" href="${appContext}/admin/deleteItem?itemid=${goods.itemid}">删除</a></td>
        </tr>
    </c:forEach>

    </tbody>
</table>

<script src="${appContext}/js/jquery-3.3.1.js"></script>
<script src="${appContext}/js/bootstrap.js"></script>
</body>
</html>
