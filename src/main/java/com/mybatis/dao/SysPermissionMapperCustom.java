package com.mybatis.dao;

import java.util.List;

import com.mybatis.pojo.Syspermission;

public interface SysPermissionMapperCustom {

	//根据用户id查询菜单
	public List<Syspermission> findMenuListByUserId(String userid)throws Exception;
	//根据用户id查询权限url
	public List<Syspermission> findPermissionListByUserId(String userid)throws Exception;
	
	
}
