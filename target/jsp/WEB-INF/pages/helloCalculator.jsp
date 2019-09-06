<%--
  Created by IntelliJ IDEA.
  User: maart
  Date: 06/09/2019
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator jsp</title>
</head>
<body>
<h1>Hello Calculator</h1>
<form method="POST" action="calculator">
    ${message} <br/>
        Result : ${result} <br/>
    <input type="number" name="number"><br/>
    <input type="submit" name="operation" value="+">
    <input type="submit" name="operation" value="-">
    <input type="submit" name="operation" value="*">
    <input type="submit" name="operation" value="/">
    <input type="submit" name="operation" value="CE">
</form>
</body>
</html>
