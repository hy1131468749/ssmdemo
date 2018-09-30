package com.demo.srabbitmq;

public class SThread {
	public static void main(String[] args) {
		new Thread() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true) {
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("222");
					
				}
			}
		}.start();
		System.out.println("1111");
		
		
	}
}
