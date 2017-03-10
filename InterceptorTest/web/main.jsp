<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Ray
  Date: 2017/3/10
  Time: 18:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图书</title>
</head>
<body>

<h3>欢迎${sessionScope.user.userName}访问</h3>

<br>
<table border="1">
    <tr>
        <th>书名</th>
        <th>作者</th>
        <th>价格</th>
    </tr>

    <c:forEach items="${requestScope.bookList}" var="book">
        <tr>
            <td>${book.name}</td>
            <td>${book.author}</td>
            <td>${book.money}</td>
        </tr>
    </c:forEach>

</table>


</body>
</html>
