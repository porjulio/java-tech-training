package aip.CityTracker;

import java.util.Scanner;
import java.util.ArrayList;

public class CityTracker {
	public static void main(String[] args) {
		String cities[] = new String[5];
		String inputCity[] = new String[5];
		String temp;
		int option, choice =1;
		Scanner city = new Scanner(System.in);
		Scanner choose = new Scanner(System.in);
		ArrayList<String> cityTracker = new ArrayList<String>();
		
//		do {
		System.out.println("Please enter 5 cities:");
		for(int i = 0; i < 5; i++) {
			System.out.print("Enter city: ");
			inputCity[i] = city.nextLine();
			cities[i] = inputCity[i];
			}
		city.close();
		System.out.println("\nThe Cities you have entered are: \n");
		
		for(int i = 0; i < 5; i++) {
			System.out.println(inputCity[i]);
		}
		do {
			System.out.println("\n\nOPTIONS:"
					+ "\n[1] Show in Ascending and Descending Order"
					+ "\n[2] Search for a City"
					+ "\n[3] Delete a City"
					+ "\n[4] Update a City"
					+ "\n[5] EXIT"
					+ "\nEnter [1-5]: ");
			option = choose.nextInt();
		}while(option < 1 || option > 5);
		//arrange alphabetically
		switch(option) {
			case 1:			for (int i = 0; i < 5; i++) 
					        {
					            for (int j = i + 1; j < 5; j++) { 
					                if (cities[i].compareToIgnoreCase(cities[j])>0) 
					                {
					                    temp = cities[i];
					                    cities[i] = cities[j];
					                    cities[j] = temp;
					                }
					            }
					            cityTracker.add(cities[i]);
					        }
							System.out.println(cityTracker);
							//reverse alphabetical
							cityTracker.clear();
							for (int i = 4; i >= 0; i--) 
					        {
								cityTracker.add(cities[i]); 
					        }
							System.out.println("\n" + cityTracker); break;
			
			case 2:			break;
		}
//		}while(choice==1);
	}
}
