package com.demo.dao;

import java.util.List;

import com.demo.bean.Org;

public interface OrgMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Org record);

    int insertSelective(Org record);

    Org selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Org record);

    int updateByPrimaryKeyWithBLOBs(Org record);

    int updateByPrimaryKey(Org record);
    
    List<Org> selectList();
}