package com.gbs;

public class DbConnection {
    public Connection connect() throws SQLException {
		Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/GBSDBV1", "root", "mysql");
		return myConnection;
	}
    
}
