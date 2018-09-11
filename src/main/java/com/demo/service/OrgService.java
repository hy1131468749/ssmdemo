package com.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.demo.bean.Org;
import com.demo.exception.ValidateException;

public interface OrgService {
	int deleteByPrimaryKey(Long id);

	int insert(Org record);

	int insertSelective(Org record) throws ValidateException;

	Org selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(Org record);

	int updateByPrimaryKeyWithBLOBs(Org record);

	int updateByPrimaryKey(Org record);
    
	List<Org> selectList();
	
	int updateTestByPrimaryKey(Org record);

}
