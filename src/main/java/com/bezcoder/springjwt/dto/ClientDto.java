package com.bezcoder.springjwt.dto;

import java.util.List;

public class ClientDto {
	
	public Long id;
	public String name;
	
	private List<ProjectDt> projects;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ProjectDt> getProjects() {
		return projects;
	}

	public void setProjects(List<ProjectDt> projects) {
		this.projects = projects;
	}
	
	

}
