package com.bezkoder.springjwt.models;

import java.util.List;
import javax.persistence.JoinColumn;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;

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
public class Departement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String name;
@Autowired
@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
@JoinTable(
		  name = "departement_users", 
		  joinColumns = @JoinColumn(name = "departement_id"), 
		  inverseJoinColumns = @JoinColumn(name = "user_id"))

private List<User> users;



}
