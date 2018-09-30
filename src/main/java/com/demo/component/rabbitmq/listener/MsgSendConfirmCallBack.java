package com.demo.component.rabbitmq.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ConfirmCallback;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.stereotype.Component;

@Component("msgSendConfirmCallBack")
public class MsgSendConfirmCallBack implements ConfirmCallback {

	
	private Logger logger = LoggerFactory.getLogger(MsgSendConfirmCallBack.class);
	
	@Override
	public void confirm(CorrelationData correlationData, boolean ack, String cause) {
		
		System.out.println("correlationData:"+correlationData+";ack:"+ack+";cause:"+cause);
		logger.debug("correlationData:"+correlationData+";ack:"+ack+";cause:"+cause);
	}

}
