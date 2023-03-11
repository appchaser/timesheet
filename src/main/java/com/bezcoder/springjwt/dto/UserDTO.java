package com.bezcoder.springjwt.dto;

import java.util.List;
import java.util.Set;

import com.bezkoder.springjwt.models.Role;

public class UserDTO {

	
	private String username;
	private String mail;
	 private Set<Role> roles;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public UserDTO(String username, String mail, Set<Role> set) {
		super();
		this.username = username;
		this.mail = mail;
		this.roles = set;
	}
	 
	 
	
	 
	 
}
