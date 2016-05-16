package com.mybatis.service;

import java.util.List;

import com.mybatis.pojo.Menu;
import com.mybatis.pojo.User;

public interface UserService {

	User getUser(String username, String password);

	List<Menu> getAllMenu();

	List<Menu> getMenuByPid(Integer id);

	List<Menu> getMenuByPidIsNull();

	List<Menu> getMenuByScort();

	Menu getById(int lastNum);

	List<Menu> getMenuByUserId(int id);

}
