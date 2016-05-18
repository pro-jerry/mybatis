package com.mybatis.domain;

import java.io.Serializable;
import java.util.List;

import com.mybatis.pojo.Syspermission;

/**
 * 用户身份信息，存入session 由于jetty将session会序列化在本地硬盘上，所以使用Serializable接口
 * @author Administrator
 *
 */
public class ActiveUser implements Serializable{

	private String userid;//用户id（主键）
	private String usercode;// 用户账号
	private String username;// 用户名称

	private List<Syspermission> menus;// 菜单
	private List<Syspermission> permissions;// 权限
	
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsercode() {
		return usercode;
	}
	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public List<Syspermission> getMenus() {
		return menus;
	}
	public void setMenus(List<Syspermission> menus) {
		this.menus = menus;
	}
	public List<Syspermission> getPermissions() {
		return permissions;
	}
	public void setPermissions(List<Syspermission> permissions) {
		this.permissions = permissions;
	}
	
	
	
}
