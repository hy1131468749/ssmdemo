package com.demo.util;

import java.io.UnsupportedEncodingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringUtils {

	private static Logger logger = LoggerFactory.getLogger(StringUtils.class);
	
	private static final String CHARSETNAME = "UTF-8";
	
	public static boolean isNotEmpty(String value) {
		return !isEmpty(value);
	}
	
	public static boolean isEmpty(String value) {
		return (value == null || "".equals(value) || "null".equals(value)) ;

	}

	public static String toString(byte[] bytes) {
		if(bytes == null && bytes.length < 1) {
			return null;
		}
		String result;
		try {
			result = new String(bytes,CHARSETNAME);
		} catch (UnsupportedEncodingException e) {
			result = null;
			logger.error("bytes[] convert string : bytes={}",bytes,e);
			
		}
		return result;
		
	}

	public static byte[] getBytes(String object) {
		if(isEmpty(object)) {
			return null;
		}
		byte[] bytes = null;
		try {
			bytes =  object.getBytes(CHARSETNAME);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			bytes = null;
			logger.error("string={}",object,e);
		}
		return bytes;
	}

	
	
}
