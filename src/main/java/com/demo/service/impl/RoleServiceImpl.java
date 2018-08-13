package com.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.bean.Role;
import com.demo.dao.RoleMapper;
import com.demo.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleMapper roleMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		
		return 0;
	}

	@Override
	public int insert(Role record) {
		
		return 0;
	}

	@Override
	public int insertSelective(Role record) {
		
		return roleMapper.insert(record);
	}

	@Override
	public Role selectByPrimaryKey(Long id) {
		
		return roleMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Role record) {
		
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Role record) {
		
		return 0;
	}

	@Override
	public List<Role> selectList() {
		
		return roleMapper.selectList();
	}

	@Override
	public List<Role> selectListByIds(List<String> ids) {
		
		return roleMapper.selectListByIds(ids);
	}
	
}
