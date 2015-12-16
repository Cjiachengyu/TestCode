package com.test;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Stack;

/**
 * 给byte赋值时如果超出了（-128~127）会自动转换，如赋128则结果为-128 , 如赋-129则结果为127 ;
 * 
 * 
 * @author jiachengyu
 * 
 * @date 2014年9月11日
 */
public class Test
{
	public static void main(String[] args)
	{
		 FileTest ft = new FileTest();
		 System.out.println(ft.hashCode());
		 ft = null;
		 System.gc();
		 System.out.println("ft == null: " + (ft == null));
	}
	
	
	public static String getMd5(byte[] data)
	{
		MessageDigest md = null;
		try
		{
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		}

		byte[] md5Bytes = md.digest(data);

		BigInteger bigInt = new BigInteger(1, md5Bytes);
		String hashResult = bigInt.toString(16);
		while (hashResult.length() < 32)
		{
			hashResult = "0" + hashResult;
		}

		return hashResult;
	}
}
