package aip.exScanner;

import java.util.Scanner;

class ProductItem {
	String productName;
	float productPrice;
	String productBrand;
	String productColor;
	
	void acceptDetails () {
	Scanner keyScanner = new Scanner(System.in);
		
	System.out.println("Enter Name: ");	
	String msgName = keyScanner.nextLine();
	productName = msgName;
	
	System.out.println("Enter Price: ");	
	String msgPrice = keyScanner.nextLine();
	productPrice = Float.parseFloat(msgPrice);
	
	System.out.println("Enter Brand: ");	
	String msgBrand = keyScanner.nextLine();
	productBrand = msgBrand;
	
	System.out.println("Enter Color: ");	
	String msgColor = keyScanner.nextLine();
	productColor = msgColor;
	keyScanner.close();
	}
	
	void printDetails () {
	System.out.println("Name: " + productName);
	System.out.format("Price: %.2f", productPrice);
	System.out.println("\nBrand: " + productBrand);
	System.out.println("Color: " + productColor);
	}
}

public class exScanner {
public static void main(String[] args) {
	ProductItem viewProducts = new ProductItem();
	viewProducts.acceptDetails();
	viewProducts.printDetails();
 }	
}