<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: libra
  Date: 2020/12/17
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>用户列表</title>
</head>
<body>
    <h4>用户列表页</h4>
    <table border="1">
        <thead>
        <tr>
            <th>序号#</th>
            <th>用户id(uid)</th>
            <th>用户名(username)</th>
            <th>密码(password)</th>
            <th>用户类型(usertype)</th>
            <th>操作(修改)</th>
            <th>操作(删除)</th>
        </tr>
        </thead>
        <tbody>
        <%--    循环遍历输出数据,使用jstl--%>
        <c:forEach items="${users}" var="user" varStatus="status">
            <tr>
                <th>${status.count}</th>
                <td>${user.uid}</td>
                <td>${user.username}</td>
                <td>${user.password}</td>
                <td>${user.usertype}</td>
                <td>修改</td>
                <td><a href="${appContext}/admin/delete?uid=${user.uid}">删除</a></td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</body>
</html>
