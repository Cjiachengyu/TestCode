package com.test;

import java.io.File;
import java.io.IOException;

import net.coobird.thumbnailator.Thumbnails;

/**
 * ����ThumbNail��������ͼ
 * 
 * @author cjia
 *
 * @version ����ʱ�䣺2015��8��27��
 */
public class ThumbNailTest {

	public static void main(String[] args) throws IOException {

		File file1 = new File("D:/java/test/31.gif");
		File file2 = new File("D:/java/test/thumb_31.gif");

		
		try {

			Thumbnails.of(file1).size(100, 100).toFile(file2);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("ok");
	}
}
