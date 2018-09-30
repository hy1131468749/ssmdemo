package com.demo.component.rabbitmq;

import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class RetryS {
    @Retryable(ArithmeticException.class)
    public void service(int b) {
        int c = 1/b;
    }
    @Recover
    public void recover(ArithmeticException e) {
       System.out.println("recover");
    }
}