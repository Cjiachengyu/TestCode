package com.test;

import java.text.DateFormat;
import java.util.Date;

/**
 * DateFormate ��ʹ��
 * @author jiachengyu
 *
 * @date 2014��8��5��
 */
public class DateFormateTest {

	public static void main(String[] args) {
		Date d = new Date();  
        String s;  
  
        /** Date��ĸ�ʽ: Sat Apr 16 13:17:29 CST 2006 */  
        System.out.println(d);  
  
        System.out.println("******************************************");  
  
        /** getDateInstance() */  
        /** �����ʽ: 2006-4-16 */  
        s = DateFormat.getDateInstance().format(d);  
        System.out.println(s);  
  
        /** �����ʽ: 2006-4-16 */  
        s = DateFormat.getDateInstance(DateFormat.DEFAULT).format(d);  
        System.out.println(s);  
  
        /** �����ʽ: 2006��4��16�� ������ */  
        s = DateFormat.getDateInstance(DateFormat.FULL).format(d);  
        System.out.println(s);  
  
        /** �����ʽ: 2006-4-16 */  
        s = DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);  
        System.out.println(s);  
  
        /** �����ʽ: 06-4-16 */  
        s = DateFormat.getDateInstance(DateFormat.SHORT).format(d);  
        System.out.println(s);  
  
        /** �����ʽ: 2006-01-01 00:00:00 */  
        java.text.DateFormat format1 = new java.text.SimpleDateFormat(  
                "yyyy-MM-dd hh:mm:ss");  
        s = format1.format(new Date());  
        System.out.println(s);  
  
        /** �����ʽ: 2006-01-01 01:00:00 */  
        System.out.println((new java.text.SimpleDateFormat(  
                "yyyy-MM-dd hh:mm:ss")).format(new Date()));  
  
        /** �����ʽ: 2006-01-01 13:00:00 */  
        System.out.println((new java.text.SimpleDateFormat(  
                "yyyy-MM-dd HH:mm:ss")).format(new Date()));  
  
        /** �����ʽ: 20060101000000 ***/  
        java.text.DateFormat format2 = new java.text.SimpleDateFormat(  
                "yyyyMMddhhmmss");  
        s = format2.format(new Date());  
        System.out.println(s);  
	}
}
