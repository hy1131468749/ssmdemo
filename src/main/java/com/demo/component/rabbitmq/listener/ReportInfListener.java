package com.demo.component.rabbitmq.listener;

import java.io.IOException;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;

import com.demo.bean.Student;
import com.demo.util.JsonUtil;
import com.demo.util.StringUtils;
import com.rabbitmq.client.Channel;



public class ReportInfListener implements ChannelAwareMessageListener{

	@Override
	public void onMessage(Message message,Channel channel) {
		String value = StringUtils.toString(message.getBody());
		System.out.println(value);
		//Student s = JsonUtil.string2Obj(value, Student.class);
		//System.out.println(Thread.currentThread().getName());
		message.getMessageProperties().getDeliveryTag();
		
		try {
			channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
