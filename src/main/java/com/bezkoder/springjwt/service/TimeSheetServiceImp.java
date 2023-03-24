package com.bezkoder.springjwt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.bezkoder.springjwt.models.Project;
import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.models.timesheet;
import com.bezkoder.springjwt.repository.ProjectRepository;
import com.bezkoder.springjwt.repository.TimesheetRepository;
import com.bezkoder.springjwt.repository.UserRepository;

import lombok.AllArgsConstructor;
@Service

public class TimeSheetServiceImp {
	private TimesheetRepository timesheetRepository;
	private UserRepository userRepository;
	private ProjectRepository projectRepository;
public TimeSheetServiceImp(TimesheetRepository timesheetRepository,ProjectRepository projectRepository,UserRepository userRepository ) {
	// TODO Auto-generated constructor stub
	this.timesheetRepository=timesheetRepository;
	this.projectRepository=projectRepository;
	this.userRepository=userRepository;
}

	public List<timesheet> getAll() {
		return timesheetRepository.findAll();
	}
	
	public timesheet addTimeSheetToUser(long iduser,long idTimesheet){
		timesheet timesheet=this.getTimeSheetById(idTimesheet).orElse(null);
		
		User user=userRepository.findById(iduser).orElse(null);
		List<timesheet> list=user.getTimesheet();
		timesheet.setUser(user);
		list.add(timesheet); 
		user.setTimesheet(list);
		timesheetRepository.save(timesheet);
		userRepository.save(user);
		return timesheet;
	}
	public timesheet addProjectToTimesheet(long idproject,long idTimesheet) {
		
		timesheet timesheet=this.getTimeSheetById(idTimesheet).get();
		Project project=projectRepository.findById(idproject).get();
		timesheet.setProject(project);
		List<timesheet> list=project.getTimesheets();
		list.add(timesheet);
		project.setTimesheets(list);
		projectRepository.save(project);
		timesheetRepository.save(timesheet);
		return timesheet;
		
	}
	public Optional<timesheet> getTimeSheetById(long id) {
		return timesheetRepository.findById(id);
	}

	
	
	public timesheet addTimeSheet(timesheet timesheet) {
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
