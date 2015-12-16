package com.test;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import com.bean.UserBean;
import com.sun.media.jfxmedia.events.NewFrameEvent;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

/**
 * ������������
 * 
 * @author cjia
 *
 * @version ����ʱ�䣺2015��7��10��
 */
public class ChineseCompare {

	public static void main(String[] args) {

		UserBean userBean1 = new UserBean();
		userBean1.setName("�ֳ���");

		UserBean userBean2 = new UserBean();
		userBean2.setName("����");

		UserBean userBean3 = new UserBean();
		userBean3.setName("�³�");

		UserBean userBean4 = new UserBean();
		userBean4.setName("��ΰ");

		List<UserBean> userList = new ArrayList<UserBean>();
		userList.add(userBean1);
		userList.add(userBean2);
		userList.add(userBean3);
		userList.add(userBean4);

		for (UserBean userBean : userList) {
			System.out.println(userBean.getName());
		}
		System.out.println();
		System.out.println("-----------------");
		System.out.println();

		java.util.Collections.sort(userList, comparatorByStuAsmSubmitTime);

		for (UserBean userBean : userList) {
			System.out.println(userBean.getName());
		}

	}

	public static Comparator<UserBean> comparatorByStuAsmSubmitTime = new Comparator<UserBean>() {

		Collator cmp = Collator.getInstance(java.util.Locale.CHINA);

		@Override
		public int compare(UserBean o1, UserBean o2) {
			return cmp.compare(o1.getName(), o2.getName());
		}
	};

}
