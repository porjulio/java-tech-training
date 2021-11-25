package aip.CountCharacters;
import java.util.Scanner;

public class CountCharacters {
	
		public static void main(String[] args) {
			Scanner in = new Scanner(System.in);
			System.out.print("Input the string: ");
			String str = in.nextLine();
			str = str.toLowerCase();

			int vCount = 0, cCount = 0, sCount = 0, nCount = 0;
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) < 'a' || str.charAt(i) > 'z') {
					if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
						nCount++;
					} else {
						sCount++;
					}
				} else if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o'
						|| str.charAt(i) == 'u') {
					vCount++;
				} else {
					cCount++;
				}
				in.close();
			}
			System.out.println("The vowel count is: " + vCount + "\nThe consonant count is: " + cCount
					+ "\nThe special character count is: " + sCount + "\nThe number count is: " + nCount);
			;
		}
	}

