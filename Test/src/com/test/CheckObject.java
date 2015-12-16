package com.test;

import com.bean.UserBean;

/**
 * 对象作为参数传给外部对象的方法，在该方法中对该对象属性改变会影响该对象的属性值；
 * 
 * 
 * @author jiachengyu
 *
 * @date 2014年8月4日
 */
public class CheckObject {

	public static void main(String[] args) {
		UserBean user = new UserBean(15, "test");
		
		ChangeObjectOutside.changeUser(user);
		
		System.out.println(user.getAge()+"   "+user.getName());
	}
}
