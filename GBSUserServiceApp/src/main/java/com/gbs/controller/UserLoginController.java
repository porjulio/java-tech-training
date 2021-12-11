package com.gbs.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gbs.entity.*;
import com.gbs.repository.*;

@RestController
@RequestMapping("/login")
public class UserLoginController {
	@Autowired
	UserLoginRepository userLoginRepository;

	@GetMapping("/session")
	public ResponseEntity<UserLogin> loginValidation(@RequestBody UserLogin loginListBrowser) {

		try {
			String userNameString = loginListBrowser.getUserName();
			String passString = loginListBrowser.getUserPassword();

			List<UserLogin> loginLists = userLoginRepository.findAll();

			for (UserLogin u : loginLists) {

				String userNameFoundString = u.getUserName().toString();

				if (userNameFoundString.equals(userNameString)) {

					UserLogin userIdFoundLong = userLoginRepository.findById(u.getUserName()).get();
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
//	@GetMapping("/userLoginResponse")
//	public UserLoginResponse getAllUserResponse() {
//		List<UserLogin> userList = userLoginRepository.findAll();
//		UserLoginResponse userResponse = new UserLoginResponse();
//		userResponse.setUserLogin(userList);
//		return userResponse;
//	}
//	
	
}