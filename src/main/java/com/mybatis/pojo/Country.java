package com.mybatis.pojo;

public class Country {
    private Integer id;

    private String countryname;

    private String countrycode;

    public Country() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Country(Integer id, String countryname, String countrycode) {
		super();
		this.id = id;
		this.countryname = countryname;
		this.countrycode = countrycode;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountryname() {
        return countryname;
    }

    public void setCountryname(String countryname) {
        this.countryname = countryname == null ? null : countryname.trim();
    }

    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode == null ? null : countrycode.trim();
    }
}