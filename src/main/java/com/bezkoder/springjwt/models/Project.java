package com.bezkoder.springjwt.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
//@NoArgsConstructor
@Entity
@ToString
public class Project implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;
	
	private Date startDate;
	
	private Date endDate;  
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL,  fetch = FetchType.LAZY)
	private List<User> users;   
	
	
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY) 
	private List<Client> clients;     
	@JsonIgnore      
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Activity> activities;
	@JsonIgnore
	@ElementCollection()
	private List<timesheet> timesheets;
	  public Project() {
	        timesheets = new ArrayList<>(); 
	    }

	    public void addTimeSheet(timesheet timeSheet) {
	        timesheets.add(timeSheet);
	    }
         
	    public List<timesheet> getTimeSheets() {
	        return timesheets;
	    }
	    public List<Client> getClients() {
	        return clients;
	    }
	    public void setClients(List<Client> clients){
	    	this.clients=clients;
	    }
	    public void addClient(Client client){
	    	clients.add(client);
	    }

	    public void setTimeSheets(List<timesheet> timeSheets) {
	        this.timesheets = timeSheets;
	    }
}
