package com.mybatis.dao;

import java.util.List;

import com.mybatis.domain.SysUserExample;
import com.mybatis.pojo.Sysuser;

public interface SysuserMapper {
    int deleteByPrimaryKey(String id);

    int insert(Sysuser record);

    int insertSelective(Sysuser record);

    Sysuser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Sysuser record);

    int updateByPrimaryKey(Sysuser record);

	List<Sysuser> selectByExample(SysUserExample sysUserExample);

	List<Sysuser> selectAll();

}