package com.mybatis.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.alibaba.fastjson.JSON;
import com.mybatis.domain.ActiveUser;
import com.mybatis.exception.CustomException;
import com.mybatis.pojo.EasyUITree;
import com.mybatis.pojo.Menu;
import com.mybatis.pojo.User;
import com.mybatis.service.SysService;
import com.mybatis.service.UserService;


@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private UserService userSerive;
	
	@Autowired
	private SysService sysService;
	
	@RequestMapping("/doLogin")
	@ResponseBody
	public String doLogin(HttpServletRequest request,HttpSession session){
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		session.setAttribute("username", username);
		
		User user = userSerive.getUser(username.trim(),password.trim());
		
		session.setAttribute("userId", user.getId());
		if(null == user){
			
			return "error";
		}
		
		return "success";
	}
	
	@RequestMapping("/toLogin")
	public String toLogin(HttpServletRequest request){
		
		
		return "index";
	}
	
	
	@RequestMapping("/getMenu")
	@ResponseBody
	public Object getMenu(HttpServletRequest request){
		
		List<Menu> listMenu = userSerive.getMenuByUserId((int)request.getSession().getAttribute("userId"));
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
	
	@RequestMapping("/SecondLogin")
	public String  login2(HttpServletRequest request,HttpSession session) throws Exception{
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String valicode = request.getParameter("valicode");
		
		//校验验证码，防止恶性攻击
		//从session获取正确验证码
		String validateCode = (String) session.getAttribute("validateCode");
				
		//输入的验证和session中的验证进行对比 
		if(!valicode.equals(validateCode)){
			//抛出异常
			throw new CustomException("验证码输入错误");
		}
		
		
		ActiveUser activeUser = sysService.authenticat(username,password);
		session.setAttribute("activeUser", activeUser);
		
		
		return "forward:/login/toLogin.htm";
	}
	
	
	@RequestMapping("/vilicode")
	public String validatecode(){
		
		return "vilicode";
	}
}
