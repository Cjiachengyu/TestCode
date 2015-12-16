package com.bean;

public class UserBean {

	private int age;
	private String name;

	public UserBean(){
		this.age = 10 ;
		this.name = "user";
	}
	
	public UserBean(int age,String name){
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
		
	public void printAge()
	{
		System.out.println(name+"'s age is "+age);
	}
	
	static{
		System.out.println("create user");
	}
}
