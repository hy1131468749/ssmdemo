package com.demo.dao;

import java.util.List;

import com.demo.bean.Role;

public interface RoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    
    List<Role> selectList();
    
    List<Role> selectListByIds(List<String> ids);
}