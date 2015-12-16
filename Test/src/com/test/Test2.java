package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import sun.tools.jar.resources.jar;

/**
 * 
 * �Ӽ�����ȡ���Ķ��󴫸��������ڷ����жԸö���ĸı�Ӱ�쵽�����е�����,
 * 
 * �����Զ������������¸�ֵ��list = new ArrayList() \\ list = getXXList();����ԭ���ļ��ϲ��ı�
 * 
 * @author jiachengyu
 *
 * @date 2014��8��14��
 */
public class Test2 {

	public static void main(String[] args) {
		
		Set<Integer> set = new HashSet<Integer>();
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(1);
		
		for (Integer integer : set) {
			System.out.println(integer);
		}
		
	}

	private static String getFileSize(long bytesSize) {
		String result = "";

		float kSize = 0;
		float mSize = 0;
		float gSize = 0;
		// to K
		kSize = ((float) bytesSize / 1024);
		kSize = (float) (Math.round(kSize * 10) / 10.0);
		result = kSize + "K";

		if (kSize >= 1024) {
			mSize = kSize / 1024;
			mSize = (float) (Math.round(mSize * 10) / 10.0);
			result = mSize + "M";
		}

		if (mSize > 1024) {
			gSize = kSize / 1024;
			gSize = (float) (Math.round(gSize * 10) / 10.0);
			result = gSize + "G";
		}
		return result;
	}

	public static void changeList1(List<Integer> idList) {
		idList.add(4);
	}

	public static void changeList2(List<Integer> idList) {
		idList = new ArrayList<Integer>();
	}

	public static String getMd5(byte[] data) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		byte[] md5Bytes = md.digest(data);

		BigInteger bigInt = new BigInteger(1, md5Bytes);
		String hashResult = bigInt.toString(16);
		while (hashResult.length() < 32) {
			hashResult = "0" + hashResult;
		}

		return hashResult;
	}

}
