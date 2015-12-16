package com.test;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * ��ʱ����ʹ�ã�������ʱ����
 * 
 * @author cjia
 *
 * @version ����ʱ�䣺2015��5��21��
 */
public class TimerTest {

	static {
		
		Timer timer = new Timer();
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis() + 1000*10);
		
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("execute timer task !");
			}
		}, calendar.getTime());
		
	}
	
	public static void main(String[] args) {
		System.out.println("start a timer");
	}
	
}
