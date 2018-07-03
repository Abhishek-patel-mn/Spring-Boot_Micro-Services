package com.abhi.atm.dao;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Abhishek Patel M N
 * Jan 17, 2018
 */

@Document
public class User {

	public User() {
		
	}
	
	public User(User user) {
		this.id = user.getId();
		this.userName = user.getUserName();
		this.password = user.getPassword();
		this.phoneNumber = this.getPhoneNumber();
		this.email = this.getEmail();
		this.createdDate = user.getCreatedDate();
		this.role = user.getRole();
	}
	
	private String id;
	
	@NotNull
	private String userName;
	
	@NotNull
	private String password;
	
	private String email;
	
	private int phoneNumber;
	
	private Date createdDate;

	private Role role;

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String Id) {
		this.id = Id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
