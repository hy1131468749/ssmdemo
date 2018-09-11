package com.demo.util;

import java.util.Collections;

import redis.clients.jedis.Jedis;

public class RedisLock {
	private static final String LOCK_SUCCESS = "OK";
	private static final String UNLOCK_SUCCESS = "OK";

	
	
	//根据需要 获取锁和解锁使用一个redis 还是每一个使用一个 分别关闭连接
	public static boolean tryLock(Jedis jedis ,String key, String requestId, int milliseconds) {
		//jedis = JedisUtils.getResource();
		// nxxx NX|XX, NX -- Only set the key if it does not already exist. XX
		// -- Only set the key if it already exist.

		// expx EX|PX, expire time units: EX = seconds; PX = milliseconds
		// time expire time in the units of {@param #expx}
		boolean value = false;
		

			String result = jedis.set(key, requestId, "NX", "PX", milliseconds);
			if (LOCK_SUCCESS.equals(result)) {
				value = true;
			}

		

		return value;

	}

	public static boolean releaseDistributedLock(Jedis jedis,String lockKey, String requestId) {
		//jedis = JedisUtils.getResource();
		boolean value = false;
		
		String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
		Object result = jedis.eval(script, Collections.singletonList(lockKey), Collections.singletonList(requestId));
		
		if (UNLOCK_SUCCESS.equals(result)) {
			value =  true;
		} 
		
			
		
		return value;
	}
}
