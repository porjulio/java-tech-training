package aip.CookiesArray;

public class CookiesArray {
	public static void main(String[] args) {
		String cookies[] = {"violet","indigo","blue","green","yellow","orange","red"};
		
	/*	for(int cookieCount = 1; cookieCount <= cookies.length; cookieCount++) {
			System.out.println("Enjoy the " + cookies[cookieCount - 1] + " cookies...");
		}*/
		
	/*	System.out.println("SEARCHING FOR GREEN COOKIE");
			String searchCookie = "green";
			for(int cookieCount = 0; cookieCount < cookies.length; cookieCount++) {
				String cookie = cookies[cookieCount];
				if(cookie.equals(searchCookie)) {
					System.out.println(searchCookie + " cookie found");
					break;
				}
				if(cookieCount == cookies.length-1) {
					System.out.println("Cookie not found");
				}
			}
			System.out.println("PROGRAM COMPLETE!!"); */
		
		for(int cookieCount = cookies.length-1; cookieCount >= 0; cookieCount--) {
			System.out.println("Enjoy the " + cookies[cookieCount] + " cookies...");
		}
	}
}