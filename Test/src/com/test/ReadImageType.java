package com.test;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

/**
 * 获取照片格式
 * 
 * @author cjia
 *
 */
public class ReadImageType {
	
	public static void main(String[] args){
		
		 File f = new File("D:\\java\\upload\\2.png");  
	        if (f.exists()) {
	            System.out.println(getFormatName(f));  
	        }  
	}
	
	private static String getFormatName(Object o) {  
	        try {  
	            // Create an image input stream on the image   
	            ImageInputStream iis = ImageIO.createImageInputStream(o);  
	            
	            // Find all image readers that recognize the image format   
	            Iterator<ImageReader> iter = ImageIO.getImageReaders(iis);  
	            if (!iter.hasNext()) {  
	                // No readers found   
	                return null;  
	            }  
	  
	            // Use the first reader   
	            ImageReader reader = iter.next();  
	  
	            // Close stream   
	            iis.close();  
	  
	            // Return the format name   
	            return reader.getFormatName();  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }  
	  
	        // The image could not be read   
	        return null;  
	    }   
}
