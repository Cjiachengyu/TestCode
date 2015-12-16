package com.test;

import java.util.ArrayList;
import java.util.List;

public class RmObjFromListTest {
	
	public static void main(String[] args) {
		
		List<Student> list = new ArrayList<Student>();
		
		list.add(new Student(11,"stu1"));
		list.add(new Student(12,"stu2"));
		list.add(new Student(13,"stu3"));
		
		for(Student stu : list)
//		for(int i=0; i < list.size(); i++)
		{
//			Student stu = list.get(i);
			if (stu.getAge() == 12)
			{
				list.remove(stu);
			}
		}
		
		
		for(Student stu : list)
		{
			System.out.println(stu.toString());
		}
	}
}

class Student{
	
	private int age;
	private String name;
	
	public Student()
	{
		setAge(10);
		setName("student");
	}
	
	public Student(int age, String name)
	{
		setAge(age);
		setName(name);
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
		
	public String toString()
	{
		return this.age + "-" + this.name;
	}
}