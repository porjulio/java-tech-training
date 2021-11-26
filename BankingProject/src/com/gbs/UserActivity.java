package com.gbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserActivity {
	
	
	public Connection connect() throws SQLException {
	Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JBEDB", "root", "mysql");
	return myConnection;
	}
	
	public void LoginUser() {
				
	}
	
	public void AdminUser() {
		
	}
	public void NormalUser() {
	
	}
}
