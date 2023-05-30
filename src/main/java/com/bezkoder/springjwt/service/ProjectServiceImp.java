package com.bezkoder.springjwt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezcoder.springjwt.dto.ActivityDto;
import com.bezcoder.springjwt.dto.ClientD;
import com.bezcoder.springjwt.dto.ProjectD;
import com.bezcoder.springjwt.dto.ProjectDTO;
import com.bezcoder.springjwt.dto.ProjectDt;
import com.bezcoder.springjwt.dto.UserDTO;
import com.bezkoder.springjwt.models.Activity;
import com.bezkoder.springjwt.models.Project;
import com.bezkoder.springjwt.repository.ProjectRepository;

import ch.qos.logback.core.net.server.Client;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class ProjectServiceImp {
	@Autowired
	private ProjectRepository projectRepository;
	@Autowired
	private ActivityServiceImp  activityServiceImp;


	public ProjectDt getprojectactivity(Long id){
		Project project = projectRepository.findById(id).get();
		ProjectDt projectDt= new ProjectDt();
		
		projectDt.setId(id);
		projectDt.setName(project.getName());
		projectDt.setActivity(project.getActivities().stream().map(e-> new ActivityDto(e.getId(), e.getShortName()
				)).collect(Collectors.toList()));
		
		
		return projectDt;
	}
	
	public List<Project> getAll() {
		return projectRepository.findAll();
	}
	
	public List<ProjectD> getAllProjectClient() {
		List<Project> ls = projectRepository.findAll();
		List<ProjectD> listDto = new ArrayList<>();
		
		for(int i=0; i<ls.size(); i++){
			ProjectD projectD = new ProjectD();
			projectD.setId(ls.get(i).getId());
			projectD.setName(ls.get(i).getName());
			projectD.setEndDate(ls.get(i).getEndDate());
			projectD.setStartDate(ls.get(i).getStartDate());
			projectD.setActivity(ls.get(i).getActivities().stream().map(e-> new ActivityDto(e.getId(), e.getShortName()
				)).collect(Collectors.toList()));
			projectD.setClient(ls.get(i).getClients().stream().map(e-> new ClientD(e.getId(), e.getName()
				)).collect(Collectors.toList()));
			
			listDto.add(projectD);
		}
		return listDto;
	}
     
	public Optional<Project> getProjectById(long id) {
		
		return projectRepository.findById(id);
	}
	
	public ProjectD getProjectClients(Long id){
		
		Project project = projectRepository.findById(id).get();
		ProjectD projectD= new ProjectD();
		
		projectD.setId(id);
		projectD.setName(project.getName());
		projectD.setActivity(project.getActivities().stream().map(e-> new ActivityDto(e.getId(), e.getShortName()
				)).collect(Collectors.toList()));
		projectD.setClient(project.getClients().stream().map(e-> new ClientD(e.getId(), e.getName()
				)).collect(Collectors.toList()));
		projectD.setEndDate(project.getEndDate());
		projectD.setStartDate(project.getStartDate());
		
		return projectD;
		
	}
		/* public Project findProjectById(long projectId) {
	}
	        Optional<Project> optionalProject = projectRepository.findById(projectId);
	        if (optionalProject.isPresent()) {
	            Project project = optionalProject.get();
	            List<Client> clients = project.getClients();
	            project.setClients(clients);
	            // Do something with the list of clients
	            
	            return project;
	        } else {
	            throw new NotFoundException("Project not found");
	        }
	    }*/
	
	public ProjectDTO getproject(long id){
		Project proj= projectRepository.findById(id).get();
		ProjectDTO projdto= new ProjectDTO();
		
		projdto.setUsers(proj.getUsers().stream()
				.map(e-> new UserDTO(e.getUsername(), e.getEmail(),e.getRoles())).collect(Collectors.toList()));
		        
		projdto.setProjectname(proj.getName()); 
		projdto.setId(proj.getId());
		return projdto;
	}

	public Project addProject(Project project) {
		return projectRepository.save(project);
	}

	public Project updateProject(Project project) {
		return projectRepository.save(project);
	}

	public void deleteProject(Long id) {
		projectRepository.deleteById(id);
	}

	public void addActivityProject(long idActivity, long idProject) {
		Project project = this.getProjectById(idProject).orElse(null);
		
		Activity activity = activityServiceImp.getActivityById(idActivity).orElse(null);
		List<Project> projects = activity.getProjects();
		projects.add(project);
		activity.setProjects(projects);
		activityServiceImp.updateActivity(activity);
		List<Activity> activities = project.getActivities();
		activities.add(activity);
		project.setActivities(activities);
		this.updateProject(project);
	}

}
