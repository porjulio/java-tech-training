package com.gbs;

import java.util.Scanner;

public class GBSApp {

	public static void main(String[] args) {
			Menu run = new Menu();
			run.showMenu();
		}
		
	}

class Menu {
	void showMenu() {
			
			char option = '\0';
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("Welcome to BNK!");
			System.out.println("\n");
			
			System.out.println("L : LOGIN");
			System.out.println("R : REGISTER");
			System.out.println("X : Exit The System");
			
			do {
				System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
				System.out.println("Enter Your Option: ");
				option = scanner.next().charAt(0);
				option = Character.toUpperCase(option);
				System.out.println("\n");
				
				switch (option) {
				
				case 'L':
					
							break;
					
				case 'R':	CreateUser register = new CreateUser();
							register.createAccount();
							break;
					
				case 'X' :
					System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
					break;
	
				default:
					System.out.println("Invalid Option!! Please Enter Correct Opton...");
					break;
				}			
			}
			while(option != 'X');
				System.out.println("Thank You for Using our Services!");
		}
}