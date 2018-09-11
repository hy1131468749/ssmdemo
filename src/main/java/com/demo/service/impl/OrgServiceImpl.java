package com.demo.service.impl;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.demo.bean.Org;
import com.demo.dao.OrgMapper;
import com.demo.exception.ValidateException;
import com.demo.service.OrgService;

@Service
public class OrgServiceImpl implements OrgService{

	@Autowired
	private OrgMapper orgMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Org record) {
		
		return 0;
	}

	@Override
	public int insertSelective(Org record) throws ValidateException {
		if(!validate(record)) {
			throw new ValidateException("填写信息出错，信息不全");
		}else {
			return orgMapper.insertSelective(record);
		}
		
	}

	@Override
	public Org selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return orgMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Org record) {
		System.out.println("开始更新");
		int a = orgMapper.updateByPrimaryKeySelective(record);
		System.out.println("更新结果："+a);
		try {
			TimeUnit.SECONDS.sleep(100000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public int updateByPrimaryKeyWithBLOBs(Org record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Org record) {
		int a = orgMapper.updateByPrimaryKey(record);
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
	
	
	@Override
	public List<Org> selectList() {
		
		return orgMapper.selectList();
	}

	
	private boolean validate(Org record) {
		if(record == null) {
			return false;
		}
		if(StringUtils.isEmpty(record.getOrgName())) {
			return false;
		}
		if(record.getCreateTime() == null) {
			record.setCreateTime(new Date());
		}
		if(record.getUpdateTime() == null) {
			record.setUpdateTime(new Date());
		}
		
		return true;
			
	}

	@Override
	public int updateTestByPrimaryKey(Org record) {
		
		return orgMapper.updateTestByPrimaryKey(record);
	}

	
}
