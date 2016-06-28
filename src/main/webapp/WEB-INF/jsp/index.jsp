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
<link rel="stylesheet" type="text/css" href="${prc }/css/jquery-ui-1.10.4.custom.css">
<script type="text/javascript" src="${prc }/js/jquery.min.js"></script>
<script type="text/javascript" src="${prc }/js/jquery.easyui.min.js"></script>
<%-- <script type="text/javascript" src="${prc }/js/jquery-ui-1.10.4.custom.js"></script> --%>
<%-- <script type="text/javascript" src="${prc }/js/fenye.js"></script> --%>
<script type="text/javascript" src="${prc }/js/index.js"></script>
<script type="text/javascript">
 function fenye(){
	 $('#tt').tabs('add',{
			title:'分页实例',
			closable:true
		});
	 
	var tt= $('#tt').append('<div><table id="data" style="border: 1px"></table></div>');
	 $('#data').datagrid({
			
			url:'../easyui/listCountry.htm',
			title:'Country',
			fitColumns:true,
			striped:true,
			columns:[[  
			          {field:'id',title:'ID',width:80},    
			          {field:'countryname',title:'国家名称',width:80},    
			          {field:'countrycode',title:'国家代码',width:100},    
			      ]],
			pagePosition:'bottom',
			pagination:true,
			pageNumber:1,
			pageSize:10,
			pageList:[10,20,30,40,50]

		});
 }
</script>
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
			 版本号：0.0.1
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
<!-- 						<li> -->
<!-- 							<div> -->
<%-- 								<a title="${menu.name }" href="#" rel="${prc }/${menu.url}"> --%>
<%-- 									${menu.name } --%>
<!-- 								</a> -->
<!-- 							</div> -->
						
<!-- 						</li> -->
					<ul class="easyui-tree"> 
						<li>
							<span>
								<a href="javascript:addTab('${menu.name }','${prc }${menu.url}')">${menu.name }</a>
							</span>   
						</li> 
					</ul> 
					
					</c:forEach>
					<ul>
						<c:forEach items="${activeUser.menus }" var="menu">
							<li>
								<div>
									<a title="${menu.name }" href="#" rel="${prc }${menu.url}">
										<a href="javascript:addTab('${menu.name}','${prc}${menu.url}')">${menu.name}</a>
									</a>
								</div>
							</li>
						
						</c:forEach>
						<li>
							<div>
								<a  href="#" onclick="javascript:fenye();">分页实例</a>
								<table style="border: 1px"></table>
							</div>
						</li>
						
					</ul>
				</c:if>
			</div>
		</div>
		<div data-options="region:'center',title:'欢迎登陆本系统',iconCls:'icon-ok'">
			<div id="tt" class="easyui-tabs" data-options="fit:true">
<!-- 				<div id="dataDiv"> -->
<!-- 					<table id="data"></table> -->
<!-- 				</div> -->
					<div id="weltab" title="欢迎页" data-options="fit:true,iconCls:'icon-reload'">
						欢迎登陆
					</div>
					
			</div>
			
		</div>
	</div>
	
</body>
</html>
