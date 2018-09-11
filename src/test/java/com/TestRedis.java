package com;

import java.util.concurrent.CyclicBarrier;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.demo.bean.Teacher;
import com.demo.dao.StudentMapper;
import com.demo.service.OrgService;
import com.demo.util.JedisUtils;
import com.demo.util.RedisLock;

import redis.clients.jedis.JedisPool;

@RunWith(SpringJUnit4ClassRunner.class) // 使用junit4进行测试
@ContextConfiguration(locations = { "classpath:spring/applicationContext*.xml" }) // 加载配置文件
public class TestRedis {
    
	@Autowired
	private OrgService orgService;

	
    private int i = 0;
    
    @Test
    public void test1() {
    	
    	Teacher t = new Teacher();
		t.setSex("男");
		t.setName("李一");
		t.setAge("18");
		String setObject = JedisUtils.setObject("t:1", t);
		System.out.println(setObject);
    	
    }
    
    @Test
    public void test2() {
    	Teacher t =  JedisUtils.getObject("t:1");
    	System.out.println(t.toString());
    }
    
    @Test 
    public void testGetLock() {
    	RedisLock.tryLock("org:1", Thread.currentThread().getId()+"", 500000);
    }
    
    @Test 
    public void testUnlock() {
    	RedisLock.releaseDistributedLock( "org:1", 1+"");
    }
    
    @Test 
    public void testOrg() {
    	System.out.println(orgService.selectByPrimaryKey(33L));
    }
    
    @Test
    public void testLock() {
    	CyclicBarrier c = new CyclicBarrier(100);
    	
    	for(int i=0;i<100;i++) {
    		new TestLockThread(c,orgService).start();
    	}
    	while(true);
    }
}
