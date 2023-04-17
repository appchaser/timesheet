package com.bezkoder.springjwt.models;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class timesheet implements Serializable {

	 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Temporal(TemporalType.DATE)
	private Date date1_day;
	
	private float date1_hours;
	  
	  @Temporal(TemporalType.DATE) private Date date2_day;
	  
	  @Nullable private float date2_hours;
	  
	
	  
	  @Temporal(TemporalType.DATE) private Date date3_day;
	  
	  @Nullable private float date3_hours;
	  
	 
	  
	  @Temporal(TemporalType.DATE) private Date date4_day;
	                      
	   private float date4_hours;
	  
	  @Temporal(TemporalType.DATE)
	  
	   private Date date5_day;
	  
	   private float date5_hours;
	  
	  @Temporal(TemporalType.DATE)
	  
	 private Date date6_day;
	  
	   private float date6_hours;
	  
	  @Temporal(TemporalType.DATE)
	  
	   private Date date7_day;
	  
	   private float date7_hours;
	 
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Project project;
	@Nullable
	@ManyToOne
	@JoinColumn(name = "activity_id")
	private Activity activity;
	
	@Nullable
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;

	@ManyToOne(cascade = CascadeType.ALL)

	private User user;

}
