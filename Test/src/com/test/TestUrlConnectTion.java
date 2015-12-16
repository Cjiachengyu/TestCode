package com.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * ֱ��ͨ����ַץȥ��ҳ����
 * 
 * @author jiachengyu
 *
 * @date 2014��8��8��
 */
public class TestUrlConnectTion {

	public static void main(String[] args) throws IOException {
		
		URL url = new URL("http://www.baidu.com");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setDefaultUseCaches(true);
		connection.setRequestMethod("GET");
		
		InputStream inputStream = connection.getInputStream();
		InputStreamReader inrReader = new InputStreamReader(inputStream);
		BufferedReader bufferedReader = new BufferedReader(inrReader);
		
		StringBuffer sbBuffer = new StringBuffer();
		String string ;
		
		while ((string = bufferedReader.readLine()) != null) {
			sbBuffer.append(new String(string.getBytes(), "UTF-8"));
		}
		System.out.println(sbBuffer.toString());
		
		bufferedReader.close();
		inrReader.close();
		inputStream.close();
		
	}
}
