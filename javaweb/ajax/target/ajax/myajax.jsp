<%--
  Created by IntelliJ IDEA.
  User: XUBOWEN
  Date: 2021/12/19
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>Title</title>
    <script type="text/javascript">
        function getDate() {
            // 创建ajax引擎对象
            var ajax;
            if (window.XMLHttpRequest) {
                ajax = new XMLHttpRequest();
            } else if (window.ActiveXObject) {
                ajax = new ActiveXObject("Msxml2.XMLHTTP");
            }
            // 重写onreadystatement函数
            ajax.onreadystatechange = function () {
                // 判断ajax状态码
                if (ajax.readyState === 4) {
                    if (ajax.status === 200) {
                        // 获取响应内容
                        var result = ajax.responseText;
                        // 获取元素对象
                        let showdiv = document.getElementById("showdiv");
                        showdiv.innerHTML = result;
                    } else if (ajax.status === 404) {
                        let showdiv = document.getElementById("showdiv");
                        showdiv.innerHTML = "请求资源不存在";
                    } else if (ajax.status === 500) {
                        let showdiv = document.getElementById("showdiv");
                        showdiv.innerHTML = "服务器繁忙";
                    }
                }else {
                    var showdiv = document.getElementById("showdiv");
                    // showdiv.innerHTML = "<img src='gif/eg_tulip.jpg' width='200px' height='100px' >";
                    showdiv.innerHTML = "<img src='gif/eg_tulip.jpg' width='200px' height='100px'/>";
                }
            };
            ajax.open("get", "AjaxServlet");
            ajax.send(null);
        }
    </script>

    <style type="text/css">
        #showdiv {
            
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
