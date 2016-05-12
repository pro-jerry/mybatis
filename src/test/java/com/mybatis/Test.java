package com.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
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
	
	@org.junit.Test
	public void sqlSessionTest() throws IOException{
		
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory  sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			
//			Country country = session.selectOne("com.mybatis.dao.CountryMapper.selectByPrimaryKey",100);
			CountryMapper mapper = session.getMapper(CountryMapper.class);
			Country country = mapper.selectByPrimaryKey(100);
			
			ArrayList<Country> list = new ArrayList<Country>();
			list.add(new Country(184, "A", "A"));
			list.add(new Country(185, "B", "B"));
			list.add(new Country(186, "C", "C"));
			list.add(new Country(187, "D", "D"));
			
			mapper.insertCountry(list);
			
		} finally{
			
			session.close();
		}
	}
}