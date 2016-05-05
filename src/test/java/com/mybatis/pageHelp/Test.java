package com.mybatis.pageHelp;

import org.springframework.beans.factory.annotation.Autowired;

import com.mybatis.dao.CountryMapper;
import com.mybatis.pojo.Country;


public class Test extends BasicTest{

	@Autowired
	private CountryMapper countryMapper;
	
	@org.junit.Test
	public void deleteCountryById(){
		
		
		Country country = new Country();
		country.setCountrycode("DM");
		country.setId(184);
		int b = countryMapper.updateByPrimaryKey(country);
		System.out.println(b);
		
	}
}
