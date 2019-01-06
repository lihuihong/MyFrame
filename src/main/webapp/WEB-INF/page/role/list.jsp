<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>华源世纪ERP管理系统</title>
<link rel="shortcut icon" href="/yx/img/fav.png" />
<link rel="stylesheet" href="/yx/css/font.css">
<link rel="stylesheet" href="/yx/css/xadmin.css">
<script type="text/javascript" src="/yx/js/jquery.min.js"></script>
<script src="/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="/yx/js/xadmin.js"></script>
</head>
<body>
	<form class="layui-form" style="padding-top: 20px;">
		<div class="layui-form-item layui-inline">
			<label class="layui-form-label">角色名称</label>
			<div class="layui-input-block">
				<input type="text" name="name" placeholder="请输入角色名称" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item layui-inline">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit lay-filter="searchBtn">检索</button>
				<button type="reset" class="layui-btn layui-btn-primary">清空</button>
			</div>
		</div>
	</form>
	<div class="layui-elem-quote" style="padding: 6px 20px;">
		<button class="layui-btn layui-btn-normal" onclick="myPage(0,'添加角色')">
			<i class="layui-icon">&#xe654;</i>新增
		</button>
	</div>
	<table class="layui-table" lay-data="{url:'/erp/role/page', page:true, id:'myDataTable', method:'post', height:'full-160'}"
		lay-filter="tableFilter">
		<thead>
			<tr>
				<th lay-data="{field:'id',type:'checkbox'}">ID</th>
				<th lay-data="{field:'name'}">角色名称</th>
				<th lay-data="{field:'createTime'}">录入时间</th>
				<th lay-data="{toolbar: '#oprationDiv'}">操作</th>
			</tr>
		</thead>
	</table>
	<div id="oprationDiv" style="display: none;">
		<a class="layui-btn layui-btn-warm layui-btn-sm" lay-event="updatePage">修改</a>
		<a class="layui-btn layui-btn-danger layui-btn-sm" lay-event="del">删除</a>
	</div>
	<script type="text/javascript">
		var delUrl = '/erp/role/del', queryUrl = '/erp/role/query', updateUrl = "/erp/role/update", addUrl = "/erp/role/add", updateTitle = '编辑信息-', delTitle = '确定要删除行么?';
		var pageArea = [ '600px', '600px' ];
	</script>
	<script type="text/javascript" src="/yx/bus/common.js"></script>
</body>
</html>