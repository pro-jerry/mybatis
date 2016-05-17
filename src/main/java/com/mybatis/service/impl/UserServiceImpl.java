package com.mybatis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybatis.dao.MenuMapper;
import com.mybatis.dao.UserMapper;
import com.mybatis.pojo.Menu;
import com.mybatis.pojo.User;
import com.mybatis.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private MenuMapper menuMapper;
	
	@Override
	public User getUser(String username, String password) {

		return userMapper.getUser(username,password);
	}

	@Override
	public List<Menu> getAllMenu() {

		return menuMapper.getAllMenu();
	}

	@Override
	public List<Menu> getMenuByPid(Integer id) {

		return menuMapper.getMenuByPid(id);
	}

	@Override
	public List<Menu> getMenuByPidIsNull() {

		return menuMapper.getMenuByPidIsNull();
	}

	@Override
	public List<Menu> getMenuByScort() {
		
		return menuMapper.getMenuByScort();
	}

	@Override
	public Menu getById(int lastNum) {
		return menuMapper.getMenuById(lastNum);
	}

	@Override
	public List<Menu> getMenuByUserId(int id) {

		return menuMapper.getMenuByUserId(id);
	}

}
