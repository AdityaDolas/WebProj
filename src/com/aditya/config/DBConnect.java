package com.aditya.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	public static Connection getConnect() {
		Connection con=null;
		try {
			Class.forName("org.h2.Driver");
			con=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/Aditya","sa","sa");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Connecting to database ...");
		return con;
		
	}
}
