package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;

/**
 * 根据md5值判断两个文件是否完全相同
 * 
 * @author jiachengyu
 *
 * @date 2014年11月7日
 */
public class getFileMd5
{
	 public static String getMd5ByFile(File file) {
	        String value = null;
	        FileInputStream in = null;
	    try {
	        in = new FileInputStream(file);
	        MappedByteBuffer byteBuffer = in.getChannel().map(FileChannel.MapMode.READ_ONLY, 0, file.length());
	        MessageDigest md5 = MessageDigest.getInstance("MD5");
	        md5.update(byteBuffer);
	        BigInteger bi = new BigInteger(1, md5.digest());
	        value = bi.toString(16);
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	            if(null != in) {
	                try {
	                in.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	    return value;
	    }
	 
	    public static void main(String[] args) {
	        String v = getFileMd5.getMd5ByFile(new File("E:\\temp\\question_1415323913635.jpg"));
	        String v2 = getFileMd5.getMd5ByFile(new File("E:\\temp\\question_1415324005735.jpg"));
	        System.out.println(v.toUpperCase());
	        System.out.println(v2.toUpperCase());
	        System.out.println(v.equals(v2));
	    }
}
