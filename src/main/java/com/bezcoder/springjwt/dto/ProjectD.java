package com.bezcoder.springjwt.dto;

import java.util.Date;
import java.util.List;

public class ProjectD {
	
	private Long id;
	private String name;
	private List<ActivityDto> activity;
	private List<ClientD> client;
	private Date startDate;
	private Date endDate;
	
	public ProjectD(){
		
	}
	
	
	public ProjectD(Long id, String name, List<ActivityDto> activity, List<ClientD> client, Date startDate,
			Date endDate) {
		super();
		this.id = id;
		this.name = name;
		this.activity = activity;
		this.client = client;
		this.startDate = startDate;
		this.endDate = endDate;
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
	public List<ActivityDto> getActivity() {
		return activity;
	}
	public void setActivity(List<ActivityDto> activity) {
		this.activity = activity;
	}
	public List<ClientD> getClient() {
		return client;
	}
	public void setClient(List<ClientD> client) {
		this.client = client;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	

}
