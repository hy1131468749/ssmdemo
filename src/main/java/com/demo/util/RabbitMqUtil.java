package com.demo.util;


import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class RabbitMqUtil {

	public static Connection getConnnection() throws IOException, TimeoutException  {
		ConnectionFactory factory = new ConnectionFactory();
		// 设置RabbitMQ地址
		factory.setHost("192.168.11.107");// 设置ip地址
		factory.setUsername("root");// 设置用户名
		factory.setPassword("root");// 设置用户名密码
		factory.setVirtualHost("/");// 设置VirtualHost
		factory.setPort(5672);// 设置端口号
		// 创建一个新的连接
		
		ExecutorService es = new ThreadPoolExecutor(1, 1, 1000, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
		
		Connection connection = factory.newConnection(es);
		return connection;
	}

}
