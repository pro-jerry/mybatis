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
		System.out.println(jsonObject);
//		Object jsonObject = JSON.parse("["+text+"]");
		
		/*
		List<EasyUITree> list = new ArrayList<EasyUITree>();
		
		EasyUITree children111 = new EasyUITree();
		children111.setId(111);
		children111.setText("Friend");
		EasyUITree children112 = new EasyUITree();
		children112.setId(112);
		children112.setText("Wife");
		EasyUITree children113 = new EasyUITree();
		children113.setId(113);
		children113.setText("Company");
		List<EasyUITree> list11 = new ArrayList<EasyUITree>();
		list11.add(children111);
		list11.add(children112);
		list11.add(children113);
		
		EasyUITree children11 = new EasyUITree();
		children11.setId(11);
		children11.setText("Photos");
		children11.setState("close");
		children11.setChildren(list11);
		list.add(children11);
		
		
		EasyUITree children12 = new EasyUITree();
		children12.setId(12);
		children12.setText("Program Files");
		children12.setState("close");
		list.add(children12);
		
		easyUITree.setId(1);
		easyUITree.setText("My Documents");
		easyUITree.setState("open");
		easyUITree.setChildren(list);
		
		String text = JSON.toJSONString(easyUITree); 
		Object jsonObject = JSON.parse("["+text+"]");
		System.out.println(jsonObject);
		*/
		
		
		return jsonObject;
	}
	
}
