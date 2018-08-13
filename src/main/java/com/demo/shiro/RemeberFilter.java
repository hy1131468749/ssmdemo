package com.demo.shiro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.demo.bean.Role;
import com.demo.bean.Url;
import com.demo.bean.User;
import com.demo.bean.UserInf;
import com.demo.service.RoleService;
import com.demo.service.UrlService;
import com.demo.service.UserService;
import com.demo.util.LogInUtil;

public class RemeberFilter extends AccessControlFilter {

	@Autowired
	private UrlService urlService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private UserService userService;

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
			throws Exception {
		boolean result = false;
		Subject subject = SecurityUtils.getSubject();
		// 这个session 就是httpSession 在web容器下 shiro的session 就是httpSession
		Session session = subject.getSession();
		// 如果登录直接返回true
		if (subject.isAuthenticated()) {
			return true;
		}
		// 如果是记住 没有登录 那么需要初始化session中的用户信息
		if (subject.isRemembered() && !subject.isAuthenticated()) {
			result = true;
			UserInf userInf = (UserInf) session.getAttribute(UserInf.USERINF);
			if (userInf == null) {
				String username = (String) subject.getPrincipal();
				User user = userService.selectByLoginName(username);
				if (user != null) {
					LogInUtil.initUserInf(username, userInf);
					session.setAttribute(UserInf.USERINF, userInf);
				}
			}

		}

		return result;
	}

	// 如果被拒绝 那么直接返回到登录页
	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {

		redirectToLogin(request, response);
		return false;
	}

	
    //初始化信息
	
	
}
