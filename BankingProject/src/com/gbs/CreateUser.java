package com.gbs;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CreateUser {

	void createAccount() {
		Scanner in = new Scanner(System.in);
		System.out.print("\nCREATE ACCOUNT\n\nUSERNAME: ");
		String username = in.nextLine();
		System.out.print("\nPASSWORD: ");
		String password = in.nextLine();
		System.out.print("\nCONTACT NO.: ");
		String contact = in.nextLine();
		System.out.print("\nAMOUNT TO BE DEPOSITED: ");
		float amount = Float.parseFloat(in.nextLine());
		DbConnection db = new DbConnection();
		
		System.out.println("\nCREATING ACCOUNT PLEASE WAIT...");
		try {

			Statement insertStatement = db.connect().createStatement();

			String queryString = "INSERT INTO USERS(USER_ID,USER_NAME,USER_PASSWORD,CREATION_DATE,TOTAL_BALANCE,CONTACT_NUMBER) VALUES (UUID_SHORT()"
					+ ",'" + username + "','" + password + "',now()," + amount + ",'" + contact + "'" + ")";
			int rowCount = insertStatement.executeUpdate(queryString);
			if (rowCount != 0) {
				System.out.println("SUCCESSFULLY CREATED!");

			} else {
				System.out.println("No rows.");
			}

		} catch (SQLException sqlException) {
			System.out.println("DATABASE CONNECTION ISSUE " + sqlException);
		}
		in.close();
	}
}
