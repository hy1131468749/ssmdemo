package com.demo.srabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.demo.util.RabbitMqUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;


/**
 * 消息生成者
 */
public class TestProducerConfirm {
    public final static String QUEUE_NAME="rabbitMQ.test";

    public static void main(String[] args) throws IOException, TimeoutException {
        //创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //设置RabbitMQ相关信息
        factory.setHost("192.168.11.107");//设置ip地址
        factory.setUsername("root");//设置用户名
        factory.setPassword("root");//设置用户名密码
        factory.setVirtualHost("/");//设置VirtualHost
        factory.setPort(5672);//设置端口号
        //创建一个新的连接
        Connection connection = RabbitMqUtil.getConnnection();
        //创建一个通道
        Channel channel = connection.createChannel();
        //  声明一个队列        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        String message = "Hello RabbitMQ";
        //发送消息到队列中
    //    channel.txSelect();
       // channel.confirmSelect()
        try {
         channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));
         System.out.println("Producer Send +'" + message + "'");
        // int a = 1/0;
          channel.txCommit();
        }catch(Exception e) {
        	System.out.println("我回滚了");
        //	channel.txRollback();
        }
       
       
        //关闭通道和连接
        channel.close();
        connection.close() ;
    }
}