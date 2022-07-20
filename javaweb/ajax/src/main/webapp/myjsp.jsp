<%--
  Created by IntelliJ IDEA.
  User: XUBOWEN
  Date: 2021/12/19
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        function getDate() {
            let showdiv = document.getElementById("showdiv");
            showdiv.innerHTML="Hello ajax";
        }
    </script>

    <style type="text/css">
        #showdiv{
            border: solid 1px;
            width: 200px;
            height: 100px;
        }

    </style>
</head>
<body>
    <h3>welcome!</h3>
    <hr>
    <input type="button" value="测试" onclick="getDate()"/>
    <div id="showdiv"></div>
</body>
</html>
