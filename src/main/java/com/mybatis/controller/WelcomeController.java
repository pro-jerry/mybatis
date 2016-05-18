package com.mybatis.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/welcome")
public class WelcomeController {

	//欢迎页
	@RequestMapping("/welcome")
	public String toLogin(HttpServletRequest request){
		
		
		return "welcome";
	}
	
	//系统首页
	@RequestMapping("/first.htm")
	public String first(HttpServletRequest request)throws Exception{
			
			
		return "first";
	}
}
