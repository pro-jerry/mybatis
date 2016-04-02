package com.mybatis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybatis.dao.CountryMapper;
import com.mybatis.pojo.Country;
import com.mybatis.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService{

	@Autowired
	private CountryMapper countryMapper;
	
	public Country selectCountryById(int i) {

		return null;
	}

	public List<Country> selectCountryByPage(int start, Integer number) {

		return countryMapper.selectCountryByPage(start,number);
	}

	public int selectCount() {

		return countryMapper.selectCount();
	}

}
