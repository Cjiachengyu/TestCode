package com.test;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * PipedInputStream、PipedOutputStream 的连接使用
 * 
 * @author jiachengyu
 *
 * @date 2014年8月15日
 */
public class ReadPipeSteam {

	public static void main(String[] args) {

		PipedInputStream pis = new PipedInputStream();
		PipedOutputStream pos = new PipedOutputStream();
		try {
			pos.connect(pis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Producer pro = new Producer(pos);
		Consumer con = new Consumer(pis);
		pro.run();
		con.run();
	}

}


class Producer implements Runnable {

	PipedOutputStream pos;

	public Producer(PipedOutputStream pos) {
		this.pos = pos;
	}

	public void run() {
		try {
			pos.write("Producer generator .".getBytes());
			pos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

class Consumer implements Runnable {

	PipedInputStream pis;

	public Consumer(PipedInputStream pis) {
		this.pis = pis;
	}

	public void run() {

		try {
			byte[] bytes = new byte[100];
			int length = pis.read(bytes);
			System.out.println(new String(bytes, 0, length));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}