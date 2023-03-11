package com.bezkoder.springjwt.models;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
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
@NoArgsConstructor
@Entity
@ToString
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;
	@JsonIgnore
	private Date startDate;
	@JsonIgnore
	private Date endDate;
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL,  fetch = FetchType.LAZY)
	private List<User> users;   
	@JsonIgnore
	@OneToMany(cascade =CascadeType.ALL,fetch = FetchType.LAZY)
	private List<timesheet> timesheets;
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY) 
	private List<Client> clients;     
	/*@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Activity> activities;*/
}
