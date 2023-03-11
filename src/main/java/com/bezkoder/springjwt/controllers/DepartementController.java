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
import com.bezkoder.springjwt.models.Departement;
import com.bezkoder.springjwt.service.DepartementService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/departements")
public class DepartementController {
	
	@Autowired
	 DepartementService departementService;

	@GetMapping("/find/{idDepar}")
	@ResponseBody
	public ResponseEntity<?> getById(@PathVariable("idDepar")int idDepar){
		return ResponseEntity.ok(departementService.getDepartementById2(idDepar));
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<DepartementDTO> getDepByID(@PathVariable("id") int id){
		DepartementDTO dep = departementService.getDepartementById(id);
		
		return new ResponseEntity<DepartementDTO>(dep, HttpStatus.OK);
	
		}
	
	@GetMapping("/all")
	@ResponseBody
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(departementService.getAll());
	}
	@PostMapping("/addDepartement")
	@ResponseBody
	public ResponseEntity<?> addDepartement(@RequestBody Departement departement){
		return ResponseEntity.ok(departementService.addDepartement(departement));
	}
	@PutMapping("/updateDepartement")
	@ResponseBody
	public ResponseEntity<?> updateDepartement(@RequestBody Departement departement){
		return ResponseEntity.ok(departementService.updateDepartement(departement));
	}
	@DeleteMapping("deleteDepartement")
	@ResponseBody
	public ResponseEntity<?> deleteDepartement(@RequestBody Departement departement){
		departementService.deleteDepartement(departement);
		return ResponseEntity.ok("departement Deleted");
	}
	
	
}
