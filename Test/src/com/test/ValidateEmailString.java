package com.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ������ʽ���email��ַ�Ƿ���Ϲ淶
 * 
 * @author jiachengyu
 *
 * @date 2014��8��8��
 */
public class ValidateEmailString {

	public static void main(String[] args) {
	

		String input = "email@163.com";  
        
        // �������� Email ��ַ�Ƿ��ԷǷ����� "." �� "@" ��Ϊ��ʼ�ַ�  
        Pattern p = Pattern.compile("^\\.|^\\@");  
        Matcher m = p.matcher(input);  
        boolean flag = false;
        if (m.find()) {  
            System.err.println("EMAIL��ַ������'.'��'@'��Ϊ��ʼ�ַ�");  
            flag = true;
        }  
  
        // ����Ƿ��� "www." Ϊ��ʼ  
        p = Pattern.compile("^www\\.");  
        m = p.matcher(input);  
        if (m.find()) {  
            System.out.println("EMAIL��ַ������'www.'��ʼ");  
            flag = true;
        }  
  
        // ����Ƿ�����Ƿ��ַ�  
        p = Pattern.compile("[^A-Za-z0-9\\.\\@_\\-~#]+");  
        m = p.matcher(input);  
  
        StringBuffer sb = new StringBuffer();  
        boolean result = m.find();  
        boolean deletedIllegalChars = false;  
        while(result) {  
            // ����ҵ��˷Ƿ��ַ���ô�����±��  
            deletedIllegalChars = true;  
            // �����������Ƿ��ַ���ð��˫���ŵȣ���ô�Ͱ�������ȥ���ӵ� SB ����  
            m.appendReplacement(sb, "");  
            result = m.find();  
        }  
  
        m.appendTail(sb);  
      
        if (deletedIllegalChars) {  
            System.out.println("�����EMAIL��ַ�������ð�š����ŵȷǷ��ַ������޸�");  
            System.out.println("�����ڵ�����Ϊ: "+input);  
            System.out.println("�޸ĺ�Ϸ��ĵ�ַӦ����: "+sb.toString());  
            return ;
        }
        if(!flag)
        System.out.println(input+"  ����Email��ʽ��");
	}
}
