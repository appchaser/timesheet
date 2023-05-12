package com.bezkoder.springjwt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.management.relation.Role;

import org.hibernate.mapping.Set;
import org.springframework.stereotype.Service;

import com.bezkoder.springjwt.models.Departement;
import com.bezkoder.springjwt.models.ERole;
import com.bezkoder.springjwt.models.Project;
import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.repository.DepartementRepository;
import com.bezkoder.springjwt.repository.ProjectRepository;
import com.bezkoder.springjwt.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service

public class UserServiceImp {
	private UserRepository userRepository;
	private ProjectServiceImp projectServiceImp;
	private DepartementRepository departementrepository;
	private DepartementService departementservice;
public UserServiceImp(UserRepository userRepository, DepartementService departementservice, ProjectServiceImp projectServiceImp, DepartementRepository departementrepository) {
	// TODO Auto-generated constructor stub
	this.projectServiceImp=projectServiceImp;
	this.userRepository=userRepository;
	this.departementrepository= departementrepository;
	this.departementservice= departementservice;
 }
	public List<User> getAll() {
		return userRepository.findAll();
	}

	public User addUser(User user) {
		return userRepository.save(user);
	}

	public User updateUser(User user) {
		return userRepository.save(user);
	}

	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}


	
	public Optional<User> getUserById(Long id) {
		return userRepository.findById(id);
	}

	public void addUserToProject(long idUser, long idProject) {
		User user = getUserById(idUser).orElse(null);
		Project project = projectServiceImp.getProjectById(idProject).orElse(null);
		List<Project> projects = user.getProjects();
		List<User> users = project.getUsers();
		projects.add(project);
		users.add(user);
		project.setUsers(users);
		user.setProjects(projects);
		this.updateUser(user);
		projectServiceImp.updateProject(project);
        
	}
	
	public void addUserToDepartment(int idDepartment,long idUser) {
		User usr = getUserById(idUser).orElse(null);
		Departement departement = departementservice.getDepartementById2(idDepartment).orElse(null);
		Departement departements = usr.getDepartement();
		List<User> usrs = departement.getUsers();
		
		usrs.add(usr);
		departement.setUsers(usrs);
		usr.setDepartement(departements);
		this.updateUser(usr);    
		departementservice.updateDepartement(departement);
		

	}

}
