package com.demo.srabbitmq.stop;

import com.demo.util.RabbitMqUtil;

public class TestSto {
	public static void main(String[] args) throws Exception{
		RabbitMqUtil.getConnnection().close();
	}
}
