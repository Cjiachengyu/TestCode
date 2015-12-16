package com.test;

import java.io.IOException;

public class RunTimeTest {
	
	public static void main(String[] args) {
		
		try {
			Runtime.getRuntime().exec("c:\\Users\\czhang\\diskmgmt");
			System.out.println("exec ok !");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
