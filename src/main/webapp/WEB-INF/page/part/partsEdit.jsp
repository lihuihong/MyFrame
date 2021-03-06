<%--
  Created by IntelliJ IDEA.
  User: 那个谁
  Date: 2018/12/31
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Title</title>

    <%--<script type="text/javascript" src="/resources/layui/layui.all.js" charset="utf-8"></script>--%>
    <link rel="stylesheet" href="/resources/layui/css/layui.css" media="all">
    <style>
        .frameBtn {text-align:center;margin:20px 0px 0px 30px;padding-top:20px;border-top:1px rgb(204,204,204) dashed}
    </style>
</head>
<body>
<form class="layui-form" lay-filter="form" style="padding: 20px 50px 20px 20px">
    <div class="layui-form-item">
        <label class="layui-form-label">设备配件名称</label>
        <div class="layui-input-inline">
            <input type="hidden" name="paetsId">
            <input type="text" name="paetsName" required lay-verify="required" placeholder="请输入设备配件名称" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">所属设备名称</label>
        <div class="layui-input-inline">
            <select name="equName" id="equName" lay-verify="required">
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>
<script src="/resources/layui/layui.js"></script>
<script>
    layui.use(['form','layer','jquery'], function(){
        var form = layui.form;
        var $ = layui.jquery;
        var layer = layui.layer;

        $.ajax({
            url:'/equ/list',
            type:'get',
            dataType:"json",
            success:function(data){
                var html = '';
                if(data.code==0){
                    $.each(data.data,function(index,value){
                        html += '<option value="'+value.equId+'">'+value.equName+'</option>';
                        //alert(html);
                    });
                    //alert(html);
                    $('#equName').html(html);
                    form.render('select');
                } else {
                    layer.alert('抱歉，系统繁忙，请稍后再试！',{icon:2});
                }
            },
        });
        //监听提交
        form.on('submit(submit)',function(data){
            layer.confirm('是否确定提交？',{icon: 3, title:'系统信息'},function(index){
                $.ajax({
                    url:'/parts/Edit',
                    type:'post',
                    data:data.field,
                    closeBtn: 1,
                    dataType:"json",
                    beforeSend:function(){
                        //console.log(JSON.stringify(data.field));
                    },
                    success:function(data){
                        //do something
                        if(data.code==0){
                            window.parent.location.reload();
                            var index = parent.layer.getFrameIndex(window.name);//获取当前窗口索引
                            parent.layer.msg('修改成功', {icon : 1});
                            parent.layer.close(index);
                            parent.layui.table.reload();//重新加载父级tabel数据

                        } else {
                            layer.alert('抱歉，系统繁忙，请稍后再试！',{icon:2});
                        }
                    },
                    error:function(data){
                        //do something
                        layer.msg('与服务器连接失败',{icon: 2});
                    }
                })
                layer.close(index);
            })
            return false;
        })

        //表单初始赋值
        form.val('form', {
            "paetsName":data.paetsName
            ,"equName":data.equName
        });
    })
</script>
<script>


</script>
</body>
</html>
