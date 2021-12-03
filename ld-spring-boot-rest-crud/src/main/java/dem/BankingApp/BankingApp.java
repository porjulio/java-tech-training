package dem.BankingApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankingApp {

	public static void main(String[] args) {
		System.out.println("Hello World! Web App!");
		SpringApplication.run(BankingApp.class, args);
	}

}
