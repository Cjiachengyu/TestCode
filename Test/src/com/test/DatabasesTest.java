package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import com.bean.Student;

public class DatabasesTest {
	public static final int LENGTH = 1000000;
	
	public static void main(String[] args) {

		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/cloudmate";
		String user = "root";
		String password = "newpass";
		
		Map<Integer, Integer> textbookIdAndCategory = new HashMap<Integer,Integer>();

		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url,user, password);

//			Statement statement = (Statement) conn.createStatement();

			String sql = "select * from schemaTextbook";
			String updateSql = "update textbook set category = ? where textbookId = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			PreparedStatement pst2 = conn.prepareStatement(updateSql);
			
			ResultSet res;

			res = pst.executeQuery(sql);
			int count = 0;
			while(res.next())
			{
				textbookIdAndCategory.put(res.getInt("textbookId"), res.getInt("category"));
				count++;
//				System.out.println(res.getString("schemaId")+"\t"+res.getInt("textbookId")+"\t"+res.getString("category"));
			}
			System.out.println("read finished.....");
			System.out.println(count+" rows ");
			//开始更新数据库
			for(Map.Entry<Integer, Integer> entry : textbookIdAndCategory.entrySet()) {  
	            int key = entry.getKey();  
	            int value = entry.getValue();
	            pst2.setInt(1, value);
	            pst2.setInt(2, key);
	            pst2.executeUpdate();
	        }  
			
			System.out.println("update finished ");
			
			res.close();
			pst.close();
			pst2.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
