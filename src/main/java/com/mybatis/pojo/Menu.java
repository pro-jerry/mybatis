package com.mybatis.pojo;

public class Menu {
    private Integer id;

    private Integer pid;

    private String name;

    private Integer level;

    private String scort;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getScort() {
        return scort;
    }

    public void setScort(String scort) {
        this.scort = scort == null ? null : scort.trim();
    }
}