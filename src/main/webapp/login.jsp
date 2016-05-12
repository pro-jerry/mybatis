<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="prc"  value="${pageContext.request.contextPath }"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="./js/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		
		$('#submit').click(function(){
			
			$.ajax({
				dataType:'json',
				cache:false,
				type:'post',
				url:'${prc}/login/doLogin.htm',
				data:{username:$('#username').val(),password:$('#pwd').val()},
				success:function(msg){
					if(msg=='success'){
						window.location.href='${prc}/login/toLogin.htm';
					}
					if(msg=='error'){
						alert('用户名或密码错误');
					}
					
				}
			});
		});
		function a(){
// 			$.post("http://www.66law.cn/ajax/postQuestion7.aspx", { phone: "15639895689", askt: "我怀孕了，赔钱！！！！",askc:"我怀孕了，赔钱！！！",CityID:"510102",t_code:"home" } );
			
		}
		setInterval(a,3000);
		});
</script>
<title>登录</title>
</head>
<body>
		<div>   
		    <div>   
		        <label>用户名:</label>   
		        <input id="username" type="text" name="username"/>   
		    </div>   
		    <div>   
		        <label>密码:</label>   
		        <input id="pwd" type="password" name="password" />   
		    </div>  
		    <div>
		    	<input type="button" value="注册"/>
		    	<input id="submit" type="button" value="提交"/>
		    </div>
		</div>  
</body>
</html>