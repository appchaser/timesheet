package com.bezcoder.springjwt.dto;

public class ActivityDto {
	
	private Long id;
	private String name ;
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
	public ActivityDto(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	

}
