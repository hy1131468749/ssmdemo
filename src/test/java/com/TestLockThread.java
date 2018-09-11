package com;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

import com.demo.bean.Org;
import com.demo.service.OrgService;
import com.demo.util.JedisUtils;
import com.demo.util.RedisLock;

import redis.clients.jedis.Jedis;

public class TestLockThread extends Thread {

	private OrgService orgService;

	public CyclicBarrier cyclicBarrier;

	public TestLockThread(CyclicBarrier cyclicBarrier, OrgService orgService) {
		super();
		this.cyclicBarrier = cyclicBarrier;
		this.orgService = orgService;
	}

	@Override
	public void run() {

		try {
			cyclicBarrier.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String id = Thread.currentThread().getId() + "";
		Jedis jedis = JedisUtils.getResource();
		while (true) {

			if (RedisLock.tryLock(jedis, "org:33", id + "", 200000)) {
				try {
					Org org = orgService.selectByPrimaryKey(33L);
					if (org.getParentId() <= 0) {
						System.out.println("已经没票 ，购买失败");
						return;
					}
					org.setParentId(org.getParentId() - 1);
					int result = orgService.updateTestByPrimaryKey(org);
					if (result > 0) {
						System.out.println(id + "买票成功：" + org.getParentId());
					} else {
						System.out.println("强票失败：");
					}
				} finally {
					RedisLock.releaseDistributedLock(jedis, "org:33", id);
					JedisUtils.colse(jedis);

				}
				break;
			}

		}

	}

}
