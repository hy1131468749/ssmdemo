package com.demo.srabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.demo.util.RabbitMqUtil;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class CustomerTopic {
    private final static String QUEUE_NAME = "test_topic1";

    public static void start(String[] args) throws IOException, TimeoutException {
        // 创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //设置RabbitMQ地址
        factory.setHost("192.168.11.107");//设置ip地址
        factory.setUsername("root");//设置用户名
        factory.setPassword("root");//设置用户名密码
        factory.setVirtualHost("/");//设置VirtualHost
        factory.setPort(5672);//设置端口号
        //创建一个新的连接
        Connection connection = RabbitMqUtil.getConnnection();
        //创建一个通道
        Channel channel = connection.createChannel();
        //声明要关注的队列
        String exChange = "topictest";
        channel.exchangeDeclare(exChange, "fanout");
        channel.queueDeclare(QUEUE_NAME, false, false, true, null);
        channel.queueBind(QUEUE_NAME, exChange, "");
        System.out.println("Customer Waiting Received messages");
        //DefaultConsumer类实现了Consumer接口，通过传入一个频道，
        // 告诉服务器我们需要那个频道的消息，如果频道中有消息，就会执行回调函数handleDelivery
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body)
                    throws IOException {
            	System.out.println("2线程名称"+Thread.currentThread().getName());
                String message = new String(body, "UTF-8");
                System.out.println("Customer Received '" + message + "'");
              
               // channel.basicAck(envelope.getDeliveryTag(), false);
                //消息
              //  channel.basicReject(envelope.getDeliveryTag(), true);
              // channel.basicNack(deliveryTag, multiple, requeue);
                
            }
        };
        //自动回复队列应答 -- RabbitMQ中的消息确认机制
        channel.basicConsume(QUEUE_NAME, false, consumer);
        System.out.println("已使用");
    }
}