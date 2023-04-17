package com.bezkoder.springjwt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.bezkoder.springjwt.models.Activity;
import com.bezkoder.springjwt.models.Client;
import com.bezkoder.springjwt.models.Project;
import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.models.timesheet;
import com.bezkoder.springjwt.repository.ActivityRepository;
import com.bezkoder.springjwt.repository.ClientRepository;
import com.bezkoder.springjwt.repository.ProjectRepository;
import com.bezkoder.springjwt.repository.TimesheetRepository;
import com.bezkoder.springjwt.repository.UserRepository;

import lombok.AllArgsConstructor;
@Service

public class TimeSheetServiceImp {
	private TimesheetRepository timesheetRepository;
	private UserRepository userRepository;
	private ProjectRepository projectRepository;
	private ClientRepository clientRepository;
	private ActivityRepository activityRepository;
public TimeSheetServiceImp(TimesheetRepository timesheetRepository,ProjectRepository projectRepository,UserRepository userRepository,
		ClientRepository clientRepository,ActivityRepository activityRepository ) {
	// TODO Auto-generated constructor stub
	this.timesheetRepository=timesheetRepository;
	this.projectRepository=projectRepository;
	this.userRepository=userRepository;
	this.activityRepository=activityRepository;
	this.clientRepository= clientRepository;
}

	public List<timesheet> getAll() {
		return timesheetRepository.findAll();
	}
	
	public timesheet addTimeSheetToUser(long iduser,long idTimesheet, long idproject,long idclient,long idactivity){
		timesheet timesheet=this.getTimeSheetById(idTimesheet).get();
		User user=userRepository.findById(iduser).get();
		Project project=projectRepository.findById(idproject).get();	
		Client client=clientRepository.findById(idclient).get();
		Activity activity= activityRepository.findById(idactivity).get();
		
		List<timesheet> list=user.getTimesheet();
		 /* list=project.getTimeSheets();*/
		  
		timesheet.setUser(user);
		timesheet.setProject(project);
		timesheet.setActivity(activity);  
		timesheet.setClient(client);
		list.add(timesheet); 
		user.setTimesheet(list);
		project.setTimeSheets(list);  	
		timesheetRepository.save(timesheet);
		userRepository.save(user);
		projectRepository.save(project);
		clientRepository.save(client);
		activityRepository.save(activity);
		return timesheet;
	}
	public timesheet addProjectToTimesheet(long idproject,long idTimesheet) {
		
		timesheet timesheet=this.getTimeSheetById(idTimesheet).get();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		User user = userRepository.findById(authentication.getName());
		User user = userRepository.findByUsername(authentication.getName()).get();
		
		Project project=projectRepository.findById(idproject).get();
		timesheet.setProject(project);
		timesheet.setUser(user);
		List<timesheet> list=project.getTimeSheets();
		list.add(timesheet);
		project.setTimeSheets(list);
		projectRepository.save(project);
		timesheetRepository.save(timesheet);
		return timesheet;
		
	}
	public Optional<timesheet> getTimeSheetById(long id) {
		
		return timesheetRepository.findById(id);
	}

	
	
	public timesheet addTimeSheet(timesheet timesheet, long idProject, long userId, long activityId, long clientId) {
		Project project = projectRepository.findById(idProject).get();
		User user = userRepository.findById(userId).get();
		Client client = clientRepository.findById(clientId).get();
		Activity activity = activityRepository.findById(activityId).get();
		timesheet.setProject(project);
		timesheet.setUser(user);
		timesheet.setActivity(activity);
		timesheet.setClient(client);
		return timesheetRepository.save(timesheet);
	}

	public timesheet updateTimeSheet(timesheet timesheet) {
		return timesheetRepository.save(timesheet);
	}
	
	public void delete (long id){
		timesheetRepository.deleteById(id);
	}

	public void deleteTimeSheet(timesheet timesheet) {
		timesheetRepository.delete(timesheet);
	}
}
