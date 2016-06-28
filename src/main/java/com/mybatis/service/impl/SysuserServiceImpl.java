package com.mybatis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybatis.dao.SysuserMapper;
import com.mybatis.pojo.Sysuser;
import com.mybatis.service.SysuserService;

@Service
public class SysuserServiceImpl implements SysuserService{

	@Autowired
	private SysuserMapper sysuserMapper;
	
	@Override
	public List<Sysuser> query() {

		return sysuserMapper.selectAll();
	}

}
