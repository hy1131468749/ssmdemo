package com.demo.dao;

import com.demo.bean.Testdata;

public interface TestdataMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Testdata record);

    int insertSelective(Testdata record);

    Testdata selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Testdata record);

    int updateByPrimaryKey(Testdata record);
}