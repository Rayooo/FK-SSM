<%--
  Created by IntelliJ IDEA.
  User: Ray
  Date: 2017/3/9
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试表单数据格式化</title>
</head>
<body>
<h3>测试表单数据格式化</h3>

<form action="test" method="post">
    <table>
        <tr>
            <td><label>日期类型</label></td>
            <td><input type="text" id="birthday" name="birthday"></td>
        </tr>
        <tr>
            <td><label>整数类型</label></td>
            <td><input type="text" id="total" name="total"></td>
        </tr>
        <tr>
            <td><label>百分数类型</label></td>
            <td><input type="text" id="discount" name="discount"></td>
        </tr>
        <tr>
            <td><label>货币类型</label></td>
            <td><input type="text" id="money" name="money"></td>
        </tr>
        <tr>
            <td><input id="submit" type="submit" value="提交"></td>
        </tr>

    </table>
</form>


</body>
</html>
