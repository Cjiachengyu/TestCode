package com.test;

/**
 * 比较Thread和Runnable的区别
 * 
 * @author jiachengyu
 * 
 * @date 2014年8月15日
 */
public class ThreadAndRunnable {

	public static void main(String[] args) {

		 testThread();

		//testRunnable();
	}

	private static void testRunnable() {
		MyThread1 mt1 = new MyThread1();
		MyThread1 mt2 = new MyThread1();
		MyThread1 mt3 = new MyThread1();
		Thread t1 = new Thread(mt1, "一号窗口");
		Thread t2 = new Thread(mt2, "二号窗口");
		Thread t3 = new Thread(mt3, "三号窗口");

		t1.start();
		t2.start();
		t3.start();
	}

	private static void testThread() {
		MyThread mt1 = new MyThread("一号窗口");
		MyThread mt2 = new MyThread("二号窗口");
		MyThread mt3 = new MyThread("三号窗口");
		mt1.start();
		mt2.start();
		mt3.start();
	}
}

class MyThread extends Thread {

	private int ticket = 10;
	private String name;

	public MyThread(String name) {
		this.name = name;
	}

	public void run() {
		for (int i = 0; i < 500; i++) {
			if (this.ticket > 0) {
				System.out.println(this.name + "卖票---->" + (this.ticket--));
			}
		}
	}
}

class MyThread1 implements Runnable {
	private int ticket = 10;

	public void run() {
		for (int i = 0; i < 500; i++) {
			if (this.ticket > 0) {
				System.out.println(Thread.currentThread().getName() + "卖票---->"
						+ (this.ticket--));
			}
		}
	}
}
