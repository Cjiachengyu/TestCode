package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 从键盘读取数据
 * 
 * @author jiachengyu
 *
 * @date 2014年8月21日
 */
public class ReadFromKeybord {

	public static void main(String[] args) throws IOException {
		
		int num ;
		
		System.out.println("input a number ...");
		Scanner scanner = new Scanner(System.in);
		num = scanner.nextInt();
		System.out.println(num);
		
		System.out.println("input a number ...");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		num = Integer.parseInt(br.readLine());
		System.out.println(num);
	}
}
