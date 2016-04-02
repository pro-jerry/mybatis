package com.mybatis.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.mybatis.pojo.Country;
import com.mybatis.service.CountryService;

@Controller
@RequestMapping("/easyui")
public class EasyUIController {

	@Autowired
	private CountryService countryService;
	
	@RequestMapping("/show")
	public String showFenYe(HttpServletRequest request){
		
		
		return "index";
	}
	
	@RequestMapping("/listCountry")
	@ResponseBody
	public Object listCountry(HttpServletRequest request){
			
		String pageStr = request.getParameter("page");
		String rowsStr = request.getParameter("rows");
		
		//当前页
		Integer page = Integer.parseInt(pageStr);
		//每页显示的行数
		Integer number = Integer.parseInt(rowsStr);
		//每页的开始记录  第一页为1  第二页为number +1   
        int start = (page-1)*number;  
        List<Country> countryList = countryService.selectCountryByPage(start,number);
        
        
		int count = countryService.selectCount();
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("rows", countryList);
		map.put("total", count);
		
		Object jsonObject = JSON.toJSON(map);
		
		return jsonObject;
	}
}
