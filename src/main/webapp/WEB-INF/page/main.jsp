<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/4
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>工厂设备管理系统</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/resources/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="/resources/css/main.css" media="all">
</head>
<body>
<div class="layui-layout">
    <!-- 头部区域 -->
    <div class="layui-header">
        <ul class="box">
            <li class="header-left">
                <a href="javascript:;" class="btnHeader flexible" title="侧边伸缩">
                    <i class="layui-icon layui-icon-shrink-right"></i>
                </a>
                <a href="javascript:;" class="btnHeader refresh" title="刷新">
                    <i class="layui-icon layui-icon-refresh-3"></i>
                </a>
            </li>
            <li class="header-right">
				<span class="navHeader">
					<div class="layui-nav">
						<div class="layui-nav-item">
							<a href="javascript:;">
								<cite>${sessionScope.userInfo.userName}</cite>
							</a>
							<dl class="layui-nav-child">
								<dd><a id="personalPassword" lay-href="/web/password.action">修改密码</a></dd>
							</dl>
						</div>
					</div>
				</span>
                <a href="javascript:;" class="btnHeader logout">安全退出</a>
            </li>
        </ul>
    </div>
    <!-- 侧边菜单 -->
    <div class="layui-side">
        <div class="layui-side-scroll">
            <div class="layui-logo" lay-href="html/index.html">
                <img src="/images/logo.png" style="width:40px;margin:10px" />
                <span>工厂设备管理系统</span>
            </div>
            <ul class="layui-nav layui-nav-tree" lay-filter="nav">
                <li data-name="home" class="layui-nav-item layui-this">
                    <a href="javascript:;" lay-href="/admin/page/home/index" class="nav-tab" lay-id="home" data-type="tabChange" lay-tips="控制台">
                        <i class="layui-icon layui-icon-theme"></i><label>控制台</label>
                    </a>
                </li>
                <li data-name="template" class="layui-nav-item">
                    <a href="javascript:;" lay-tips="系统管理">
                        <i class="layui-icon layui-icon-util"></i><label>系统管理</label>
                    </a>
                    <dl class="layui-nav-child">
                        <dd>
                            <a lay-href="/web/page/user/userManage" class="nav-tab" lay-id="1" data-type="tabAdd">
                                <i class="layui-icon"></i><label>用户管理</label>
                            </a>
                        </dd>
                        <dd>
                            <a lay-href="/web/page/equ/equList" class="nav-tab" lay-id="2" data-type="tabAdd">
                                <i class="layui-icon"></i><label>设备管理</label>
                            </a>
                        </dd>
                        <dd>
                            <a lay-href="/web/page/part/partsList" class="nav-tab" lay-id="3" data-type="tabAdd">
                                <i class="layui-icon"></i><label>设备配件管理</label>
                            </a>
                        </dd>
                        <dd>
                            <a lay-href="/web/page/repair/repairList" class="nav-tab" lay-id="4" data-type="tabAdd">
                                <i class="layui-icon"></i><label>维修管理</label>
                            </a>
                        </dd>
                    </dl>
                </li>
                <li data-name="template" class="layui-nav-item">
                    <a href="javascript:;" lay-tips="权限管理">
                        <i class="layui-icon layui-icon-util"></i><label>权限管理</label>
                    </a>
                    <dl class="layui-nav-child">
                        <dd>
                            <a lay-href="/web/page/user/roleManage" class="nav-tab" lay-id="5" data-type="tabAdd">
                                <i class="layui-icon"></i><label>用户权限管理</label>
                            </a>
                        </dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>
    <!-- 主体内容 -->
    <div class="layui-bodier">
        <div class="layui-tab" lay-filter="tab" lay-allowClose="true">
            <ul class="layui-tab-title">
                <li class="firstTab layui-this" lay-id="home">控制台</li>
            </ul>
            <div class="layui-tab-content">
                <div class="layui-tab-item layui-show">
                    <iframe src="/page/home/index" frameborder="0" name="tabFrame" class="tabFrame"></iframe>
                </div>
            </div>
        </div>
    </div>
    <!-- 版权信息 -->
    <div class="layui-footer">
        <span>工厂设备管理系统  Copyright © 工厂设备管理系统</span>
    </div>
</div>
</body>
<script src="/resources/layui/layui.js" charset="utf-8"></script>
<script src="/resources/js/main.js" charset="utf-8"></script>
</html>
