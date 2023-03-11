package com.bezkoder.springjwt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bezkoder.springjwt.models.timesheet;
import com.bezkoder.springjwt.repository.ProjectRepository;
import com.bezkoder.springjwt.repository.TimesheetRepository;

import lombok.AllArgsConstructor;
@Service

public class TimeSheetServiceImp {
	private TimesheetRepository timesheetRepository;
public TimeSheetServiceImp(TimesheetRepository timesheetRepository) {
	// TODO Auto-generated constructor stub
	this.timesheetRepository=timesheetRepository;
}

	public List<timesheet> getAll() {
		return timesheetRepository.findAll();
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
