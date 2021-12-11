package dem.BankingApp.UserController;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dem.BankingApp.UserInfo.UserLogin;
//import dem.BankingApp.UserInfo.UserInfo;
import dem.BankingApp.UserRepository.UserLoginRepository;

@RestController
@RequestMapping("/login")
public class UserLoginController {
	@Autowired
	UserLoginRepository userLoginRepository;

//	@GetMapping("login/{id}")
//	public UserLogin loginUSer(@PathVariable(value="userName") String usernameString, @RequestBody UserLogin userFromBrowser, String userPassword) {
//		UserLogin findUsername = userLoginRepository.findByUsername(usernameString).get();
//		String findUsernameString = findUsername.toString();
//		
//		UserLogin findUserPassword = userLoginRepository.findByUserPassword(userPassword).get();
//		String findUserPasswordString = findUserPassword.toString();
//		
//		String enteredUsername = userFromBrowser.getUserNameString();
//		String enteredPassword = userFromBrowser.getUserPassword();
//		
//		if(enteredUsername == findUsernameString) {
//			if(enteredPassword == findUserPasswordString) {
//				System.out.println("SUCCESS!");
//			}else {
//				System.out.println("INVALID CREDENTIALS!");
//			}
//		}else {
//			System.out.println("INVALID CREDENTIALS!");
//		}
//		return findUsername;
//	}
	@GetMapping("/allusers")
	public List<UserLogin> getAllUser() {
		try {
			List<UserLogin> userLoginList = userLoginRepository.findAll();
			return userLoginList;
		} catch (Exception e) {
			System.out.println("Error. " + e);
			return null;
		}
	}

	@PostMapping("/register")
	public UserLogin createUser(@RequestBody UserLogin userFromBrowser) {
		System.out.println("Inserting : " + userFromBrowser);
		UserLogin registeredUser = userLoginRepository.save(userFromBrowser);
		return registeredUser;
	}

//	@PostMapping("/session")
//	public ResponseEntity<UserLogin> userLoginValidation(@PathVariable(value="id") Long userID, @PathVariable String userPassword) {
//		try {
//			UserLogin userLogin = userLoginRepository.getOne(userID);
//			if(userLogin.isPresent()) {
//				System.out.println("User Exists!");
//			}
//			UserLogin passwordLogin = userLoginRepository.findById(userID).get();
//			String passwordLoginString = passwordLogin.getUserPassword();
//			if(passwordLoginString.equals(passwordLoginString)) {
//				System.out.println("Login Successfully!");
//			}else {
//				System.out.println("Invalid Credentials!");
//			}
//			return null;
//		}catch (Exception e) {
//			if (e instanceof EntityNotFoundException) {
//				System.out.println("Invalid username/password!");
//			}
//		}
//		return null;
//	}
//	@GetMapping("/session")
//	public UserLogin loginUser (@RequestBody UserLogin userFromBrowser,@PathVariable(value="id") String userName, @PathVariable String userPassword) {
//	
//	String enteredUsername = userFromBrowser.getUserName();
//	String enteredPassword = userFromBrowser.getUserPassword();
//	try {
//		UserLogin findUsername = userLoginRepository.findById(enteredUsername).get();
//		String findUsernameString = findUsername.getUserName();
//		String findUserPasswordString = findUsername.getUserPassword();
//		
//		if(enteredUsername.equals(findUsernameString)) {
//			if(enteredPassword.equals(findUserPasswordString)) {
//				System.out.println("SUCCESS!");
//			}else {
//				System.out.println("INVALID CREDENTIALS!");
//			}
//		}else {
//			System.out.println("INVALID CREDENTIALS!");
//		}
//	}catch (Exception e) {
//		if (e instanceof EntityNotFoundException) {
//			System.out.println("Invalid username/password!");
//		}
//	}
//	return null;
//}
	@GetMapping("/session")
	public ResponseEntity<UserLogin> loginValidation(@RequestBody UserLogin loginListBrowser) {

		try {
			String userNameString = loginListBrowser.getUserName();
			String passString = loginListBrowser.getUserPassword();

			List<UserLogin> loginLists = userLoginRepository.findAll();

			for (UserLogin u : loginLists) {

				String userNameFoundString = u.getUserName().toString();

				if (userNameFoundString.equals(userNameString)) {

					UserLogin userIdFoundLong = userLoginRepository.findById(u.getUserID()).get();
					String passwordFoundString = userIdFoundLong.getUserPassword().toString();

					if (passwordFoundString.equals(passString)) {

						System.out.println("Login Successfully!");
						return null;

					} else {
						System.out.println("Incorrect Credentials!");
						return null;
					}
				}
			}
			return null;
		} catch (Exception e) {

			if (e instanceof EntityNotFoundException) {
				System.out.println("No Account Found! Register now?");
			}
			return null;
		}
	}
}