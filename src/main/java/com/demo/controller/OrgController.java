package com.demo.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.bean.Org;
import com.demo.exception.ValidateException;
import com.demo.service.OrgService;
import com.demo.util.PageUtil;
import com.demo.util.Result;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Controller
@RequestMapping("/system/org")
public class OrgController extends PublicController{
	private static final Logger log = LoggerFactory.getLogger(OrgController.class);
	
	@Autowired
	private OrgService orgService;
	
	@RequiresPermissions("/html/org/orglist.html")
	@RequestMapping("/save")
	@ResponseBody
	public Result save(Org org) {
		log.info("create new org,org={}", org);
		Result result = null;
		try {
			orgService.insertSelective(org);
			result = Result.ok();
		} catch (ValidateException e) {
			result = Result.error(e.getMessage());
		}
		return result;
	}
	
    @RequiresPermissions("/html/org/orglist.html")
	@RequestMapping("/findorgList")
	@ResponseBody
	public  PageUtil<Org> findorgList(PageUtil<Org> pageUtil) throws Exception{
		PageHelper.startPage(pageUtil.getPageNumber(), pageUtil.getPageSize());
		Page<Org> page = (Page<Org>)orgService.selectList();
		pageUtil.setTotal(page.getTotal());
		pageUtil.setRows(page.getResult());
		return pageUtil;
	}
	

}
