package com.test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.TimeInfo;
import org.apache.commons.net.ntp.TimeStamp;

/**
 * ����ϵͳʱ��
 * 
 * @author cjia
 *
 * @version ����ʱ�䣺2015��5��8��
 */
public class SystemTimeTest {
	
	public static void main(String[] args) throws IOException {
		
//		Calendar calendar = Calendar.getInstance();
//		calendar.setTimeInMillis(System.currentTimeMillis());
//		
//		System.out.println(calendar.toInstant());
		
		
//		   TimeZone.setDefault(TimeZone.getTimeZone("GMT+8")); // ʱ������  
//	       URL url=new URL("http://www.bjtime.cn");//ȡ����Դ����  
//	       URLConnection uc=url.openConnection();//�������Ӷ���  
//	       uc.connect(); //��������
//	       long ld=uc.getDate(); //ȡ����վ����ʱ�䣨ʱ�����  
//	       System.out.println("ld: "+ ld);
//	       Date date=new Date(ld); //ת��Ϊ��׼ʱ�����  
//	       
//	       System.out.println("system time: " + System.currentTimeMillis());
//	       System.out.println("time: " + date.getTime());
//	       System.out.print(date.toLocaleString());  
	       
		
		 try {  
		        NTPUDPClient timeClient = new NTPUDPClient();  
		        String timeServerUrl = "time-a.nist.gov";  
		        InetAddress timeServerAddress = InetAddress.getByName(timeServerUrl);  
		        TimeInfo timeInfo = timeClient.getTime(timeServerAddress);  
		        TimeStamp timeStamp = timeInfo.getMessage().getTransmitTimeStamp();  
		        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		        
		        System.out.println("system: " + System.currentTimeMillis()/1000);
		        System.out.println("timeStamp: " + timeStamp.getTime()/1000);
		        System.out.println(dateFormat.format(timeStamp.getDate()));  
		    } catch (UnknownHostException e) {  
		        e.printStackTrace();  
		    } catch (IOException e) {  
		        e.printStackTrace();  
		    }  
	}
	
}
