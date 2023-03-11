package com.bezkoder.springjwt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bezkoder.springjwt.models.Activity;
import com.bezkoder.springjwt.repository.ActivityRepository;
import com.bezkoder.springjwt.repository.ProjectRepository;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class ActivityServiceImp  {
	private ActivityRepository activityRepository;


	
	public List<Activity> getAll(){
		return activityRepository.findAll();
	}
	public Optional<Activity> getActivityById(long id) {
		return activityRepository.findById(id);
	}
	public Activity addActivity(Activity activity) {
		return activityRepository.save(activity);
	}
	public Activity updateActivity(Activity activity) {
		return activityRepository.save(activity);
	}
	public void deleteActivity(Activity activity) {
		activityRepository.delete(activity);
	}
	
}
