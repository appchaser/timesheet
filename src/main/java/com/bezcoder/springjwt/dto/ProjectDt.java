package com.bezcoder.springjwt.dto;

import java.util.List;

public class ProjectDt {
	
	private Long id;
	private String name;
	private List<ActivityDto> activity;
	 
	
	public List<ActivityDto> getActivity() {
		return activity;
	}

	public void setActivity(List<ActivityDto> activity) {
		this.activity = activity;
	}

	

	public ProjectDt() {
		
	}

	public ProjectDt(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

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
	

}
