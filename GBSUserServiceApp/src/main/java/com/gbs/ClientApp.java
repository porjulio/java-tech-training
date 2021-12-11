//package com.gbs;
//
//import org.springframework.web.client.RestTemplate;
//
//import com.gbs.entity.UserLoginResponse;
//
//public class ClientApp {
//	public static void main(String args[]) {
//		RestTemplate usersRestTemplate = new RestTemplate();
//		final String restApiURLString = "http://localhost:8081/ecz/login/userLoginResponse";
//		UserLoginResponse userLoginResponse  = usersRestTemplate.getForObject(restApiURLString, UserLoginResponse.class);
//	}
//}
