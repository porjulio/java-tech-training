package aip.SevenDays;
import java.util.Scanner;

public class SevenDays {
	public static void main(String[] args) {
		String days[] = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
		Scanner keyscanner = new Scanner(System.in);
		char choice;
		do {
			System.out.print("Enter a number[1-7]: ");
			int given = keyscanner.nextInt();
			if(given >= 1 && given <=7) {
				System.out.println("The Day is: " + days[given-1]);
			}else{
				System.out.println("You have entered an invalid number!");
			}
			System.out.print("\nTry again?[y|n]: ");
			choice = keyscanner.next().toCharArray()[0];
		}while(choice=='y');
		keyscanner.close();
		System.exit(0);
	}
}