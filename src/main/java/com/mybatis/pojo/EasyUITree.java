package com.mybatis.pojo;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class EasyUITree implements Serializable{

	private int id;
	private String text;
	private String state = "open";
	private List<EasyUITree> children;
	private EasyUITree parent;
	private TreeAttributes attributes;
	private boolean checked = false;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public List<EasyUITree> getChildren() {
		return children;
	}
	public void setChildren(List<EasyUITree> children) {
		this.children = children;
	}
	public EasyUITree getParent() {
		return parent;
	}
	public void setParent(EasyUITree parent) {
		this.parent = parent;
	}
	public TreeAttributes getAttributes() {
		return attributes;
	}
	public void setAttributes(TreeAttributes attributes) {
		this.attributes = attributes;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	
	
}
