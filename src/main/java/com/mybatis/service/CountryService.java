package com.mybatis.service;

import java.util.List;

import com.mybatis.pojo.Country;

public interface CountryService {

	Country selectCountryById(int i);

	List<Country> selectCountryByPage(int start, Integer number);

	int selectCount();


}
