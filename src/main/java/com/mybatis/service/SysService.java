package com.mybatis.service;

import com.mybatis.domain.ActiveUser;

public interface SysService {

	/**
	 * 根据用户的身份和密码 进行认证，如果认证通过，返回用户身份信息
	 * @param username
	 * @param password
	 * @return
	 */
	ActiveUser authenticat(String username, String password) throws Exception;

	
}
