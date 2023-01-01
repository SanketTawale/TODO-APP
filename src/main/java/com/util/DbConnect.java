package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnect {
	private static Connection connection;
	public static Connection getConnection() {
		try {
			String url="jdbc:mysql://localhost:3306/todo";
			String username="root";
			String password="Sanket7@";
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url,username,password);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
}
