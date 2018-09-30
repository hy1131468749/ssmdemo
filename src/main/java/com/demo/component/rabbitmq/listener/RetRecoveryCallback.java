package com.demo.component.rabbitmq.listener;

import org.springframework.retry.RecoveryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.stereotype.Component;
@Component("retRecoveryCallback")
public class RetRecoveryCallback implements RecoveryCallback<Object>{

	@Override
	public Object recover(RetryContext context) throws Exception {
		System.out.print("我被触发了"+context.getRetryCount());
		return	null;
	}

}
