package com.demo.dao;

import com.demo.bean.Student;

public interface StudentMapper {
	 Student selectByPrimaryKey(Integer stuId);
}
