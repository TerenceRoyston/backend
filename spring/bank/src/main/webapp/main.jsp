<%--
  Created by IntelliJ IDEA.
  User: XUBOWEN
  Date: 2022/2/13
  Time: 22:43
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
    <script type="text/javascript" src="js/jquery.js"></script>

    <script type="text/javascript">
        $(function () {
            // 校验出账账户
            $("#outPwd").blur(
                function () {
                    var reqData={
                        outId:$("#outId").val(),
                        outPwd:$("#outPwd").val(),
                        methodName:"outMethod"
                    }

                    $.post("account",reqData,function (data) {
                        if (eval(data)){
                            $("#outPwdSpan").html("√").css("color","green").addClass("success").removeClass("error")
                        }else {
                            $("#outPwdSpan").html("×").css("color","red").addClass("error").removeClass("success")
                        }
                    })
                }
            )

            // 校验金额
            $("#money").blur(
                function () {
                    var reqData={
                        outId:$("#outId").val(),
                        outPwd:$("#outPwd").val(),
                        money:$("#money").val(),
                        methodName:"moneyMethod"
                    }

                    $.post("account",reqData,function (data) {
                        if (eval(data)){
                            $("#moneySpan").html("√").css("color","green").addClass("success").removeClass("error")
                        }else {
                            $("#moneySpan").html("×").css("color","red").addClass("error").removeClass("success")
                        }
                    })
                }
            )

            // 校验入账账户
            $("#inName").blur(
                function () {
                    var reqData={
                        inId:$("#inId").val(),
                        inName:$("#inName").val(),
                        methodName:"inMethod"
                    }

                    $.post("account",reqData,function (data) {
                        if (eval(data)){
                            $("#inNameSpan").html("√").css("color","green").addClass("success").removeClass("error")
                        }else {
                            $("#inNameSpan").html("×").css("color","red").addClass("error").removeClass("success")
                        }
                    })
                }
            )

            // 转账
            $("#btn").click(function () {
                // 触发校验

                // 校验结果
                var result =$(".success");
                if (result.length<3){
                    alert("填写正确信息")
                }else {
                    var reqData={
                        inId:$("#inId").val(),
                        outId:$("#outId").val(),
                        money: $("#money").val(),
                        methodName:"transferMethod"
                    }
                    $.post("account",reqData,function (data) {
                        if (eval(data)){
                            alert("成功")
                        }else {
                            alert("失败")
                        }
                    })
                }
            })
        })
    </script>
</head>
<body>
    <h3>银行转账</h3>
    <hr>

        转账账户：<input type="text" name="outId" id="outId" value=""><br>
        转账密码：<input type="password" name="outPwd" id="outPwd" value=""><span id="outPwdSpan"></span><br>
        金额：<input type="text" name="money" id="money" value=""><span id="moneySpan"></span><br>
        入账账户：<input type="text" name="inId" id="inId" value=""><br>
        入账姓名：<input type="text" name="inName" id="inName" value=""><span id="inNameSpan"></span><br>
        <input type="button" id="btn" value="开始转账">

</body>
</html>
