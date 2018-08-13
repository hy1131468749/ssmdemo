package com.demo.service.impl;

import java.util.List;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.bean.User;
import com.demo.dao.UserMapper;
import com.demo.service.UserService;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		
		return userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(User record) {
		
		return userMapper.insert(record);
	}

	@Override
	public int insertSelective(User record) {
		getMd5Password(record);
		return userMapper.insertSelective(record);
	}

	@Override
	public User selectByPrimaryKey(Long id) {
		
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public User selectByLoginName(String loginName) {
		
		return userMapper.selectByLoginName(loginName);
	}

	@Override
	public int updateByPrimaryKeySelective(User record) {
		
		return userMapper.updateByPrimaryKey(record);
	}

	@Override
	public int updateByPrimaryKey(User record) {
		
		return userMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<User> selectList() {
		
		return userMapper.selectList();
	}
  
	
	private void getMd5Password(User user) {
		SimpleHash sh = new SimpleHash("md5", user.getPassword(), user.getUsername(), 1);
		user.setPassword(sh.toHex());
	}
	
}
