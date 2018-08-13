package com.demo.service.impl;

import java.util.Date;
import java.util.List;

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
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(Org record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKeyWithBLOBs(Org record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Org record) {
		// TODO Auto-generated method stub
		return 0;
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

	
}
