<%--
  Created by IntelliJ IDEA.
  User: XUBOWEN
  Date: 2022/2/27
  Time: 12:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>Title</title>
    <base href="<%=basePath%>">
    <script type="text/javascript" src="js/jquery.js">
    </script>

    <script type="text/javascript">
        $(function () {
            $("#upload").click(
                function () {
                    // 获取上传请求
                    var file=$("#photo")[0].files[0];
                    console.log(file)
                    var formData = new FormData();
                    formData.append("photo",file);
                    // 发请求
                    $.ajax({
                        type:"post",
                        processData:false,
                        contentType:false,
                        url:"uploadMethod",
                        data:formData,
                        success:function (data) {
                            if (data.state){
                                alert("success")
                            }else {
                                alert("fail")
                            }
                        }
                    })
                }
            )
        })
    </script>

</head>
<body bgcolor="#7fffd4">
<h3>欢迎注册</h3>
<hr>
<div>
    <table cellpadding="10px" style="margin: auto">
        <tr>
            <td>用户名</td>
            <td><input type="text" name="uname" value=""></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="pwd" value=""></td>
        </tr>
        <tr>
            <td>性别</td>
            <td><input type="radio" name="sex" value="1">男</td>
            <td><input type="radio" name="sex" value="0">女</td>
        </tr>
        <tr>
            <td>头像</td>
            <td>
                <input type="file" name="photo" id="photo">
                <input type="button" id="upload" value="点击上传">
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="button" value="点击完成">
            </td>
            <td></td>
        </tr>
    </table>
</div>
</body>
</html>
