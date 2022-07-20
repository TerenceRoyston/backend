<%--
  Created by IntelliJ IDEA.
  User: XUBOWEN
  Date: 2021/11/10
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<%@ page errorPage="error.jsp" %>
<html>
<head>
    <title>Hello JSP</title>
</head>
<body>

<h3>jsp基本语法学习</h3>
<hr>

<%
    // 声明java代码
    String str="hello java";
    int i = 1;
    if (i > 10) {
%>
    <b>jsp学习很简单</b>

<% } else {%>


    <i>jsp很难</i>
    <i><%=str%></i>


<% test();}%>


<!-- 全局代码块 -->
<%!
    int j =10;
    public void test(){
        System.out.println("我是全局代码块！");
    }

%>


<%--jsp静态引入--%>
<%@include file="includeStatic.jsp"%>
<br><b>=============分割线=============</b> <br>
<%--jsp动态引入--%>
<jsp:include page="includeDynamic.jsp"></jsp:include>

<%--jsp转发--%>
<%--<jsp:forward page="forward.jsp"></jsp:forward>--%>
<jsp:forward page="forward.jsp">
    <jsp:param name="str" value="aaa"/>
</jsp:forward>


</body>
</html>
