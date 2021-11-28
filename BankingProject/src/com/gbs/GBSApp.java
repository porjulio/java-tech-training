package com.gbs;

import java.sql.SQLException;
import java.util.Scanner;

public class GBSApp {

	public static void main(String[] args) throws SQLException {
		
	}

	void showRun() {
		do {
			Scanner in = new Scanner(System.in);
			System.out.println("[1] LOGIN\n[2] REGISTER\n[3] EXIT\nEnter Choice: ");
			int choice = Integer.parseInt(in.nextLine());
			
			CreateUser register = new CreateUser();
			UserActivity userActivity = new UserActivity();
				switch (choice) {
								case 1:		register.createAccount(); break;
								case 2:		userActivity.LoginUser(); break;
								case 3:		System.out.println("Thank you for using BNK online services!");
								default:	break;
				}
			}while();

//
	}
}	
