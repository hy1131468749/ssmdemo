package com;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CyclicBarrier;

import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
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
import redis.clients.jedis.ScanResult;

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
    	//AbstractSessionDAO
    	String s =  JedisUtils.get("shda1");
    	System.out.println(s);
    }
    
    @Test 
    public void testGetLock() {
    	JedisUtils.set("g:1", "含");
    }
    
    @Test 
    public void testUnlock() {
    	for(int i=0;i<100;i++) {
    		JedisUtils.set("a:"+i, "a"+i);
    	}
    	for(int i=0;i<100;i++) {
    		JedisUtils.set("b:"+i, "b"+i);
    	}
    	for(int i=0;i<100;i++) {
    		JedisUtils.set("c:"+i, "c"+i);
    	}
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
    
    @Test
    public void testScan() {
    	Map<String,List<String>> scan = JedisUtils.scan("0", "a:*", 50);
    	List<String> keys = scan.get("keys");
    	List<String> values = scan.get("values");
    	for(int i=0;i<keys.size();i++){
    		System.out.println(keys.get(i)+" : "+values.get(i));
    	}
    }
}
