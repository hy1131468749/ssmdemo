package com.demo.controller;


import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.bean.UserInf;
import com.demo.util.LogInUtil;
import com.demo.util.Result;

@Controller
public class LoginController extends PublicController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	
	/**
	 * 系统登录页 或 系统首页
	 * 
	 * @return
	 */
	@RequestMapping("/index")
	public String index() {
        
		return "/login";
	}
	
	
	@RequestMapping("/testData")
	@ResponseBody
	public String testData(@RequestBody Map<String,Object> list) {
        System.out.println(list);
		return "aa";
	}
	
	
	/**
	 * 用户登录
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping("/userLogin")
	@ResponseBody
	public Result userLogin(@RequestParam String username, @RequestParam String password) {
		logger.info("userLogin: username={},password={}", username, password);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		Result result = null;
		try {
			subject.login(token);
			if (subject.isAuthenticated()) {
				result = Result.ok();
				UserInf userInf = new UserInf();
				LogInUtil.initUserInf(username, userInf);
				session.setAttribute(UserInf.USERINF, userInf);
			}
		}

		catch (UnknownAccountException uae) {
			result = Result.error("当前用户名不存在");

		} catch (IncorrectCredentialsException ice) {
			result = Result.error("当前用户名或密码不正确");

		} catch (LockedAccountException lae) {
			// account for that username is locked - can't login. Show them a
			// message?
			result = Result.error("当前账户被锁定！");
		} catch (AuthenticationException ae) {
			ae.printStackTrace();
			result = Result.error("系统出错，请稍后重试！");
		}

		return result;

	}



}
