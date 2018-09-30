package com.demo.component.rabbitmq.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.component.rabbitmq.inf.SendMessage;

@Service
public class ReportInfProducer implements SendMessage{	
	
	 @Autowired
	 private AmqpTemplate amqpTemplate; 
	
	private Logger logger = LoggerFactory.getLogger(ReportInfProducer.class);
	
	@Override
	public void sendDataToQueue(String routingKey, Object message) {
		System.out.println("send:"+message);
		logger.info("ReportInfProducer:queuekey={},message={}",routingKey,message);
		amqpTemplate.convertAndSend(routingKey, message);
		
	}
}
