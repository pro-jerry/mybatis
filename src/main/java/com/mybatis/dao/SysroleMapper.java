package com.mybatis.dao;

import com.mybatis.pojo.Sysrole;

public interface SysroleMapper {
    int deleteByPrimaryKey(String id);

    int insert(Sysrole record);

    int insertSelective(Sysrole record);

    Sysrole selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Sysrole record);

    int updateByPrimaryKey(Sysrole record);
}