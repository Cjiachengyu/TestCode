package com.test;

import com.bean.UserBean;

/**
 * ������Ϊ���������ⲿ����ķ������ڸ÷����жԸö������Ըı��Ӱ��ö��������ֵ��
 * 
 * 
 * @author jiachengyu
 *
 * @date 2014��8��4��
 */
public class CheckObject {

	public static void main(String[] args) {
		UserBean user = new UserBean(15, "test");
		
		ChangeObjectOutside.changeUser(user);
		
		System.out.println(user.getAge()+"   "+user.getName());
	}
}
