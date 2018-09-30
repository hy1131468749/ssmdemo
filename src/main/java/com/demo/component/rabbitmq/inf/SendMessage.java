package com.demo.component.rabbitmq.inf;

public interface SendMessage {
	
	
	void sendDataToQueue(String routingKey, Object message);
}
