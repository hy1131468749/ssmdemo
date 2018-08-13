package com.demo.service;

import java.util.List;

import com.demo.bean.Url;

public interface UrlService {
    int deleteByPrimaryKey(Long id);

    int insert(Url record);

    int insertSelective(Url record);

    Url selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Url record);

    int updateByPrimaryKey(Url record);
    
    List<Url> selectList();
    
    List<Url> selectListByIds(List<String> ids);
}