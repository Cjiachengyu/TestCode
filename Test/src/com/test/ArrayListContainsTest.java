package com.test;

import java.util.ArrayList;

public class ArrayListContainsTest {

	public static void main(String[] args) {
		
		User u1 = new User(1,"hihi");
		User u2 = new User(2,"haha");
		User u3 = new User(3,"hehe");
		
		ArrayList<User> users = new ArrayList<User>();
		
		users.add(u1);
		users.add(u2);
		users.add(u3);
		
		System.out.println(users.contains(new User(1,"hihi")));
	}
}
