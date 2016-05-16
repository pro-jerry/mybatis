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
		
		User user = userSerive.getUser(username.trim(),password.trim());
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
						
						List<Menu> listMenuSunzi = userSerive.getMenuByPid(menu2.getId());
						List<EasyUITree> treeListSunzi = new ArrayList<EasyUITree>();
						if(listMenuSunzi!=null && listMenuSunzi.size()>0){
							
							for(Menu menu3:listMenuSunzi){
								EasyUITree easyUITree3 = new EasyUITree();
								easyUITree3.setId(menu3.getId());
								easyUITree3.setState("close");
								easyUITree3.setText(menu3.getName());
								treeListSunzi.add(easyUITree3);
							}
						}
						easyUITree2.setChildren(treeListSunzi);
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
	
	
	/**
	 * <href http://blog.csdn.net/zwx19921215/article/details/44467099/>
	 * @param request
	 * @return
	 */
	@RequestMapping("getMenu1")
	@ResponseBody
	public Object  getMenu1(HttpServletRequest request){
		
		List<Menu> listMenu = userSerive.getMenuByScort();
		List<EasyUITree> treeList = new ArrayList<EasyUITree>();
		
		if(listMenu!=null && listMenu.size()>0){
			for(Menu menu1:listMenu){
				EasyUITree tree = new EasyUITree();
				EasyUITree treeSunZi = new EasyUITree();
				int length = menu1.getScort().split(",").length;
				if(length-1==1){
					int lastNum = (int)menu1.getScort().charAt(length-1)-(int)'0';
					Menu menu= userSerive.getById(lastNum);
					tree.setId(lastNum);
					tree.setState("open");
					tree.setText(menu.getName());
					
				}
				if(length-1==2){
					EasyUITree treeErZi = new EasyUITree();
					int lastNum = (int)menu1.getScort().charAt(length-1)-(int)'0';
					Menu menu= userSerive.getById(lastNum);
					treeErZi.setId(lastNum);
					treeErZi.setState("open");
					treeErZi.setText(menu.getName());
//					tree.s
//					treeErZi.setParent(parent);
				}
				
				treeList.add(tree);
			}
		}
		
		return JSON.toJSON(treeList); 
	}
	
	
}
