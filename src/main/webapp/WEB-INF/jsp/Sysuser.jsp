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
				 		<c:forEach items="${page.list}" var="sysuser">
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
						<c:if test="${page.hasPreviousPage}">
							<li>
								<a href="${pageContext.request.contextPath}/user/query.htm?pageNum=${page.prePage}&pageSize=${page.pageSize}">上一页</a>
							</li>
						</c:if>
						<c:forEach items="${page.navigatepageNums}" var="nav">
							<c:if test="${nav == page.pageNum}">
								<li >
									<a href="#">${nav}</a>
								</li>
							</c:if>
							<c:if test="${nav != page.pageNum}">
								<li >
									<a href="${pageContext.request.contextPath}/user/query.htm?pageNum=${nav}&pageSize=${page.pageSize}">${nav}</a>
								</li>
							</c:if>
						</c:forEach>
						<c:if test="${page.hasNextPage}">
							<li>
								<a href="${pageContext.request.contextPath}/user/query.htm?pageNum=${page.nextPage}&pageSize=${page.pageSize}">下一页</a>
							</li>
						</c:if>
					</ul>
			</div>
		 	</div>
	 	</div>
	 </div>	
</body>
</html>