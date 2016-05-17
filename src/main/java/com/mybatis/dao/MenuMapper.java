package com.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mybatis.pojo.Menu;

public interface MenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

	List<Menu> getAllMenu();

	List<Menu> getMenuByPid(@Param("pid") Integer id);

	List<Menu> getMenuByPidIsNull();

	List<Menu> getMenuByScort();

	Menu getMenuById(int id);

	List<Menu> getMenuByUserId(int userId);
}