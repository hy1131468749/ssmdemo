package com;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.demo.bean.Student;
import com.demo.dao.StudentMapper;

@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试
@ContextConfiguration(locations={"classpath:spring/applicationContext-dao.xml"}) //加载配置文件 
public class TestDao {
   
	@Autowired
	private StudentMapper studentMapper;
	@Test
	public void test1(){
		Student selectByPrimaryKey = studentMapper.selectByPrimaryKey(1);
		System.out.print(selectByPrimaryKey.getStu_id());
		
	}
	
}
