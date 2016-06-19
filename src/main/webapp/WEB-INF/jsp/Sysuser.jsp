<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<c:set var="prc"  value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="prc"  value="${pageContext.request.contextPath }"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${prc}/css/bootstrap.min.css">
<script type="text/javascript" src="${prc}/js/jquery.min.js"></script>
<script type="text/javascript" src="${prc}/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12">
				<h3 class="text-center">
					用户列表
				</h3>
			 	<table class="table table-striped">
			 		<thead>
				 		<tr>
				 			<th></th>
				 			<th>登录名</th>
				 			<th>用户名</th>
				 			<th>登录密码</th>
				 			<th>盐值</th>
				 		</tr>
			 		</thead>
			 		<tbody>
				 		<c:forEach items="${SysuserList}" var="sysuser">
				 			<tr class="info">
				 				<td><input class="states" type="checkbox" name="id" value="${sysuser.id }"/></td>
				 				<td>${sysuser.usercode}</td>
				 				<td>${sysuser.username}</td>
				 				<td>${sysuser.password}</td>
				 				<td>${sysuser.salt}</td>
				 			</tr>
				 		</c:forEach>
			 		</tbody>
			 	</table>
			 	<div class="pagination">
					<ul>
						<li>
							<a href="#">上一页</a>
						</li>
						<li>
							<a href="#">1</a>
						</li>
						<li>
							<a href="#">2</a>
						</li>
						<li>
							<a href="#">3</a>
						</li>
						<li>
							<a href="#">4</a>
						</li>
						<li>
							<a href="#">5</a>
						</li>
						<li>
							<a href="#">下一页</a>
						</li>
					</ul>
			</div>
		 	</div>
	 	</div>
	 </div>	
</body>
</html>