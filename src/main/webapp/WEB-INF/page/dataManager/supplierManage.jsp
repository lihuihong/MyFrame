<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/resources/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="/resources/css/login.css" media="all">
    <title>供应商信息管理</title>
</head>

<body>
    <form class="layui-form">
        <div class="layui-form-item layui-elem-quote">
            <label class="layui-form-label">供应商名称</label>
            <div class="layui-input-inline">
                <input type="text" name="name" id="name" autocomplete="off" placeholder="请输入供应商名称" class="layui-input">
            </div>
            <label class="layui-form-label">负责人</label>
            <div class="layui-input-inline">
                <input type="text" name="principal" id="principal" autocomplete="off" placeholder="请输入负责人" class="layui-input">
            </div>
            <button type="button" class="layui-btn btnSearch" lay-filter="search" lay-submit>查询</button>
            <button type="button" class="layui-btn layui-btn-normal btnAdd">+ 新增供应商</button>
        </div>
    </form>
    <table class="layui-hide" id="tableList" lay-filter="demo"></table>
</body>
<script src="/resources/layui/layui.js" charset="utf-8"></script>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script>
    layui.use('table', function(){
        var table = layui.table;
        var $ = layui.jquery;
        //加载表格
        table.render({
            elem: '#tableList'
            ,url:'/supplier/list'
            ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            ,cols: [[
                {field:'id', title: '编号', align:'center'},
                {field:'supplierNo', title: '供应商编号', align:'center'},
                {field:'name', title: '供应商名称', align:'center'},
                {field:'principal', title: '负责人', align:'center'},
                {field:'area', title: '所在地区', align:'center'},
                {field:'xyd', title: '信誉度', align:'center'},
                {field:'address', title: '地址', align:'center'},
                {field:'phone', title: '电话', align:'center'},
                {field:'email', title: '邮箱', align:'center'},
                {field:'remark', title: '备注', align:'center'},
                {fixed: 'right', width:260, title: '操作', align:'center', toolbar: '#barDemo'}
            ]],
            page: true
        });
        //重载表格
        $('.btnSearch').on('click',function(){
            table.reload('tableList',{
                page: {
                    curr: 1 //重新从第 1 页开始
                },
                where: {
                    'name': $('#name').val(),
                    'principal': $('#principal').val(),
                }
            });
        });
        $('.btnSearch').trigger('click');
        //监听工具条
        table.on('tool(demo)', function(obj){
            var data = obj.data;
            if(obj.event === 'detail'){
                layer.open({
                    title: '查看团队',
                    type: 2,
                    shade: false,
                    area: ['600px', '400px'],
                    maxmin: true,
                    btnAlign: 'c',
                    anim: 0,
                    shade: [0.5, 'rgb(0,0,0)'],
                    content: 'userLook.jsp?id='+data.id,
                    zIndex: layer.zIndex, //重点1
                    success: function(layero){
                        //layer.setTop(layero); //顶置窗口
                    },
                    yes: function(index, layero){
                        //确认按钮
                    }
                });
            } else if(obj.event === 'del'){
                layer.confirm('服务标题：'+data.fTitle, {icon: 3, title:'是否确定删除?'}, function(index){
                    $.ajax({
                        url:'/admin/content/delete',
                        type:'post',
                        data:{'id':data.id},
                        dataType:"json",
                        beforeSend:function(){//console.log(JSON.stringify(data.field));
                        },
                        success:function(data){//do something
                            if(data.code==0){
                                layer.msg('恭喜，删除成功！',{icon:1});
                            } else {
                                layer.alert('抱歉，系统繁忙，请稍后再试！',{icon:2});
                            }
                        },
                        error:function(data){//do something
                            layer.msg('与服务器连接失败',{icon: 2});
                        }
                    });
                    layer.close(index);
                    layui.table.reload('tableList');
                });
            } else if(obj.event === 'edit'){
                layer.open({
                    title: '编辑信息',
                    type: 2,
                    shade: false,
                    area: ['800px', '450px'],
                    maxmin: true,
                    btnAlign: 'c',
                    anim: 0,
                    shade: [0.5, 'rgb(0,0,0)'],
                    content: '/page//dataManager/supplierEdit',
                    zIndex: layer.zIndex, //重点1
                    success: function(layero,index){
                        // 获取子页面的iframe
                        var iframe = window['layui-layer-iframe' + index];
                        // 向子页面的全局函数child传参
                        iframe.child(data);
                    },
                    yes: function(index, layero){
                        //确认按钮
                    }
                });
            }
        });
        //新增账号
        $('.btnAdd').on('click',function(){
            layer.open({
                title: '新增服务',
                type: 2,
                shade: false,
                area: ['800px', '450px'],
                maxmin: true,
                btnAlign: 'c',
                anim: 0,
                shade: [0.5, 'rgb(0,0,0)'],
                content: '/page/dataManager/supplierAdd.jsp',
                zIndex: layer.zIndex, //重点1
                success: function(layero){
                    //layer.setTop(layero); //顶置窗口
                },
                yes: function(index, layero){
                    //确认按钮
                }
            });
        });
    });
</script>
</body>
</html>