package com.login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {

	String username = "root";
	String password="12345";
	String url = "jdbc:mysql://localhost:3306/userdb?useSSL=false";
	String query = "select * from userinfo where name=? and password=?";
	
	public boolean checkCreds (String uname, String pass) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, username, password);
			PreparedStatement sts = conn.prepareStatement(query);
			sts.setString(1, uname);
			sts.setString(2, pass);
			ResultSet res = sts.executeQuery();
			if(res.next()) {
				return true;
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

}
