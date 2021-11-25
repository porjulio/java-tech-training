package aip.Products;

public class Products {
	//ATTRIBUTE / FIELDS / VARIABLES / PROPERTIES
		int productId, productPrice;
		String productName, productDetails, productBrand, productColor, productConnectivity;
			
		//method	
		void displayDetails(){
			System.out.println(productId);
			System.out.println(productPrice);
			System.out.println(productName);
			System.out.println(productDetails);
			System.out.println(productBrand);
			System.out.println(productColor);
			System.out.println(productConnectivity);
		}
		
		public static void main(String[] args) {

		//first product
		Products prodObject1 = new Products();

		//assigning the details
		prodObject1.productId = 1;
		prodObject1.productPrice = 2888;
		prodObject1.productName = "Ajazz AK33 82 keys Mechanical Blue Switch Keyboard";
		prodObject1.productDetails="Durable Mechanical Gaming Switches - Guaranteed for 50 million keypresses, switches: red, blue, or brown.";
		prodObject1.productBrand = "Ajazz";
		prodObject1.productColor = "Black";
		prodObject1.productConnectivity = "Wired";

		//display
		prodObject1.displayDetails();	

		//second product
		Products prodObject2 = new Products();

		// assigning the details
		prodObject2.productId = 2;
		prodObject2.productPrice = 200;
		prodObject2.productName = "CPSTECH CT87 Oreo";
		prodObject2.productDetails="Mechanical Keyboard 87 Keys Gaming Keyboard Gamer Keyboards Colorful LED.";
		prodObject2.productBrand = "CPSTECH";
		prodObject2.productColor = "Black on White";
		prodObject2.productConnectivity = "Bluetooth";

		//display
		prodObject2.displayDetails();
		}
}
