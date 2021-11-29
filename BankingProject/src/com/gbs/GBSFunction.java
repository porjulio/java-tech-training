package com.gbs;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class GBSFunction {

	DbConnection db = new DbConnection();

	void startMenu() {

		char option = '\0';
		Scanner scanner = new Scanner(System.in);

		System.out.println("Welcome to BNK!");
		System.out.println("\n");

		System.out.println("L : LOGIN");
		System.out.println("R : REGISTER");
		System.out.println("X : Exit The System");

		do {
			System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
			System.out.println("Enter Your Option: ");
			option = scanner.next().charAt(0);
			option = Character.toUpperCase(option);
			System.out.println("\n");

			switch (option) {

			case 'L':
				login();
				break;

			case 'R':
				createAccount();
				break;

			case 'X':
				System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
				break;

			default:
				System.out.println("Invalid Option!! Please Enter Correct Opton...");
				break;
			}
		} while (option != 'X');
		System.out.println("Thank You for Using our Services!");
		scanner.close();
	}

	void createAccount() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
		System.out.print("\nCREATE ACCOUNT");
		System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
		System.out.println("Username:\t");
		String userName = scanner.nextLine();
		System.out.print("\nPassword:\t");
		String password = scanner.nextLine();
		System.out.print("\nContact Number:\t");
		String contact = scanner.nextLine();
		System.out.print("\nInitial Deposit:\t");
		float amount = Float.parseFloat(scanner.nextLine());
		System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
		System.out.println("\nCREATING ACCOUNT . . .\nPLEASE WAIT . . .");
		System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
		try {
			Statement insertStatement = db.connect().createStatement();
			String queryString = "INSERT INTO USERS(USER_ID,USER_NAME,USER_PASSWORD,CREATION_DATE,TOTAL_BALANCE,CONTACT_NUMBER) VALUES (UUID_SHORT()"
					+ ",'" + userName + "','" + password + "',now()," + amount + ",'" + contact + "'" + ")";
			int rowCount = insertStatement.executeUpdate(queryString);
			if (rowCount != 0) {
				System.out.println("SUCCESSFULLY CREATED!");
				startMenu();
			} else {
				System.out.println("No rows.");
			}

		} catch (SQLException sqlException) {
			System.out.println("DATABASE CONNECTION ISSUE " + sqlException);
		}
		scanner.close();
	}

	void login() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
		System.out.print("\tLOGIN to BNK");
		System.out.print("\nUsername:\t");
		String userName = scanner.nextLine();
		System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
		System.out.print("Password:\t");
		String password = scanner.nextLine();
		System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
		System.out.println("Logging in . . .");

		try {

			Statement selectStatement = db.connect().createStatement();

			String queryString = "SELECT * FROM USERS WHERE USER_NAME = '" + userName + "'";
			ResultSet resultSet = selectStatement.executeQuery(queryString);

			while (resultSet.next()) {
				String getPassword = resultSet.getString("USER_PASSWORD");
				if (password.equals(getPassword)) {
					System.out.println("WELCOME, " + userName);
					userMenu(userName);
				} else {
					System.out.println("Incorrect credentials!");
				}
			}

		} catch (SQLException sqlException) {
			System.out.println("DATABASE CONNECTION ISSUE " + sqlException);
		}
		scanner.close();
		System.out.println("Thank you for banking with us!");
	}
	
	void userMenu(String userName) {
		try {
			Statement selecStatement = db.connect().createStatement();

			String queryString = "SELECT * FROM USERS WHERE USER_NAME = '" + userName + "'";
			ResultSet resultSet = selecStatement.executeQuery(queryString);

			while (resultSet.next()) {
				Scanner scanner = new Scanner(System.in);
				int choice;
				do {
					
					System.out.println("\nStart your BNKing Experience!");
					System.out.print(
							"MENU\n[1] Check Balance\n[2] Deposit\n[3] Withdraw\n[4] Transfer\n[5] EXIT\nOption: ");
					choice = Integer.parseInt(scanner.nextLine());

					switch (choice) {
					case 1:
						selectBalance(userName);
						break;
					case 2:
						deposit(userName);
						break;
					case 3:
						withdraw(userName);
						break;
					case 4:
						transfer(userName);
						break;
					case 5:
						break;
					default:
						System.out.println("Invalid input!");
						break;
					}
				} while (choice != 5);
				scanner.close();
				}

		} catch (SQLException sqlException) {
			System.out.println("DATABASE CONNECTION ISSUE " + sqlException);
		}
		System.out.println("Thank you for banking with us " + userName +"!");
	}
	

	void selectBalance(String userName) {
		try {
			Statement selecStatement = db.connect().createStatement();

			String queryString = "SELECT * FROM USERS WHERE USER_NAME = '" + userName + "'";
			ResultSet resultSet = selecStatement.executeQuery(queryString);

			while (resultSet.next()) {
				float amount = resultSet.getFloat("TOTAL_BALANCE");
				System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
				System.out.println("USERNAME:\t" + userName);
				System.out.println("Your Balance is:\t" + amount);
				System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
			}

		} catch (SQLException sqlException) {
			System.out.println("DATABASE CONNECTION ISSUE " + sqlException);
		}
		userMenu(userName);
	}

	void deposit(String userName) throws SQLException {
		float addMoney;
		Scanner scanner = new Scanner(System.in);
		System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
		System.out.print("DEPOSIT");
		System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
		System.out.print("\n\nEnter Amount : ");
		float amount = 0;
		addMoney = Float.parseFloat(scanner.nextLine());
		System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
		Statement selecStatement = db.connect().createStatement();

		String queryString1 = "SELECT * FROM USERS WHERE USER_NAME = '" + userName + "'";
		ResultSet resultSet = selecStatement.executeQuery(queryString1);

		while (resultSet.next()) {
			amount = resultSet.getFloat("TOTAL_BALANCE");
		}

		Statement insertStatement = db.connect().createStatement();

		String queryString = "UPDATE USERS SET TOTAL_BALANCE=" + (amount + addMoney) + " WHERE USER_NAME = '" + userName
				+ "'";
		int rowCount = insertStatement.executeUpdate(queryString);
		if (rowCount != 0) {
			System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
			System.out.println("SUCCESS!");
			System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
			System.out.println("TOTAL BALANCE:\tPhp " + (amount + addMoney));
			System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
			userMenu(userName);

		} else {
			System.out.println("No rows.");
		}
		scanner.close();
	
	}

	void withdraw(String userName) throws SQLException {

		float withdraw;
		float amount = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
		System.out.print("WITHDRAW");
		System.out.print("\n\nEnter Amount : ");
		withdraw = Float.parseFloat(scanner.nextLine());
		System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
		Statement selecStatement = db.connect().createStatement();
		String queryString1 = "SELECT * FROM USERS WHERE USER_NAME = '" + userName + "'";
		ResultSet resultSet = selecStatement.executeQuery(queryString1);
		while (resultSet.next()) {
			amount = resultSet.getFloat("TOTAL_BALANCE");
		}
		if (amount >= withdraw) {
			Statement insertStatement = db.connect().createStatement();

			String queryString = "UPDATE USERS SET TOTAL_BALANCE=" + (amount - withdraw) + " WHERE USER_NAME = '"
					+ userName + "'";
			int rowCount = insertStatement.executeUpdate(queryString);
			if (rowCount != 0) {
				System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
				System.out.println("SUCCESS!");
				System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
				System.out.println("\nTOTAL BALANCE :" + (amount - withdraw));
				System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
				userMenu(userName);

			} else {
				System.out.println("No rows.");
			}

		} else {
			System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
			System.out.println("INSUFFICIENT BALANCE");
			System.out.println("Current Account Balance: " + amount);
			System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
		}
		scanner.close();
		
	}

	void transfer(String userName) {
		float sendMoney;
		float balance = 0, balancetrans = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.print("\nTRANSFER MONEY\n=============================");
		System.out.print("\n\nSEND TO: ");
		String username2 = scanner.nextLine();
		System.out.print("\n\nEnter Amount : ");
		sendMoney = scanner.nextFloat();

		try {
			Statement selectStatement = db.connect().createStatement();
			String queryString = "SELECT * FROM USERS WHERE USER_NAME = '" + username2 + "'";
			ResultSet resultSet = selectStatement.executeQuery(queryString);

			while (resultSet.next()) {
				balancetrans = resultSet.getFloat("TOTAL_BALANCE");
				String uname2 = resultSet.getString("USER_NAME");
				if (username2.equals(uname2)) {
					Statement selecStatement = db.connect().createStatement();
					String queryString1 = "SELECT * FROM USERS WHERE USER_NAME = '" + userName + "'";
					ResultSet resultSet1 = selecStatement.executeQuery(queryString1);

					while (resultSet1.next()) {
						balance = resultSet1.getFloat("TOTAL_BALANCE");
					}
					if (balance >= sendMoney) {
						Statement insertStatement = db.connect().createStatement();
						Statement sendStatement = db.connect().createStatement();
						String queryString11 = "UPDATE USERS SET TOTAL_BALANCE=" + (balance - sendMoney)
								+ " WHERE USER_NAME = '" + userName + "'";

						String queryString12 = "UPDATE USERS SET TOTAL_BALANCE=" + (balancetrans + sendMoney)
								+ " WHERE USER_NAME = '" + username2 + "'";
						sendStatement.executeUpdate(queryString12);

						int rowCount = insertStatement.executeUpdate(queryString11);
						if (rowCount != 0) {
							System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
							System.out.println("SUCCESS!");
							System.out.println("SENT TO : " + username2);
							System.out.println("AMOUNT SEND : " + sendMoney);
							System.out.println("\nYOUR NEW BALANCE :" + (balance - sendMoney));
							System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
							userMenu(userName);

						} else {
							System.out.println("No rows.");
						}

					} else {
						System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
						System.out.println("TRANSFER FAILED!");
						System.out.println("Insufficient Balance!");
						System.out.println("Current Account Balance: " + balance);
						System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
					}

				} else {
					System.out.println("USER NOT FOUND!");
					System.out.println("Cannot complete the transfer.");
				}
			}

		} catch (SQLException sqlException) {
			System.out.println("DATABASE CONNECTION ISSUE " + sqlException);
		}
	}
}
