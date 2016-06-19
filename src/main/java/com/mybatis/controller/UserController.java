package com.mybatis.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mybatis.pojo.Sysuser;
import com.mybatis.service.SysuserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private SysuserService sysuserService;
	
	@RequestMapping("/query")
	public String query(HttpServletRequest request){
		
		List<Sysuser> list = sysuserService.query();
		request.setAttribute("SysuserList", list);
		return "Sysuser";
	}
}
