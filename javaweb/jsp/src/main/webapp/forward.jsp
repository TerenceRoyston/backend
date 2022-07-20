<%--
  Created by IntelliJ IDEA.
  User: XUBOWEN
  Date: 2021/11/11
  Time: 22:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>

    <body>
        <b>我是转发页面---forward--</b>
        <%
            //获取请求数据
            // 这里要针对idea每一个module导入jar包
            String s=request.getParameter("str");
            System.out.println(s);
            request.getAttribute("str");
        %>
    </body>
</html>
