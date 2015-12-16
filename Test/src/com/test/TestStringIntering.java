package com.test;

import java.util.ArrayList;

public class TestStringIntering {

	public static void main(String[] args) {
		// int hex = 0xCAFEBABE;
		// int classValue = -889275714;
		// System.out.println(hex);
		// System.out.println(classValue);
		String string = "hello";
		String string3 = "hello";
		String string4 = "he";
		String string5 = "llo";
		String string6 = "he" + "llo";
		
		String str = string6.intern();

	    System.out.println(str == string3);
		
	}

	public static void changeString(String string) {
		;
	}

	public static void changeCat(Cat cat) {
		cat.setAge(10);
		cat.setName("change");
	}

	public static void changeStringList(ArrayList<String> lists) {
		lists.add(new String("add"));
	}
}

class Cat {

	private int age;
	private String name;

	public Cat() {
		this.age = 4;
		this.name = "miaomiao";
	}

	public Cat(int age, String name) {
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

}
