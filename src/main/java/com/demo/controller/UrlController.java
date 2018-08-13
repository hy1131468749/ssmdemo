package com.demo.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.bean.Url;
import com.demo.service.UrlService;
import com.demo.util.PageUtil;
import com.demo.util.Result;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Controller
@RequestMapping("/system/url")
public class UrlController {
private static final Logger log = LoggerFactory.getLogger(OrgController.class);
	
	@Autowired
	private UrlService urlService;
	
	@RequiresPermissions("/html/url/urllist.html")
	@RequestMapping("/save")
	@ResponseBody
	public Result save(Url org) {
		log.info("create new org,org={}", org);
		Result result = null;
		urlService.insertSelective(org);
		result = Result.ok();
		return result;
	}
	
	@RequiresPermissions("/html/url/urllist.html")
	@RequestMapping("/findUrlList")
	@ResponseBody
	public  PageUtil<Url> findUrlList(PageUtil<Url> pageUtil) throws Exception{
		PageHelper.startPage(pageUtil.getPageNumber(), pageUtil.getPageSize());
		Page<Url> page = (Page<Url>)urlService.selectList();
		pageUtil.setTotal(page.getTotal());
		pageUtil.setRows(page.getResult());
		return pageUtil;
	}
	
}
