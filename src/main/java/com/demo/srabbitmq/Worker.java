package com.demo.srabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class Worker {
	private final static String QUEUE_NAME = "hello";// 队列名称，与发送方保持一致

	private static void doWork(String task) throws InterruptedException {
		for (char ch : task.toCharArray()) {
			if (ch == '.')
				Thread.sleep(1000);
		}
	}

		public static void main(String[] args) throws Exception{
			Worker w1 = new Worker();
			w1.run();
			Worker w2 = new Worker();
			w2.run();
		}
	
	public  void run()
			throws java.io.IOException, java.lang.InterruptedException, TimeoutException {

		ConnectionFactory factory = new ConnectionFactory();
		// 设置RabbitMQ相关信息
		factory.setHost("192.168.11.107");// 设置ip地址
		factory.setUsername("root");// 设置用户名
		factory.setPassword("root");// 设置用户名密码
		factory.setVirtualHost("/");// 设置VirtualHost
		factory.setPort(5672);// 设置端口号
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		channel.basicQos(2);
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
		final Consumer consumer = new DefaultConsumer(channel) {
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
					byte[] body) throws IOException {
				String message = new String(body, "UTF-8");

				try {
					
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				System.out.println(Thread.currentThread().getName()+" : "+" [x] Received '" + message + "'");
				try {
					doWork(message);
					//channel.basicAck(Action.RETRY, multiple);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					System.out.println(" [x] Done");
				}
				
			}
		};
		boolean autoAck = true; // acknowledgment is covered below
		
		channel.basicConsume(QUEUE_NAME, false, consumer);
		System.out.println(Thread.currentThread().getName()+" :main");
		System.out.println(Thread.currentThread().getName()+" :main");
	}
}
