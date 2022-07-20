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
            function ajaxReq() {
                // 获取用户请求数据
                let uname = document.getElementById("uname").value;
                var data="name="+uname;
                // 创建ajax引擎对象
                var ajax;
                if (window.XMLHttpRequest) {
                    ajax = new XMLHttpRequest();
                } else if (window.ActiveXObject) {
                    ajax = new ActiveXObject("Msxml2.XMLHTTP");
                }
                // 重写onreadystatement函数
                ajax.onreadystatechange = function (){
                    if (ajax.readyState === 4) {
                        if (ajax.status === 200) {
                            // 获取响应内容
                            var result = ajax.responseText;
                            // 获取元素对象
                            let showdiv = document.getElementById("showdiv");
                            showdiv.innerHTML = result;
                        }
                    }
                };

                // 发送请求
                // get请求
                // ajax.open("get", "AjaxServlet?"+data);
                // ajax.send(null);

                // post请求
                ajax.open("post", "AjaxServlet");
                ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
                ajax.send("name=jack&pwd=456");
            }
        </script>

        <style type="text/css">
            #showdiv {
                border: solid 1px;
                width: 200px;
                height: 100px;
            }

        </style>
    </head>

    <body>
        <h3>welcome!</h3>
        <hr>
        <input type="text"name="uname" id="uname" value="" />
        <input type="button" value="测试" onclick="ajaxReq()"/>
        <div id="showdiv"></div>
    </body>
</html>
