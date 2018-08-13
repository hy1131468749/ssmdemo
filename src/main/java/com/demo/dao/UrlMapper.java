package com.demo.dao;

import java.util.List;

import com.demo.bean.Url;

public interface UrlMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Url record);

    int insertSelective(Url record);

    Url selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Url record);

    int updateByPrimaryKey(Url record);
    
    List<Url> selectList();
    
    List<Url> selectListByIds(List<String> ids);
}