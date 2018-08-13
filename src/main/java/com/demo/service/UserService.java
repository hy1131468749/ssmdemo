package com.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.demo.bean.User;

public interface UserService {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);
    
    User selectByLoginName(String loginName);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    List<User> selectList();
}
