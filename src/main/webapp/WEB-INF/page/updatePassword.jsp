<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/12
  Time: 13:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>修改密码</title>
    <link rel="stylesheet" href="/resources/layui/css/layui.css">
    <link rel="stylesheet" href="/resources/frame/css/style.css">

</head>
<body>

<div class="login-main">
    <header class="layui-elip">修改密码</header>
    <form class="layui-form" method="post">
        <div class="layui-input-inline">
            <input type="text" name="oldPassword" required lay-verify="required" placeholder="请输入原密码" autocomplete="off"
                   class="layui-input">
        </div>
        <div class="layui-input-inline">
            <input type="password" id="pwd" name="newPassword1" required lay-verify="required" placeholder="请输入新密码" autocomplete="off"
                   class="layui-input">
        </div>
        <div class="layui-input-inline">
            <input type="password" id="rpwd" name="newPassword2" required lay-verify="required" placeholder="请确认新密码" autocomplete="off"
                   class="layui-input">
        </div>
        <div class="layui-input-inline login-btn">
            <button lay-submit lay-filter="sub" class="layui-btn">提交</button>
        </div>
        <hr/>
        <p><a href="" class="fl"></a><a href="${pageContext.request.contextPath}/web/index.action" class="fr">取消？</a>
        </p>
    </form>
</div>
<script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
<script src="/resources/layui/layui.js"></script>
<script type="text/javascript">
    layui.use(['form', 'jquery', 'layer'], function () {
        var form = layui.form;
        var $ = layui.jquery;
        var layer = layui.layer;
        form.on('submit(sub)', function (data) {
            if ($("#pwd").val() != $("#rpwd").val()) {
                layer.msg("两次密码不一致");
            } else {
                $.ajax({
                    url: '/user/updateNewPassword.json',
                    type: 'post',
                    dataType: 'json',
                    data: data.field,
                    //验证用户名是否可用
                    success: function (data) {
                        if (data.code == "000000") {
                            layer.msg("密码修改成功")
                            setTimeout(function () {
                                window.location.href = "${pageContext.request.contextPath}/web/index.action";
                            },3000);
                        } else {
                            layer.msg(data.message)
                        }

                    }
                })
            }
            return false;
        });
    });

</script>

</body>
</html>
