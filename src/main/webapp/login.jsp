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
		
		
		$('#sub').click(function(){
			
			
						
		});
		
		
	});
</script>
<title>登录</title>
</head>
<body>
<!-- 		<div>    -->
<!-- 		    <div>    -->
<!-- 		        <label>用户名:</label>    -->
<!-- 		        <input id="username" type="text" name="username"/>    -->
<!-- 		    </div>    -->
<!-- 		    <div>    -->
<!-- 		        <label>密&nbsp;码:</label>    -->
<!-- 		        <input id="pwd" type="password" name="password" />    -->
<!-- 		    </div>   -->
<!-- 		    <div> -->
<!-- 		    	<input type="button" value="注册"/> -->
<!-- 		    	<input id="submit" type="button" value="提交"/> -->
<!-- 		    </div> -->
<!-- 		</div>  -->
<!-- 		<hr/> -->
<!-- 		<br/> -->
		<center align="center">   
		    <form action="${prc}/login/SecondLogin.htm" method="post" >
			<div>   
		        <label>用户名:</label>   
		        <input id="u" type="text" name="username"/>   
		    </div>   
		    <div>   
		        <label>密&nbsp;码:</label>   
		        <input id="p" type="password" name="password" />   
		    </div>  
		    </div> 
		    <div>
		    	<label>验证码:</label>
		    	<input id="yzm" type="text" name="valicode" /> 
		    </div> 
		    <div>
		    	<img  src="${prc}/login/vilicode.htm" width="110" height="20"/>
		    </div>
		    <div>
		    	<input type="button" value="注册"/>
		    	<input id="sub" type="submit" value="提交"/>
		    </div>
		</form>
		</center>
		
		
		
</body>
</html>
