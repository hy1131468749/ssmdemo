package com.demo.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.demo.bean.User;
import com.demo.service.UserService;
import com.demo.util.JsonUtil;
import com.demo.util.PageUtil;
import com.demo.util.Result;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;


@Controller
@RequestMapping("/system/user")
public class UserController extends  PublicController {
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService userService;
	
	@RequiresPermissions("/html/user/userlist.html")
	@RequestMapping("/save")
	@ResponseBody
	public Result save(User user) {
		log.info("create new user. user={}",JsonUtil.jsonObj2Sting(user));
		Result result = null;
		userService.insertSelective(user);
		result = Result.ok();
		return result;
	}
	
	@RequiresPermissions("/html/user/userlist.html")
	@RequestMapping("/findUserList")
	@ResponseBody
	public  PageUtil<User> findUserList(PageUtil<User> pageUtil) throws Exception{
		PageHelper.startPage(pageUtil.getPageNumber(), pageUtil.getPageSize());
		Page<User> page = (Page<User>)userService.selectList();
		pageUtil.setTotal(page.getTotal());
		pageUtil.setRows(page.getResult());
		return pageUtil;
	}
	
}
