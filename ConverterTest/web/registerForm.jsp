<%--
  Created by IntelliJ IDEA.
  User: Ray
  Date: 2017/3/9
  Time: 10:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
</head>
<body>

<h3>注册页面</h3>
<form action="register" method="post">
    <table>
        <tr>
            <td><label>登陆名</label></td>
            <td><input type="text" id="loginname" name="loginname"></td>
        </tr>

        <tr>
            <td><label>生日:</label></td>
            <td><input type="text" id="birthday" name="birthday"></td>
        </tr>
        <tr>
            <td><input id="submit" type="submit" value="登陆"></td>
        </tr>
    </table>


</form>



</body>
</html>
