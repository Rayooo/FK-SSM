<%--
  Created by IntelliJ IDEA.
  User: Ray
  Date: 2017/3/5
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<%--可以使用Contrller传递出来的User模型--%>
<h3>欢迎${requestScope.user.username}</h3>
</body>
</html>
