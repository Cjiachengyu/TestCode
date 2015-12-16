package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseUtil {

	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://127.0.0.1:3306/test";
	private static final String user = "root";
	private static final String password = "newpass";

	private static Connection conn;
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 取得默认的连接
	 * @return
	 */
	public static Connection getConnection()
	{
		if(conn == null)
		{
			try {
				conn = DriverManager.getConnection(url,user, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return conn;
	}
	
	/**
	 * 获取指定连接
	 */
	public static Connection getConnection(String url,String username,String pass)
	{
		try {
			Connection connection = DriverManager.getConnection(url,username, pass);
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
			return null ;
		}
	}

	public static void closeAll(ResultSet rst , PreparedStatement pst ,Connection conn)
	{
		if(rst != null)
		{
			try {
				rst.close();
			 } catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(pst != null)
		{
			   try {
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(conn != null)
		{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
