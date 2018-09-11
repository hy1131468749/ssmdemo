package com.demo.bean;

import java.io.Serializable;

public class Teacher2 implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public String toString() {
		return "Teacher [name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}
	private String name;
	private String age;
	private String sex;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	
}
