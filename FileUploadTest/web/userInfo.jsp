<%--
  Created by IntelliJ IDEA.
  User: Ray
  Date: 2017/3/10
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件下载</title>
</head>
<body>

<h3>文件下载</h3>
<a href="download?filename=${requestScope.user.image.originalFilename}">
    ${requestScope.user.image.originalFilename}
</a>


</body>
</html>
