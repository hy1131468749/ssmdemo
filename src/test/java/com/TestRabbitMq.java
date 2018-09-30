package com;

import java.util.Date;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.demo.bean.Student;
import com.demo.component.rabbitmq.impl.ReportInfProducer;

@RunWith(SpringJUnit4ClassRunner.class) // 使用junit4进行测试
@ContextConfiguration(locations = { "classpath:spring/applicationContext*.xml" }) // 加载配置文件
public class TestRabbitMq {

	@Autowired
	RabbitTemplate amqpTemplate;

	private String routingKey = "queue_emgd_deviceinf_key";

	@Test
	public void testSendMessage() {
		
	        for(int i=0;;i++) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        	CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
			Object message = "2312";
			System.out.println(i);
			amqpTemplate.convertAndSend(routingKey, message, correlationData);
		
	        }
		
	}

}
