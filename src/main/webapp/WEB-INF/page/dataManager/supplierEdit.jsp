<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/resource/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="/resource/css/login.css" media="all">
    <title>供应商信息管理</title>

	<script type="text/javascript">

        var url;
        function searchSupplier(){
            $("#dg").datagrid('load',{
                "principal":$("#s_principal").val(),
                "name":$("#s_name").val(),
                "xyd":$("#s_xyd").combobox("getValue"),
            });
        }

        function addSupplier(){
            $("#dlg").dialog("open").dialog("setTitle","添加供应商信息");
            url="${pageContext.request.contextPath}/supplier/save.do";
        }

        function supplierModify(){
            var selectedRows=$("#dg").datagrid("getSelections");
            if(selectedRows.length!=1){
                $.messager.alert("系统提示","请选择一条要编辑的数据！");
                return;
            }
            var row=selectedRows[0];
            $("#dlg").dialog("open").dialog("setTitle","编辑供应商信息");
            $("#fm").form("load",row);
            url="${pageContext.request.contextPath}/supplier/save.do?id="+row.id;
        }

        function saveSupplier(){
            $("#fm").form("submit",{
                url:url,
                onSubmit:function(){

                    return $(this).form("validate");
                },
                success:function(result){
                    var result=eval('('+result+')');
                    if(result.success){
                        $.messager.alert("系统提示","保存成功!");
                        resetValue();
                        $("#dlg").dialog("close");
                        $("#dg").datagrid("reload");
                    }else{
                        $.messager.alert("系统提示","保存失败！");
                        return;
                    }
                }
            });
        }

        function resetValue(){
            $("#name").val("");
            $("#principal").val("");
            $("#area").val("");
            $("#xyd").combobox("setValue","");
            $("#address").val("");
            $("#phone").val("");
            $("#email").val("");
            $("#remark").val("");
        }

        function closeSupplierDialog(){
            $("#dlg").dialog("close");
            resetValue();
        }

        function deleteSupplier(){
            var selectedRows=$("#dg").datagrid("getSelections");
            if(selectedRows.length==0){
                $.messager.alert("系统提示","请选择要删除的数据！");
                return;
            }
            var strIds=[];
            for(var i=0;i<selectedRows.length;i++){
                strIds.push(selectedRows[i].id);
            }
            var ids=strIds.join(",");
            $.messager.confirm("系统提示","您确定要删除这<font color=red>"+selectedRows.length+"</font>条数据吗？",function(r){
                if(r){
                    $.post("${pageContext.request.contextPath}/supplier/delete.do",{ids:ids},function(result){
                        //alert(result.success);
                        if(result.success){
                            $.messager.alert("系统提示","数据已成功删除！");
                            $("#dg").datagrid("reload");
                        }else{
                            $.messager.alert("系统提示","数据删除失败！");
                        }
                    },"json");
                }
            });
        }

	</script>
</head>

<body>
    <form class="layui-form" lay-filter="form" style="padding: 20px 50px 20px 20px">
        <div class="layui-form-item">
            <input type="hidden">
            <label class="layui-form-label">供应商名称</label>
            <div class="layui-input-block">
                <input type="text" name="name" required  lay-verify="required" placeholder="请输入供应商名称" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">负责人</label>
            <div class="layui-input-inline">
                <input type="text" name="principal" required lay-verify="required" placeholder="请输入负责人" autocomplete="off" class="layui-input">
            </div>
            <label class="layui-form-label">信誉度</label>
            <div class="layui-input-inline">
                <select name="xyd" lay-verify="required">
                    <option value=""></option>
                    <option value="☆">☆</option>
                    <option value="☆☆">☆☆</option>
                    <option value="☆☆☆">☆☆☆</option>
                    <option value="☆☆☆☆">☆☆☆☆</option>
                    <option value="☆☆☆☆☆">☆☆☆☆☆</option>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">所在地区</label>
            <div class="layui-input-inline">
                <input type="text" name="area" required lay-verify="required" placeholder="请输入地区" autocomplete="off" class="layui-input">
            </div>
            <label class="layui-form-label">地   址</label>
            <div class="layui-input-inline">
                <input type="text" name="address" required  lay-verify="required" placeholder="请输入供应商名称" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">电   话</label>
            <div class="layui-input-inline">
                <input type="text" name="phone" required  lay-verify="required" placeholder="请输入电话" autocomplete="off" class="layui-input">
            </div>
            <label class="layui-form-label">邮   箱</label>
            <div class="layui-input-inline">
                <input type="text" name="email" required  lay-verify="required" placeholder="请输入邮箱" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">备   注</label>
            <div class="layui-input-block">
                <input type="text" name="remark" required  lay-verify="required" placeholder="请输入备注" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</body>
<script src="/resource/layui/layui.js" charset="utf-8"></script>
<script>

    var data;
    function child(d) {
        data = d;
        //alert(data);
    }

    layui.use('form', function() {
        var form = layui.form;
        var $ = layui.jquery;

        //表单初始赋值
        form.val('form', {
            "name": data.name
            ,"principal": data.principal
            ,"area": data.area
            ,"xyd": data.xyd
            ,"address": data.address
            ,"phone": data.phone
            ,"email": data.email
            ,"remark": data.remark
        })

        //监听提交
        form.on('submit(formDemo)', function(data){

            layer.confirm('是否确定新增？',{icon: 3, title:'系统信息'},function(index){
                $.ajax({
                    url:'/supplier/save',
                    type:'post',
                    data:data.field,
                    dataType:"json",
                    beforeSend:function(){
                        //console.log(JSON.stringify(data.field));
                    },
                    success:function(data){
                        //do something
                        if(data.code==0){
                            var index = parent.layer.getFrameIndex(window.name);//获取当前窗口索引
                            parent.layer.msg('添加成功', {icon : 1});
                            parent.layer.close(index);
                            parent.layui.table.reload('tableList');//重新加载父级tabel数据
                        } else {
                            layer.alert('抱歉，系统繁忙，请稍后再试！',{icon:2});
                        }
                    },
                    error:function(data){
                        //do something
                        layer.msg('与服务器连接失败',{icon: 2});
                    }
                });
                layer.close(index);
            });
            return false;
        });

    });

</script>
	
</body>
</html>