package com.bezkoder.springjwt.controllers;

import java.util.Optional;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.springjwt.models.Activity;
import com.bezkoder.springjwt.service.ActivityServiceImp;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/activities")
public class ActivityController {
	
	@Autowired
	 ActivityServiceImp activityServiceImp;


	
	@GetMapping("/{idActivity}")
	@ResponseBody
	public ResponseEntity<?> getbyId(@PathVariable("idActivity") long idActivity){
		return ResponseEntity.ok(activityServiceImp.getActivityById(idActivity));
	}
	@GetMapping("/getAll")
	@ResponseBody
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(activityServiceImp.getAll());
	}
	@PostMapping("/addActivity")
	@ResponseBody
	public ResponseEntity<?> addActivity(@RequestBody Activity activity){
		return ResponseEntity.ok(activityServiceImp.addActivity(activity));
	}
	@DeleteMapping("/deleteActivity/{id}")
	@ResponseBody
	public ResponseEntity<?> deleteActivity(Activity activity){
		activityServiceImp.deleteActivity(activity);
		return ResponseEntity.ok("activity Deleted");
	}
	@PutMapping("/updateActivity")
	public ResponseEntity<?> updateActivity(Activity activity){
		return ResponseEntity.ok(activityServiceImp.updateActivity(activity));

	}
	

}
