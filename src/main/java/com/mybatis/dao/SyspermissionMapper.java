package com.mybatis.dao;

import com.mybatis.pojo.Syspermission;

public interface SyspermissionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Syspermission record);

    int insertSelective(Syspermission record);

    Syspermission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Syspermission record);

    int updateByPrimaryKey(Syspermission record);
}