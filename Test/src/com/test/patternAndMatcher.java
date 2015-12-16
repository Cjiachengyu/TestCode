package com.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class patternAndMatcher {

	public static void main(String[] args) {
		 // 生成 Pattern 对象并且编译一个简单的正则表达式 "Kelvin"  
        Pattern p = Pattern.compile("Kelvin");  
  
        // 用 Pattern 类的 matcher() 方法生成一个 Matcher 对象  
        Matcher m = p.matcher("This is a test Kelvin Li and Kelvin Chan are both working in Kelvin Chen's KelvinSoftShop company");  
  
        StringBuffer sb = new StringBuffer();  
        int i=0;  
          
        // 使用 find() 方法查找第一个匹配的对象  
        // 使用循环将句子里所有的 "kelvin" 找出并替换再将内容加到 sb 里  
        while(m.find()) {  
            i++;  
  
            m.appendReplacement(sb, "xxxx");             
            System.out.println("第" + i + "次匹配后sb的内容是：" + sb);  
        }  
  
        // 最后调用 appendTail() 方法将最后一次匹配后的剩余字符串加到 sb 里  
        m.appendTail(sb);  
  
        System.out.println("调用m.appendTail(sb)后sb的最终内容是:" + sb.toString()); 
	}
}
