package com.luv2code.springboot.thymeleafdemo.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	public static String getCurrentDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		return dateFormat.format(date);
	}
		
	public static String dateCarculate(String dateString, int days) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(dateFormat.parse(dateString));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		cal.add(Calendar.DATE, days);
		return dateFormat.format(cal.getTime());
	}
	
	public static String getCurrentDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}
	
	public static String getCurrentDateToROCNumber() {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Date date = new Date();
		String s = dateFormat.format(date);
		
		int ROCYear = Integer.parseInt(dateFormat.format(date).substring(0, 4))-1911;		
		return String.valueOf(ROCYear) + s.substring(4);
	}
}
