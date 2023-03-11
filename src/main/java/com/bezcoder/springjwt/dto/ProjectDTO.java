package com.bezcoder.springjwt.dto;

import java.util.List;

public class ProjectDTO {
	
	private Long id;
	
	private String projectname;
	
	private List<UserDTO> users;

	public String getProjectname() {
		return projectname;
	}

	public void setProjectname(String project) {
		this.projectname = project;
	}

	public List<UserDTO> getUsers() {
		return users;
	}

	public void setUsers(List<UserDTO> users) {
		this.users = users;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

}
