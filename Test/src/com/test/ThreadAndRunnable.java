package com.test;

/**
 * �Ƚ�Thread��Runnable������
 * 
 * @author jiachengyu
 * 
 * @date 2014��8��15��
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
		Thread t1 = new Thread(mt1, "һ�Ŵ���");
		Thread t2 = new Thread(mt2, "���Ŵ���");
		Thread t3 = new Thread(mt3, "���Ŵ���");

		t1.start();
		t2.start();
		t3.start();
	}

	private static void testThread() {
		MyThread mt1 = new MyThread("һ�Ŵ���");
		MyThread mt2 = new MyThread("���Ŵ���");
		MyThread mt3 = new MyThread("���Ŵ���");
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
				System.out.println(this.name + "��Ʊ---->" + (this.ticket--));
			}
		}
	}
}

class MyThread1 implements Runnable {
	private int ticket = 10;

	public void run() {
		for (int i = 0; i < 500; i++) {
			if (this.ticket > 0) {
				System.out.println(Thread.currentThread().getName() + "��Ʊ---->"
						+ (this.ticket--));
			}
		}
	}
}
