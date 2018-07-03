package com.abhi.atm.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abhi.atm.dao.User;
import com.abhi.atm.dto.UserDto;
import com.abhi.atm.service.UserMgmtService;

import net.sf.json.JSONObject;

/**
 * @author Abhishek Patel M N Jan 17, 2018
 */
@RestController
public class UserController {

	@Autowired
	UserMgmtService userMgmtService;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@PostMapping(value = { "/secured/users", "/rest/users", "/public/users" })
	public ResponseEntity<String> addUser(@Valid @RequestBody User user) {
		JSONObject jsonResponse = new JSONObject();
		String data = "";
		try {
			userMgmtService.addUser(user);
			data = "User " + user.getUserName() + " added successfully";
			jsonResponse.put("data", data);
			return new ResponseEntity<String>(jsonResponse.toString(), HttpStatus.OK);
		} catch (Exception e) {
			jsonResponse.put("data", e.getMessage());
			return new ResponseEntity<String>(jsonResponse.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = { "/secured/users", "/rest/users", "/public/users" })
	public ResponseEntity<String> getAllUsers() {
		logger.info("Inside get all methods..");
		JSONObject jsonResponse = new JSONObject();
		try {
			List<UserDto> users = userMgmtService.getAllUsers();
			jsonResponse.put("data", users);
			return new ResponseEntity<String>(jsonResponse.toString(), HttpStatus.OK);
		} catch (Exception e) {
			jsonResponse.put("data", e.getMessage());
			return new ResponseEntity<String>(jsonResponse.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = { "/secured/users/{userId}", "/rest/users/{userId}" })
	public ResponseEntity<String> getUserByUserId(@Valid @PathVariable(name = "userId") Integer userId) {
		JSONObject jsonResponse = new JSONObject();
		try {
			UserDto user = userMgmtService.getUserByUserId(userId);
			jsonResponse.put("data", user);
			return new ResponseEntity<String>(jsonResponse.toString(), HttpStatus.OK);
		} catch (Exception e) {
			jsonResponse.put("data", e.getMessage());
			return new ResponseEntity<String>(jsonResponse.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping(value = "/secured/users/{userId}")
	public ResponseEntity<String> deleteUser(@Valid @PathVariable(name = "userId") Integer userId) {
		JSONObject jsonResponse = new JSONObject();
		try {
			userMgmtService.deleteUser(userId);
			jsonResponse.put("data", "User " + userId + " deleted successfully");
			return new ResponseEntity<String>(jsonResponse.toString(), HttpStatus.OK);
		} catch (Exception e) {
			jsonResponse.put("data", e.getMessage());
			return new ResponseEntity<String>(jsonResponse.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping(value ="/secured/users")
	public ResponseEntity<String> updateUser(@RequestBody User user) {
		JSONObject jsonResponse = new JSONObject();
		try {
			userMgmtService.updateUser(user);
			jsonResponse.put("data", "User " + user.getUserName() + " updated successfully");
			return new ResponseEntity<String>(jsonResponse.toString(), HttpStatus.OK);
		} catch (Exception e) {
			jsonResponse.put("data", e.getMessage());
			return new ResponseEntity<String>(jsonResponse.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
