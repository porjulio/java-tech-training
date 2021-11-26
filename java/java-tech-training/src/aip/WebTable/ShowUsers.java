package aip.WebTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ShowUsers {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
	try {
			System.out.println("CONNECTING");
			Connection mySQLConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JBEDB", "root",
					"mysql");
			System.out.println("CREATING STATEMENT");
			Statement selectStatement = mySQLConnection.createStatement();
			System.out.println("EXECUTING QUERY AND OBTAINING RESULTSET");

			//print all data in table
			ResultSet resultSet =  selectStatement.executeQuery("SELECT * FROM USERS WHERE ");
			System.out.println("ITERATING THROUGH THE RESULT SET AND FETCHING THE ROWS");
			while(resultSet.next()) {
				int userId = resultSet.getInt("PRODUCT_ID");
				String userName = resultSet.getString("PRODUCT_NAME");
				String userPassword = resultSet.getString("USER_PASSWORD");
				String creationDate = resultSet.getString("CREATION_DATE");
				int numberOfAccounts = resultSet.getInt("NUMBER_OF_ACCOUNTS");
				int accountNumber = resultSet.getInt("ACCOUNT_NUMBER");
				float totalBalance = resultSet.getFloat("TOTAL_BALANCE");
				String contactNumber = resultSet.getString("CONTACT_NUMBER");
		}
	} catch (SQLException sqlException) {
		System.out.println("DATABASE CONNECTION ISSUE " + sqlException);		
	}
}
}
