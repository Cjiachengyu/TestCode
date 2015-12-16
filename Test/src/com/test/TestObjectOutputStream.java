package com.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * ��ʵ�����л��Ķ��������ķ�ʽд���ļ���
 * 
 * Ȼ���ٴӸ��ļ��ж�ȡ����ԭ����
 * 
 * @author jiachengyu
 *
 * @date 2014��8��14��
 */
public class TestObjectOutputStream {

	public static void main(String[] args) throws IOException {
		File file = new File("C:"+File.separator+"java"+File.separator+"object.temp");
		
//		writeObject(file);
		
//		readObject(file);
		
	}

	private static void readObject(File file) {
		try {
			if(!file.exists())
			{
				System.out.println("�ļ�·�������ڣ�");
				return ;
			}
			
			FileInputStream fi = new FileInputStream(file);
			ObjectInputStream obi = new ObjectInputStream(fi);
			
			User user = (User) obi.readObject();
			User user2 = (User) obi.readObject();
			
			obi.close();
			fi.close();
			
			System.out.println(user.getName());
			System.out.println(user.getAge());
			
			System.out.println(user2.getName());
			System.out.println(user2.getAge());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void writeObject(File file) {
		try{
			
			if(file.exists())
			{
				file.createNewFile();
			}
			FileOutputStream fo = new FileOutputStream(file);
			ObjectOutputStream ob = new ObjectOutputStream(fo);
			
			User user = new User(2,"����");
			User user2 = new User(3,"hello");
			
			ob.writeObject(user);
			ob.writeObject(user2);
			
			ob.flush();
			ob.close();
			fo.close();
			System.out.println("ok");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class User implements Serializable{
	
	private static final long serialVersionUID = -644279355685624924L;
	
	
	int age;
	String name;
	
	public static int pul = 10;
	
	public User()
	{
	  this.age = 0;
	  this.name = "hiky";
	}
	
	public User(int age ,String name )
	{
		this.age = age ;
		this.name = name ;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
