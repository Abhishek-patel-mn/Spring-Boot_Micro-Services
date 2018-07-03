package com.abhi.atm.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

/**
 * @author Abhishek Patel M N Aug 13, 2017 7:51:28 PM 2017
 */
public class UserDto {

	private String id;
	@NotNull
	private String userName;
	@NotNull
	private String password;
	private String email;
	private int phoneNumber;
	private Date createdDate;
	private RoleDto role;

	public String getId() {
		return id;
	}

	public void setID(String id) {
		this.id = id;
	}

	public RoleDto getRole() {
		return role;
	}

	public void setRole(RoleDto role) {
		this.role = role;
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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
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
}
