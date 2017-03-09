<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Ray
  Date: 2017/3/9
  Time: 10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>成功</title>
</head>
<body>

登录名：${requestScope.user.loginname}
<br>

生日:<fmt:formatDate value="${requestScope.user.birthday}" pattern="yyyy年MM月dd日"/>

</body>
</html>
