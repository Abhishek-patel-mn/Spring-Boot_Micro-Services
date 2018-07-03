package com.abhi.atm.userController;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abhi.atm.springBootConfiguration.UserProxy;
import com.abhi.atm.springSecurityConfiguration.User;

import net.sf.json.JSONObject;

@RestController
public class UserController {

	@Autowired
	UserProxy userProxy;

	@GetMapping("/public/getAllUsers")
	public ResponseEntity<String> publicUser() {
		JSONObject jsonResponse = new JSONObject();
		try {
			ResponseEntity<String> users = userProxy.getAllUsers();
			return users;
		} catch (Exception e) {
			jsonResponse.put("data", e.getMessage());
			return new ResponseEntity<String>(jsonResponse.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/public/registerUser")
	public ResponseEntity<String> registerUser(@Valid @RequestBody User user) {
		JSONObject jsonResponse = new JSONObject();
		try {
			ResponseEntity<String> response = userProxy.addUser(user);
			return response;
		} catch (Exception e) {
			jsonResponse.put("data", e.getMessage());
			return new ResponseEntity<String>(jsonResponse.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/public/changePassword")
	public ResponseEntity<String> changePassword(@Valid @RequestBody User user) {
		JSONObject jsonResponse = new JSONObject();
		try {
			ResponseEntity<String> response = userProxy.updateUser(user);
			return response;
		} catch (Exception e) {
			jsonResponse.put("data", e.getMessage());
			return new ResponseEntity<String>(jsonResponse.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
