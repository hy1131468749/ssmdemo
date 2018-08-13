package com.demo.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.util.StringUtils;

import com.demo.bean.Role;
import com.demo.bean.Url;
import com.demo.bean.User;
import com.demo.bean.UserInf;
import com.demo.component.SpringContextUtil;
import com.demo.service.RoleService;
import com.demo.service.UrlService;
import com.demo.service.UserService;

public class LogInUtil {
	
	private static UserService userService = SpringContextUtil.getBean(UserService.class);
	
	private static RoleService roleService = SpringContextUtil.getBean(RoleService.class);
	
	private static UrlService urlService = SpringContextUtil.getBean(UrlService.class);
	
	public static void initUserInf(String username, UserInf userInf) {
		User user = userService.selectByLoginName(username);
		if (user == null) {
			return;
		}
		userInf.setUser(user);
		Role role = roleService.selectByPrimaryKey(user.getRoleId());
		if (role == null) {
			return;
		}
		String urls = role.getUrls();
		if (StringUtils.isEmpty(urls)) {
			return;
		}
		List<String> urlIds = Arrays.asList(urls.split(","));
		List<Url> urlList = urlService.selectListByIds(urlIds);
		if (urlList == null || urlList.isEmpty()) {
			return;
		}
		List<String> permissions = new ArrayList<>();
		for (Url url : urlList) {
			permissions.add(url.getUrlAddress());
		}
		userInf.setPermissions(permissions);
	}
}
