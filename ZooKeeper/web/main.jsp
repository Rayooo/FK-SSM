<%@ page import="org.fkit.domain.Book" %>
<%@ page import="org.springframework.web.context.request.RequestScope" %>
<%@ page import="java.util.List" %><%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--
  Created by IntelliJ IDEA.
  User: Ray
  Date: 2017/3/19
  Time: 13:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>

<h3>欢迎${sessionScope.user.username}</h3>

<table border="1">
    <tr>
        <th>封面</th>
        <th>书名</th>
        <th>作者</th>
        <th>价格</th>
    </tr>

    <%--<c:forEach items="${requestScope.bookList}" var="book">--%>

    <%
        for(Book book : (List<Book>)request.getAttribute("bookList")){
            %>
            <tr>
                <td><img src="images/<%=book.getImage()%>"></td>
                <td><%=book.getName()%></td>
                <td><%=book.getAuthor()%></td>
                <td><%=book.getPrice()%></td>
            </tr>

    <%
        }
    %>
    <%--</c:forEach>--%>

</table>


</body>
</html>
