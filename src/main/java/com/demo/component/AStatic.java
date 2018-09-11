package com.demo.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.service.OrgService;

@Component
public class AStatic {

	
	private static OrgService orgService;

	public void test1() {
		if (orgService != null) {
			System.out.println(orgService);
		}else {
			System.out.println("null");
		}
	}

	public static OrgService getOrgService() {
		return orgService;
	}
	@Autowired
	public  void setOrgService(OrgService orgService) {
		AStatic.orgService = orgService;
	}

}
