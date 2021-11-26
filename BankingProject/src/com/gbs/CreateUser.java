package com.gbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CreateUser {
	public Connection connect() throws SQLException {
		Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JBEDB", "root", "mysql");
		return myConnection;
	}

	void createAccount() {
		Scanner in = new Scanner(System.in);
		System.out.print("\nCREATE ACCOUNT\n\nUSERNAME: ");
		String username = in.nextLine();
		System.out.print("\nPASSWORD: ");
		String password = in.nextLine();
		System.out.print("\nCONTACT NO.: ");
		String contact = in.nextLine();
		System.out.print("\nAMOUNT TO BE DEPOSITED: ");
		Double amount =in.nextDouble();
		System.out.println("\nCREATING ACCOUNT PLEASE WAIT...");
		try {

			Statement insertStatement = connect().createStatement();

			String queryString = "INSERT INTO USERS(USER_NAME,PASSWORD,CREATION_DATE,TOTAL_BALANCE,CONTACT_NUMBER) VALUES ("
					+ "'" + username + "','" + password + "',now()," + amount + ",'" + contact + "'" + ")";
			int rowCount = insertStatement.executeUpdate(queryString);
			if (rowCount != 0) {
				System.out.println("SUCCESSFULLY CREATED!");

			} else {
				System.out.println("No rows.");
			}

		} catch (SQLException sqlException) {
			System.out.println("DATABASE CONNECTION ISSUE " + sqlException);
		}
	}
}
