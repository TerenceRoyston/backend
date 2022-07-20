<%--
  Created by IntelliJ IDEA.
  User: XUBOWEN
  Date: 2022/2/13
  Time: 22:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>


<html>
<head>
    <base href="<%=basePath%>">
    <title>Title</title>
</head>
<body>
    <h3>银行转账登录页面</h3>
    <hr>
    <font color="red" size="15">${requestScope.flag}</font>
    <form action="user?methodName=userLogin" method="post">
        用户名：<input type="text" name="uname" value=""><br>
        密码：<input type="password" name="pwd" value=""><br>
        <input type="submit" value="登录">
    </form>
</body>
</html>
