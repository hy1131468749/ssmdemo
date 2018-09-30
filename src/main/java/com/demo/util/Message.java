package com.demo.util;

public class Message<T> {
	
	private int sendCount;
	
	private int handleCount;
	
	private T data;

	
	public Message(T data) {
		super();
		this.sendCount = 1;
		this.handleCount = 1;
		this.data = data;
	}
	
	public Message(int sendCount, int handleCount, T data) {
		super();
		this.sendCount = sendCount;
		this.handleCount = handleCount;
		this.data = data;
	}

	public int getSendCount() {
		return sendCount;
	}

	public void setSendCount(int sendCount) {
		this.sendCount = sendCount;
	}

	public int getHandleCount() {
		return handleCount;
	}

	public void setHandleCount(int handleCount) {
		this.handleCount = handleCount;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	
	
	
}
