package com.bezkoder.springjwt.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezcoder.springjwt.dto.ProjectDTO;
import com.bezcoder.springjwt.dto.UserDTO;
import com.bezkoder.springjwt.models.Activity;
import com.bezkoder.springjwt.models.Project;
import com.bezkoder.springjwt.repository.ProjectRepository;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class ProjectServiceImp {
	@Autowired
	private ProjectRepository projectRepository;
	/*@Autowired
	private ActivityServiceImp  activityServiceImp;*/


	public List<Project> getAll() {
		return projectRepository.findAll();
	}

	public Optional<Project> getProjectById(long id) {
		return projectRepository.findById(id);
	}
	
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

	public void deleteProject(Project project) {
		projectRepository.delete(project);
	}

	/*public void addActivityProject(long idActivity, long idProject) {
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
	}*/

}
