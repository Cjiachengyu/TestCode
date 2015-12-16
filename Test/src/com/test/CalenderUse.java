package com.test;

import java.util.Calendar;

public class CalenderUse {

	public static void main(String[] args) {
	
		Calendar calendar = Calendar.getInstance();

		calendar.set(Calendar.DAY_OF_WEEK, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		System.out.println(calendar.getTimeInMillis()/1000);
		System.out.println(System.currentTimeMillis());
		System.out.println(calendar.getTime().toGMTString());
	}
}
