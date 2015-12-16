package com.test;

import com.bean.UserBean;

public class ChangeObjectOutside {

	public static void changeUser(UserBean user) {
		user.setAge(12);
		user.setName("change");
	}
}
