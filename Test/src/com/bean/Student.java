package com.bean;

public class Student {

	private int studentId;
	private int age;
	private String name;
	private int teacherid;
	
	public Student(){
		this.age = 10 ;
		this.name = "user";
		this.teacherid = 1;
	}
	
	public Student(int age,String name,int teacherid ){
		setAge(age);
		setName(name);
		setTeacherid(teacherid);
	}
	
	
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getTeacherid() {
		return teacherid;
	}

	public void setTeacherid(int teacherid) {
		this.teacherid = teacherid;
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
