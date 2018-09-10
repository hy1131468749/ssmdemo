package com;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import redis.clients.jedis.JedisPool;

@RunWith(SpringJUnit4ClassRunner.class) // 使用junit4进行测试
@ContextConfiguration(locations = { "classpath:spring/applicationContext*.xml" }) // 加载配置文件
public class TestRedis {
    @Autowired
	private JedisPool jedisPool;
   
    @Test
    public void test1() {
    	/*String string = jedisPool.getResource().get("aa");
    	System.out.println("aa");
    	System.out.println("中");*/
    }

}
