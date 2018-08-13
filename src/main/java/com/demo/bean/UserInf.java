package com.demo.bean;

import java.io.Serializable;
import java.util.List;

public class UserInf implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String USERINF = "USERINF";
	
	private User user;
	private List<Url> roles;
	private List<String> permissions;
	public List<String> getPermissions() {
		return permissions;
	}
	public void setPermissions(List<String> permissions) {
		this.permissions = permissions;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Url> getRoles() {
		return roles;
	}
	public void setRoles(List<Url> roles) {
		this.roles = roles;
	}
	

}
