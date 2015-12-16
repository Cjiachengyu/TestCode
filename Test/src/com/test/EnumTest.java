package com.test;

import com.testenum.Light;

public class EnumTest {

	public static void main(String[] args) {
		
		 Light light = Light.RED;
		 
		 int index = light.ordinal();
		 switch(light)
		 {
		 case RED: 
		 }
		 
		 System.out.println(light.name());
	}
}
