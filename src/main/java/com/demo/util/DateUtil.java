package com.demo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class DateUtil {
	private static ThreadLocal<SimpleDateFormat> simpleDateFormat = new ThreadLocal<SimpleDateFormat>() {
		protected SimpleDateFormat initialValue() {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return sdf;
		};
	};
	
	private static int years = 2016;
	
	private static Random random = new Random();
	
	public static Date getRandomDate() throws ParseException {
		String time = getRandomYear()+"-"+getRandomMonth()+"-"+getRandomDay()+" "+getRandomHour()+":"+getRandomMinute()+":"
				+getRandomSeconds();
		return simpleDateFormat.get().parse(time);
	}
	
	
	
	public static String getRandomYear() {
		return years+random.nextInt(3)+"";
	}

	public static String getRandomMonth() {
		int value = random.nextInt(13);
		if(value < 10) {
			return "0"+value;
		}else {
			return value+"";
		}
	}
	
	
	public static String getRandomDay() {
		int value = random.nextInt(28);
		if(value < 10) {
			return "0"+value;
		}else {
			return value+"";
		}
	}
	
	public static String getRandomHour() {
		int value = random.nextInt(24);
		if(value < 10) {
			return "0"+value;
		}else {
			return value+"";
		}
	}
	
	public static String getRandomMinute() {
		int value = random.nextInt(60);
		if(value < 10) {
			return "0"+value;
		}else {
			return value+"";
		}
	}
	
	
	public static String getRandomSeconds() {
		int value = random.nextInt(60);
		if(value < 10) {
			return "0"+value;
		}else {
			return value+"";
		}
	}
	
	public static void main(String[] args) throws ParseException {
		for(int i=0;i<100000;i++) {
			System.out.println(getRandomDate());
		}
	}
	
}
