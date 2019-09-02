package com.aditya.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.aditya.config.DBConnect;

public class LoginDao {

	String sql = "SELECT * FROM USER  where NAME=? and PASSWORD=?;";
	String url = "jdbc:h2:tcp://localhost/~/Aditya";
	String username = "sa";
	String password = "sa";

	public boolean check(String uname, String pass) {
		try {
			Class.forName("org.h2.Driver");
			Connection connection = DBConnect.getConnect();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, uname);
			statement.setString(2, pass);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;

	}

}
