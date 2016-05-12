package com.mybatis.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.mybatis.pojo.EasyUITree;
import com.mybatis.pojo.Menu;
import com.mybatis.pojo.User;
import com.mybatis.service.UserService;


@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private UserService userSerive;
	
	@RequestMapping("/doLogin")
	@ResponseBody
	public String doLogin(HttpServletRequest request){
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		request.getSession().setAttribute("username", username);
		
		User user = userSerive.getUser(username,password);
		if(null == user){
			
			return "error";
		}
		
		return "success";
	}
	
	@RequestMapping("/toLogin")
	public String toLogin(HttpServletRequest request){
		
		
		return "index";
	}
	
	
	@RequestMapping("getMenu")
	@ResponseBody
	public Object getMenu(HttpServletRequest request){
		
		List<Menu> listMenu = userSerive.getMenuByPidIsNull();
		
		List<EasyUITree> treeList = new ArrayList<EasyUITree>();
		
		if(null!=listMenu&&listMenu.size()>0){
			
			for (Menu menu : listMenu) {
				EasyUITree easyUITree = new EasyUITree();
				easyUITree.setId(menu.getId());
				easyUITree.setText(menu.getName());
				List<Menu> listMenuChild = userSerive.getMenuByPid(menu.getId());
				List<EasyUITree> treeListChild = new ArrayList<EasyUITree>();
				if(null!=listMenuChild && listMenuChild.size()>0){
					for (Menu menu2 : listMenuChild) {
						
						EasyUITree easyUITree2 = new EasyUITree();
						easyUITree2.setId(menu2.getId());
						easyUITree2.setState("close");
						easyUITree2.setText(menu2.getName());
						treeListChild.add(easyUITree2);
					}
				}
				easyUITree.setChildren(treeListChild);
				treeList.add(easyUITree);
			}
		}
		
		Object jsonObject = JSON.toJSON(treeList); 
		
		return jsonObject;
	}
	
	
	
	
}
