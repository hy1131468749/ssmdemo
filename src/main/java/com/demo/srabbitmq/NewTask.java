package com.demo.srabbitmq;



import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class NewTask {
    private static final String QUEUE_NAME = "hello";// 消息队列名称

    private static String getMessage(String[] strings) {
        if (strings.length < 1)
            return "Hello World!";
        return joinStrings(strings, " ");
    }

    private static String joinStrings(String[] strings, String delimiter) {
        int length = strings.length;
        if (length == 0)
            return "";
        StringBuilder words = new StringBuilder(strings[0]);
        for (int i = 1; i < length; i++) {
            words.append(delimiter).append(strings[i]);
        }
        return words.toString();
    }

    public static void main(String[] argv) throws java.io.IOException, TimeoutException {

        ConnectionFactory factory = new ConnectionFactory();// 创建RabbitMQ连接工厂
      //设置RabbitMQ相关信息
        factory.setHost("192.168.11.107");//设置ip地址
        factory.setUsername("root");//设置用户名
        factory.setPassword("root");//设置用户名密码
        factory.setVirtualHost("/");//设置VirtualHost
        factory.setPort(5672);//设置端口号
        Connection connection = factory.newConnection();// 创建RabbitMQ连接
        Channel channel = connection.createChannel();// 创建RabbitMQ连接channel

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        String message = getMessage(argv);// 传送的消息
      
        for(int i=0;i<10;i++) {
        	channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        }
        System.out.println(" [x] Sent '" + message + "'");
        while(true);
        // 调用完毕，别忘记关闭channel、connection
        //channel.close();
        //connection.close();
    }
}