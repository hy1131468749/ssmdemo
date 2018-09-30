package com.demo.srabbitmq.stop;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Test1 {
	public static void main(String[] args) throws Exception{
		
		 
		new Thread(
				new Runnable() {
					public void run() {
						try {
							SProducer1.start();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (TimeoutException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}).start();

		
	}
}
