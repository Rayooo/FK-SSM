<%--
  Created by IntelliJ IDEA.
  User: Ray
  Date: 2017/3/19
  Time: 12:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>
</head>
<body>

<h3>登陆</h3>

<form action="login" method="post">
    <span style="color: red; ">${requestScope.message}</span>
    <table>
        <tr>
            <td><label>登陆名：</label></td>
            <td><input type="text" id="loginname" name="loginname"></td>
        </tr>
        <tr>
            <td><label>密码:</label></td>
            <td><input type="password" id="password" name="password"></td>
        </tr>
        <tr>
            <td><input type="submit" value="登陆"></td>
        </tr>
    </table>


</form>


</body>
</html>
