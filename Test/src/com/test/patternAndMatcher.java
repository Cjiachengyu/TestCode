package com.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class patternAndMatcher {

	public static void main(String[] args) {
		 // ���� Pattern �����ұ���һ���򵥵�������ʽ "Kelvin"  
        Pattern p = Pattern.compile("Kelvin");  
  
        // �� Pattern ��� matcher() ��������һ�� Matcher ����  
        Matcher m = p.matcher("This is a test Kelvin Li and Kelvin Chan are both working in Kelvin Chen's KelvinSoftShop company");  
  
        StringBuffer sb = new StringBuffer();  
        int i=0;  
          
        // ʹ�� find() �������ҵ�һ��ƥ��Ķ���  
        // ʹ��ѭ�������������е� "kelvin" �ҳ����滻�ٽ����ݼӵ� sb ��  
        while(m.find()) {  
            i++;  
  
            m.appendReplacement(sb, "xxxx");             
            System.out.println("��" + i + "��ƥ���sb�������ǣ�" + sb);  
        }  
  
        // ������ appendTail() ���������һ��ƥ����ʣ���ַ����ӵ� sb ��  
        m.appendTail(sb);  
  
        System.out.println("����m.appendTail(sb)��sb������������:" + sb.toString()); 
	}
}
