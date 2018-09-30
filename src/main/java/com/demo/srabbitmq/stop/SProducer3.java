
package com.demo.srabbitmq.stop;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.TimeoutException;

import com.demo.util.JedisUtils;
import com.demo.util.JsonUtil;
import com.demo.util.Message;
import com.demo.util.RabbitMqUtil;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmListener;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.ReturnListener;

/**
 * 消息生成者
 */
public class SProducer3 {
	public final static String QUEUE_NAME = "testretry";

	public static final String rabbitmq = "emgd:channel:";

	public static void start() throws IOException, TimeoutException {
		// 创建连接工厂
		ConnectionFactory factory = new ConnectionFactory();
		// 设置RabbitMQ相关信息
		factory.setHost("192.168.11.107");// 设置ip地址
		factory.setUsername("root");// 设置用户名
		factory.setPassword("root");// 设置用户名密码
		factory.setVirtualHost("/");// 设置VirtualHost
		factory.setPort(5672);// 设置端口号
		// 创建一个新的连接
		Connection connection = RabbitMqUtil.getConnnection();
		// 创建一个通道
		Channel channel = connection.createChannel();
		System.out.println("创建了一个channel");
		// 声明一个队列 channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		String message = "Hello RabbitMQ";
		// 发送消息到队列中
		// channel.txSelect();
		channel.confirmSelect();
		SortedSet<Long> list = new TreeSet<>();
		channel.addConfirmListener(new ConfirmListener() {

			@Override
			public void handleNack(long deliveryTag, boolean multiple) throws IOException {
				System.out.println("handleNack" + "处理了信息" + deliveryTag + multiple);

			}

			@Override
			public void handleAck(long deliveryTag, boolean multiple) throws IOException {
				/*System.out.println("handleAck" + "处理了信息" + deliveryTag + multiple);
				if (multiple) {
					list.headSet(deliveryTag + 1).clear();

				} else {
					list.remove(deliveryTag);
				}*/

			}
		});
		
	    channel.addReturnListener(new ReturnListener() {
			
				@Override
				public  void handleReturn(int replyCode,
			            String replyText,
			            String exchange,
			            String routingKey,
			            AMQP.BasicProperties properties,
			            byte[] body)
						throws IOException {
					String s = new String(body,"utf-8");
					//System.out.print("replyText:"+replyText);
					//System.out.print("properties:"+properties.getMessageId());
					System.out.println(list);
					
				}
			});
	    
		for (int j = 0; ; j++) {
			long log = channel.getNextPublishSeqNo();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//message = rabbitmq + log;
		
			channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));
			
			//Message bean = new Message<String>("message" + j);

			//JedisUtils.set(message, JsonUtil.obj2Sting(bean));
			//System.out.println(log);
			list.add(log);
		}

		// long deliveryTag = channel.getChannelNumber();
		// System.out.println("deliveryTag:"+deliveryTag);
		// System.out.println("Producer Send +'" + message + i + "'");

		

		// channel.close();
		// connection.close() ;
		// System.out.println("1111");
	}
}