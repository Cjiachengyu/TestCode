package com.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;

public class RandomAccessFileTest {

	public static void main(String[] args) throws IOException {
//		writeAndRead();
		RandomAccessFile file = new RandomAccessFile("D:\\java\\file", "rw");  
		  // ������file�ļ���д����  
		  file.writeInt(20);// ռ4���ֽ�  
		  file.writeDouble(8.236598);// ռ8���ֽ�  
		  file.writeUTF("����һ��UTF�ַ���");// �������д�ڵ�ǰ�ļ�ָ���ǰ�����ֽڴ�������readShort()��ȡ  
		  file.writeBoolean(true);// ռ1���ֽ�  
		  file.writeShort(395);// ռ2���ֽ�  
		  file.writeLong(2325451l);// ռ8���ֽ�  
		  file.writeUTF("����һ��UTF�ַ���");  
		  file.writeFloat(35.5f);// ռ4���ֽ�  
		  file.writeChar('a');// ռ2���ֽ�  
		  
		  file.seek(0);// ���ļ�ָ��λ�����õ��ļ���ʼ��  
		  
		  // ���´�file�ļ��ж����ݣ�Ҫע���ļ�ָ���λ��  
		  System.out.println("��������������file�ļ�ָ��λ�ö����ݡ�����������");  
		  System.out.println(file.readInt());  
		  System.out.println(file.readDouble());  
		  System.out.println(file.readUTF());  
		  
		  file.skipBytes(3);// ���ļ�ָ������3���ֽڣ������м�������һ��booleanֵ��shortֵ��  
		  System.out.println(file.readLong());  
		  
		  file.skipBytes(file.readShort()); // �����ļ��С�����һ��UTF�ַ�������ռ�ֽڣ�ע��readShort()�������ƶ��ļ�ָ�룬���Բ��ü�2��  
		  System.out.println(file.readFloat());  
		    
		  //������ʾ�ļ����Ʋ���  
		  System.out.println("�������������ļ����ƣ���file��fileCopy��������������");  
		  file.seek(0);  
		  RandomAccessFile fileCopy=new RandomAccessFile("D:\\java\\fileCopy","rw");  
		  int len=(int)file.length();//ȡ���ļ����ȣ��ֽ�����  
		  byte[] b=new byte[len];  
		  file.readFully(b);  
		  fileCopy.write(b);  
		  System.out.println("������ɣ�");  
		  file.close();
		  
	}

	private static void writeAndRead() throws IOException {
		String filePath = "D:\\java\\randomAccessFile.txt";
		RandomAccessFile rf = new RandomAccessFile(filePath, "rw");
		for (int i = 0; i < 10; i++) {
			// д���������double����
			rf.writeDouble(i * 1.414);
		}
		rf.write("hello".getBytes("UTF-8"));
		rf.close();
		rf = new RandomAccessFile(filePath, "rw");
		// ֱ�ӽ��ļ�ָ���Ƶ���5��double���ݺ���
		rf.seek(5 * 8);
		// ���ǵ�6��double����
		rf.writeDouble(47.0001);
		rf.close();
		rf = new RandomAccessFile(filePath, "r");
		for (int i = 0; i < 10; i++) {
			System.out.println("Value " + i + ": " + rf.readDouble());
		}
		System.out.println(rf.readLine());
		rf.close();
	}
}
