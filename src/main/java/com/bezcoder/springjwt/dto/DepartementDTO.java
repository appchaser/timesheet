package com.bezcoder.springjwt.dto;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;

import com.bezkoder.springjwt.models.ERole;
import com.bezkoder.springjwt.models.Role;
import com.bezkoder.springjwt.models.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor

@ToString
public class DepartementDTO {
	
	private int id;
	private String departname;

	
	private List<UserDTO> users;
	
	public void setId(int id) {
		this.id = id;
	}
	public void setDepartname(String departname) {
		this.departname = departname;
	}
	public void setUsers(List<UserDTO> users) {
		this.users = users;    
	}
	
	

	
	
	

}
