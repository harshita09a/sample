package com.cg.util;

import java.sql.DriverManager;

import java.sql.Connection;

public class DBUtil {
	static Connection con;
	static
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String user="system";
			String pass="Capgemini123";
			String url="jdbc:oracle:thin:@localhost:1521:XE";
			con =DriverManager.getConnection(url,user,pass);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	public static Connection getConnect()
	{
		return con;
	}

}
