package com.bezkoder.springjwt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.bezcoder.springjwt.dto.DepartementDTO;
import com.bezcoder.springjwt.dto.ProjectDTO;
import com.bezkoder.springjwt.models.Project;
import com.bezkoder.springjwt.service.ProjectServiceImp;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/projects")
public class ProjectController {

	@Autowired
	ProjectServiceImp projectServiceImp;

	@GetMapping("/{idProject}")
	@ResponseBody
	public ResponseEntity<?> getProjectById(@PathVariable("idProject") long idProject) {
		return ResponseEntity.ok(projectServiceImp.getProjectById(idProject));
	}

	@GetMapping("/get/{id}")
	@ResponseBody
	public ResponseEntity<ProjectDTO> getProjByID(@PathVariable("id") int id){
		ProjectDTO dep = projectServiceImp.getproject(id);
		                  
		return new ResponseEntity<ProjectDTO>(dep, HttpStatus.OK);
	     
		}
	
	@GetMapping("/all")
	@ResponseBody
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(projectServiceImp.getAll());
	}

	@PostMapping("/addproject")
	@ResponseBody
	public ResponseEntity<?> addProject(@RequestBody Project project) {
		return ResponseEntity.ok(projectServiceImp.addProject(project));
	}

	@PutMapping("/updateproject")
	@ResponseBody
	public ResponseEntity<?> updateProject(@RequestBody Project project) {
		return ResponseEntity.ok(projectServiceImp.updateProject(project));
	}

	@DeleteMapping("/deleteproject")
	@ResponseBody
	public ResponseEntity<?> deleteProject(@RequestBody Project project) {
		projectServiceImp.deleteProject(project);
		return ResponseEntity.ok("project deleted");
	}

/*	@PostMapping("/addactivitytoproject/{idProject}/{idActivity}")
	@ResponseBody
	public ResponseEntity<?> addClientToProject(@PathVariable("idProject") long idProject,
			@PathVariable("idActivity") long idActivity) {
		projectServiceImp.addActivityProject(idActivity, idProject);
		return ResponseEntity.ok("Done!!");
	}*/
}
