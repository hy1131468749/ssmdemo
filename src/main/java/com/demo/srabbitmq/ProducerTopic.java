package com.demo.srabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;


/**
 * 消息生成者
 */
public class ProducerTopic {
  

    public static void main(String[] args) throws IOException, TimeoutException {
        //创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //设置RabbitMQ相关信息
        factory.setHost("192.168.11.107");//设置ip地址
        factory.setUsername("glodio");//设置用户名
        factory.setPassword("glodio");//设置用户名密码
        factory.setVirtualHost("/EMGD");//设置VirtualHost
        factory.setPort(5672);//设置端口号
        //创建一个新的连接
        Connection connection = factory.newConnection();
        //创建一个通道
        Channel channel = connection.createChannel();
        //  声明一个队列        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        String message = "Hello RabbitMQ";
        //发送消息到队列中
        String exChange = "data_sys";
        channel.exchangeDeclare(exChange, "fanout",true);
        
        for(int i=0;i<1000;i++) {
        	channel.basicPublish(exChange,"", null, message.getBytes("UTF-8"));
        	System.out.println("Producer Send +'" + message + "'");
        }
        //关闭通道和连接
        channel.close();
        connection.close();
    }
}