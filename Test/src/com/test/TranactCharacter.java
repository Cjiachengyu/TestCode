package com.test;

import java.io.UnsupportedEncodingException;
import java.util.regex.Pattern;


/**
 * ���ݿ�ȫ������ʱ���������ַ���ת�����ڽ������������mysql��֧����������������
 * ��Ӧ�ģ���������ݵ�ʱ��ҲҪ�Ƚ��ַ���������ٲ������ݿ���
 * 
 * @author jiachengyu
 *
 * @date 2014��9��3��
 */
public class TranactCharacter {

	public static void main(String[] args) {

		String str = "�й�";
		System.out.println(getSimpleAnalyzedWords(str));
	}
	
	/**
	 * �ַ���ת������
	 * 
	 * @param words
	 * @return
	 */
	public  static String getSimpleAnalyzedWords(String words)
    {
        String analyzedWords = "";
        int wordsLength = words.length();
        for (int i = 0; i < wordsLength;)
        {
            if (words.charAt(i) == ' ')
            {
                i++;
                continue;
            }
            String substring = words.substring(i, i + 1);
            int bLength = substring.getBytes().length;
            int substrLength = substring.length();
            if (Pattern.compile("[0-9]*").matcher(substring).matches())
            {
            	//����
                int j = i + 1;
                for (; j < wordsLength;)
                {
                    if (words.charAt(j) == ' ')
                    {
                        break;
                    }
                    String substringNext = words.substring(j, j + 1);
                    if (Pattern.compile("[0-9]*").matcher(substringNext).matches())
                    {
                        substring += substringNext;
                        j++;
                    }
                    else
                    {
                        break;
                    }
                }
                i = j;
                analyzedWords = analyzedWords + substring + " ";
                continue;
            }
            else if (bLength == substrLength)
            {
            	//Ӣ���ַ�������
                int j = i + 1;
                for (; j < wordsLength;)
                {
                    if (words.charAt(j) == ' ')
                    {
                        break;
                    }
                    String substringNext = words.substring(j, j + 1);
                    if (Pattern.compile("[0-9]*").matcher(substringNext).matches())
                    {
                        break;
                    }
                    else
                    {
                        int bLengthNext = substringNext.getBytes().length;
                        int substrLengthNext = substringNext.length();
                        if (bLengthNext == substrLengthNext)
                        {
                            substring += substringNext;
                            j++;
                        }
                        else
                        {
                            break;
                        }
                    }
                }
                i = j;
                analyzedWords = analyzedWords + substring + " ";
                continue;
            }
            else
            {
                if (wordsLength == 1)
                {
                    analyzedWords = getQuwei(words).toString();
                }
                else if (i < wordsLength - 1)
                {
                    String substringNext = words.substring(i + 1, i + 2);
                    int bLengthNext = substringNext.getBytes().length;
                    int substrLengthNext = substringNext.length();
                    if (bLengthNext != substrLengthNext)
                    {
                        analyzedWords = analyzedWords + getQuwei(substring).toString()
                                + getQuwei(substringNext).toString()
                                + " ";
                    }
                }
            }
            i++;
        }
        return analyzedWords;
    }
	
	public static StringBuffer getQuwei(String str)
    {
        StringBuffer stringBuffer = new StringBuffer();
        byte[] b = null;
        try
        {
            b = str.getBytes("gb2312");
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        int[] quwei = new int[b.length / 2];
        for (int i = 0, k = b.length / 2; i < k; i++)
        {
            quwei[i] = (((b[2 * i] - 0xA0) & 0xff) * 100) + ((b[2 * i + 1] - 0xA0) & 0xff);
        }
        for (int i : quwei)
        {
            stringBuffer.append(i);
        }
        return stringBuffer;
    }
}

