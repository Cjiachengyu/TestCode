package com.test;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.InputStreamReader;

import javax.activation.MimetypesFileTypeMap;

/**
 * �ֽ��� �ַ�����ȡtxt�ļ�
 * 
 * �ֽ������������ļ�
 * 
 * @author jiachengyu
 *
 * @date 2014��8��13��
 */
public class FileTest {

	public static void main(String[] args) {

		String subPath = "D:/java/test/newxxx.png";
		
		File file = new File(subPath);
		File destFile = new File("D:/java/test/newxxx2.png");
		System.out.println(destFile.exists());
		file.renameTo(destFile);
		
		System.out.println(destFile.exists());
		
		
//		writeToFile(fileName);
		
//		readFromFile(fileName);
		
//		copyImage(imageName, copyImgName);

	}

	private static void copyImage(String imageName, String copyImgName) {
		try {
			File readFile = new File(imageName);
			File writeFile = new File(copyImgName);
			
			if(!readFile.exists())
			{
				System.out.println("copy·�������ڣ�");
				return ;
			}
			if(writeFile.exists())
			{
				writeFile.createNewFile();
			}
			
			FileInputStream ins = new FileInputStream(readFile);
			FileOutputStream os = new FileOutputStream(writeFile);
			
			byte[] buffer = new byte[1024];
			int length = 0 ;
			while((length = ins.read(buffer)) > 0){
				os.write(buffer, 0, length);
			}
			
			ins.close();
			os.close();
			
			System.out.println("copy success !");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void readFromFile(String fileName) {
		File file = new File(fileName);
		
		try {
			if(!file.exists())
			{
				return ;
			}
			
			FileInputStream in = new FileInputStream(file);
			InputStreamReader re = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(re);
			
		
			//�ֽ�����ȡ
			byte[] buffer = new byte[1024];
			int length = 0 ;
			while((length = in.read(buffer) )>0)
			{
				System.out.println(new String(buffer,"utf-8"));
			}
			System.out.println("-------------");
			/*
			
			//�ַ�����ȡ
			String string;
			while((string = br.readLine()) != null){
				System.out.println(string);
			}
			*/
			br.close();
			re.close();
			in.close();
			System.out.println("ok");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void writeToFile(String fileName) {
		File file = new File(fileName);
		try {
			if (file.exists()) {

				file.createNewFile();
			}
			FileOutputStream os = new FileOutputStream(file,true);
			
			for(int i = 0; i < 10; i++)
			{
				os.write((i+"\n").getBytes());
			}
			
			os.close();

			System.out.println("ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
