package com.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.demo.bean.User;
import com.demo.bean.UserInf;

public class PublicController {
	@Autowired
    protected HttpServletRequest request;
	@Autowired
    protected HttpServletRequest reponse;
	@Autowired
	protected HttpSession session;
	
	protected String  getUsername() {
		UserInf userInf = (UserInf)session.getAttribute(UserInf.USERINF);
		return userInf.getUser().getUsername();
	}
	
	protected User  getUser() {
		UserInf userInf = (UserInf)session.getAttribute(UserInf.USERINF);
		return userInf.getUser();
	}
	
	protected UserInf getUserInf() {
		return (UserInf)session.getAttribute(UserInf.USERINF);
	}
    
}
