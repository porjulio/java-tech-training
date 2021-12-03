package dem.UserController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dem.UserInfo.UserInfo;
import dem.UserRepository.UserRepository;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/welcome")
	protected String welcome() {
		System.out.print("Welcome to the world of Spring Boot! Awyizz!");
		return "<html><head><title>Users Tab</title></head><body><h1>Welcome to the world of springboot............</h1></body></html>";
	}
	
	@GetMapping("/usersAsHTML")
	protected String getAllUsersAsHtml() {
		List<UserInfo> userInfoList = userRepository.findAll();
		String usersHTML = "<html><head><title>Display Users Information</title>"
				+ "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\r\n" + 
				"    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\r\n" + 
				"    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\"></script>\r\n" + 
				"    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script></head><body><h1>Users Information Page</h1>";
		usersHTML +=	"<table class=\"table table-dark table-striped\" style = \"width:500px\"><tr><td>User ID</td>\"\r\n"
				+ "								 \"<th>User Name</th>\"\r\n"
				+ "								 \"<th>Creation Date</th>\"\r\n"
				+ "								 \"<th>Number of Accounts</th>\"\r\n"
				+ "								 \"<th>Account Number</th>\"\r\n"
				+ "								 \"<th>Total Balance</th>\"\r\n"
				+ "							     \"<th>Contact Number</th></tr>";
		for(UserInfo user : userInfoList) {
			usersHTML += "<tr><td>"+ user.getuserId()+ "</td><td>" + user.getUserNameString() + "</td><td>" + user.getUserPassword() + "</td><td>" + user.getCreationDateString() + "</td>"
					+ "<td>" + user.getNumberOfAccounts() + "</td><td>" + user.getAccountNumberString() + "</td><td>" + user.getTotalBalance() + "</td><td>" + user.getContactNumber() + "</td></tr>";
		}
		usersHTML +=	 "</table></body></html>";
		return usersHTML;
	}
	//get all the users
	@GetMapping("/users")
	public List<UserInfo> getAllUsers() {
		List<UserInfo> userInfoList = userRepository.findAll();
		return userInfoList;
	}
	// create a new user
	@PostMapping("/users")
	public UserInfo createUser(@RequestBody UserInfo userFromBrowser) {
		System.out.println("Creating : " + userFromBrowser);
		UserInfo savedUser = userRepository.save(userFromBrowser);
		return savedUser;
	}
	
	//update existing user
	@PutMapping("/users/{id}")
	public UserInfo updateUSer(@PathVariable(value="id") Long userID, @RequestBody UserInfo userFromBrowser)
	{
		System.out.println("Updating : " + userFromBrowser);
		UserInfo existingUser = userRepository.findById(userID).get();
		existingUser.setContactNumber(getAllUsersAsHtml());
		existingUser.setTotalBalance(null);
		UserInfo updatedUser = userRepository.save(existingUser);
		return updatedUser;
	}
	
	//delete an existing user
	@DeleteMapping("users/{userIdFromBrowser}")
		public void deleteUser(@PathVariable(value="productIdFromBrowser")Long userId)
		{
			System.out.println("Deleting : " + userId);
			userRepository.deleteById(userId);
		}
}
