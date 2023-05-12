package com.bezkoder.springjwt.controllers;

import java.util.Optional;

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

import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.repository.UserRepository;
import com.bezkoder.springjwt.service.UserServiceImp;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	 UserServiceImp userServiceImp;
	@Autowired
	UserRepository userrepo;

	@GetMapping("/usr/{idUser}")
	@ResponseBody
	public ResponseEntity<?> getById(@PathVariable("idUser") long idUser){
		return ResponseEntity.ok(userServiceImp.getUserById(idUser));
	}
	@GetMapping("/all")
	@ResponseBody
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(userServiceImp.getAll());
	}
	@PostMapping("/adduser")
	@ResponseBody
	public ResponseEntity<?> addUser(@RequestBody User user){
		return ResponseEntity.ok(userServiceImp.addUser(user));
	}
	
	@GetMapping("/{iduser}")
	@ResponseBody
	public ResponseEntity<?> getProjectById(@PathVariable("idProject") long idProject) {
		return ResponseEntity.ok(userServiceImp.getUserById(idProject));
	}
	/*@GetMapping("/admin/{iddep}")
	@ResponseBody
	public ResponseEntity<?> getEmailsOfAdminUser(@PathVariable("idProject") int iddep) {
		return ResponseEntity.ok(userServiceImp.getEmailsOfAdminUsers(iddep));
	}*/
	
	/*@GetMapping("depr/{id}")
	@ResponseBody
	public ResponseEntity<?> findAdmin( @PathVariable ("id") long id ){
		
		return ResponseEntity.ok(userrepo.findAdminDepartment(id));
	}*/
	
	@PutMapping("/updateuser")
	@ResponseBody
	public ResponseEntity<?> updateUser(@RequestBody User user){
		return ResponseEntity.ok(userServiceImp.updateUser(user));
	}
	
	@DeleteMapping("/deleteUser/{id}")
	@ResponseBody
	public ResponseEntity<?> deleteUser(@PathVariable Long id){
		userServiceImp.deleteUser(id);
		return ResponseEntity.ok("User deleted");
	}
	@PostMapping("/addusertoproject/{idUser}/{idProject}")
	@ResponseBody
	public ResponseEntity<?> addClientToProject(@PathVariable("idProject") long idProject,
			@PathVariable("idUser") long idUser) {
		userServiceImp.addUserToProject(idUser, idProject);
		return ResponseEntity.ok("Done!!");
	}
	
	@PostMapping("/addusertodepartment/{iddepart}/{idUser}")
	@ResponseBody
	public ResponseEntity<?> addUserToDepartment(@PathVariable("iddepart")int iddepart,
			@PathVariable("idUser") long idUser ){    
		userServiceImp.addUserToDepartment(iddepart,idUser);
		return ResponseEntity.ok("affected");
	}
	
}
