package com.mybatis.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mybatis.pojo.Sysuser;
import com.mybatis.service.SysuserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private SysuserService sysuserService;
	
	@RequestMapping("/query")
	public String query(HttpServletRequest request,
			@RequestParam(required = false, defaultValue = "1") int pageNum,
			@RequestParam(required = false, defaultValue = "10") int pageSize){
		PageHelper.startPage(pageNum, pageSize);
		List<Sysuser> list = sysuserService.query();
		PageInfo pageInfo = new PageInfo(list);
		request.setAttribute("page", pageInfo);
		return "Sysuser";
	}
}
