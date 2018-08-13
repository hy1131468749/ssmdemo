package com.demo.util;

public class Result {
	
	/**
	 * 1 表示请求成功 0表示失败
	 */
	private int code;
	private String message;
    private Object data;
	
    
    
	public Result() {
	}

	public Result(int code, String message, Object data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getmessage() {
		return message;
	}

	public void setmessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	
	public static Result error() {
		return error(0,null,null);
	}
	public static Result error(Object data) {
		return error(0,null,data);
	}
	
	public static Result error(String message) {
		return error(0,message,null);
	}
	
	public static Result error(String message,Object data) {
		return error(0,message,data);
	}
	
	public static Result error(int code,String message,Object data) {
		Result result = new Result(code,message,data);
		return result;
	}
	
	
	
	public static Result ok() {
		return ok(1,null,null);
	}
	public static Result ok(Object data) {
		return ok(1,null,data);
	}
	
	public static Result ok(String message) {
		return ok(1,message,null);
	}
	
	public static Result ok(String message,Object data) {
		return ok(1,message,data);
	}
	
	public static Result ok(int code,String message,Object data) {
		Result result = new Result(code,message,data);
		return result;
	}
	
}
