package com.gbs;

import java.sql.SQLException;
import java.util.Scanner;

public class GBSApp {

	public static void main(String[] args) {

	}

	void showRun() {
		int choice = 0;
		do {
			Scanner in = new Scanner(System.in);
			System.out.println("[1] LOGIN\n[2] REGISTER\n[3] EXIT\nEnter Choice: ");
			int choice = in.nextInt();
			
			CreateUser register = new CreateUser();
			UserActivity userActivity = new UserActivity();
				switch (choice) {
								case 1:		register.createAccount(); break;
								case 2:		userActivity.LoginUser(); break;
				}
	}

}