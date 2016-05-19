<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:set var="prc"  value="${pageContext.request.contextPath }"/>
<link rel="stylesheet" type="text/css" href="${prc }/css/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${prc }/css/themes/icon.css">
<script type="text/javascript" src="${prc }/js/jquery.min.js"></script>
<script type="text/javascript" src="${prc }/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${prc }/js/fenye.js"></script>
<script type="text/javascript" src="${prc }/js/index.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="easyui-layout" data-options="fit:true">
		<div data-options="region:'north'" style="height:50px">
			<span style="padding-right: 20px; float: right;">
				欢迎回来:${activeUser.usercode} &nbsp;&nbsp;
				<a href="#">使用帮助</a>
				<a href="#">修改密码</a>
				<a href="#">退出登录</a>
			</span>
			
		</div>
		<div data-options="region:'south',split:true" style="height:50px;">
			版本号:
		</div>
		<div data-options="region:'east',split:true" title="East" style="width:180px;">
<%-- 			<ul id="east_tree" class="easyui-tree" data-options="url:'${prc}/login/getMenu.htm',method:'get',animate:true,dnd:true,checkbox:true"></ul> --%>
		</div>
		<div data-options="region:'west',split:true" title="导航菜单" style="width:200px;">
			<div class="easyui-accordion" data-options="fit:true,border:false">
<!-- 				<div id="fenye" title="示例" data-options="selected:true" style="padding:10px;"> -->
<!-- 					<ul id="tree"></ul>   -->
<!-- 				</div> -->
				<c:if test="${activeUser.menus!=null }">
					<c:forEach items="${activeUser.menus }" var="menu">
						<div title="${menu.name }"></div>
					</c:forEach>
				</c:if>
<!-- 				<div title="Title1"  style="padding:10px;"> -->
<!-- 					content2 -->
<!-- 				</div> -->
<!-- 				<div title="Title2" style="padding:10px"> -->
<!-- 					content3 -->
<!-- 				</div> -->
			</div>
		</div>
		<div data-options="region:'center',title:'欢迎登陆本系统',iconCls:'icon-ok'">
			<div id="tt">
				<div title="分页显示" style="padding:10px">
					<table id="data"></table>
				</div>
			</div>
			<div id="weltab"></div>
		</div>
	</div>
</body>
</html>