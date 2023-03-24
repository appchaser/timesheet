package com.bezkoder.springjwt.controllers;

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

import com.bezkoder.springjwt.models.timesheet;
import com.bezkoder.springjwt.service.TimeSheetServiceImp;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/timesheets")
public class TimeSheetController {
	
	@Autowired
	TimeSheetServiceImp timeSheetServiceImp;

	@GetMapping("/{idtimeSheet}")
	@ResponseBody
	public ResponseEntity<?> getById(@PathVariable("idtimeSheet") long idtimeSheet) {
		return ResponseEntity.ok(timeSheetServiceImp.getTimeSheetById(idtimeSheet));
	}
	
	@PostMapping("/addProjectToTimesheet/{idProject}/{idTimesheet}")
	@ResponseBody
	public ResponseEntity<?> addProjectToTimeSheet(@PathVariable("idProject") long idProject,@PathVariable("idTimesheet") long idTimesheet){
		
		return ResponseEntity.ok(timeSheetServiceImp.addProjectToTimesheet(idProject,idTimesheet));
	}
	@PostMapping("/adduserToTimesheet/{iduser}/{idTimesheet}")
	@ResponseBody
	public ResponseEntity<?> adduserToTimeSheet(@PathVariable("iduser") long iduser,@PathVariable("idTimesheet") long idTimesheet){
	
		return ResponseEntity.ok(timeSheetServiceImp.addTimeSheetToUser(iduser,idTimesheet));
	}
	
	@DeleteMapping("/timeshhet/{id}")
	public void deletetimesheet(@PathVariable("id") long id){
		 timeSheetServiceImp.delete(id);
	}

	@GetMapping("/all")
	@ResponseBody
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(timeSheetServiceImp.getAll());
	}

	@PostMapping("/addtimeSheet")
	@ResponseBody
	public ResponseEntity<?> addTimeSheet(@RequestBody timesheet timesheet) {
		return ResponseEntity.ok(timeSheetServiceImp.addTimeSheet(timesheet));
	}

	@PutMapping("/updatetimesheet")
	@ResponseBody
	public ResponseEntity<?> updateTimeSheet(@RequestBody timesheet timesheet) {
		return ResponseEntity.ok(timeSheetServiceImp.updateTimeSheet(timesheet));

	}

	@DeleteMapping("/deletetimesheet")
	@ResponseBody
	public ResponseEntity<?> deleteTimeSheet(@RequestBody timesheet timesheet) {
		timeSheetServiceImp.deleteTimeSheet(timesheet);
		return ResponseEntity.ok("Time Sheet Deleted");
	}
}
