package com.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.bean.Url;
import com.demo.dao.UrlMapper;
import com.demo.service.UrlService;

@Service
public class UrlServiceImpl implements UrlService{

	@Autowired
	private UrlMapper urlMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return urlMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Url record) {
		// TODO Auto-generated method stub
		return urlMapper.insert(record);
	}

	@Override
	public int insertSelective(Url record) {
		// TODO Auto-generated method stub
		return urlMapper.insertSelective(record);
	}

	@Override
	public Url selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return urlMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Url record) {
		// TODO Auto-generated method stub
		return urlMapper.updateByPrimaryKey(record);
	}

	@Override
	public int updateByPrimaryKey(Url record) {
		// TODO Auto-generated method stub
		return urlMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Url> selectList() {
		// TODO Auto-generated method stub
		return urlMapper.selectList();
	}

	@Override
	public List<Url> selectListByIds(List<String> ids) {
		// TODO Auto-generated method stub
		return urlMapper.selectListByIds(ids);
	}
    
}