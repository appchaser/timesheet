package com.bezkoder.springjwt.controllers;

import java.util.List;
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

import com.bezkoder.springjwt.models.Activity;
import com.bezkoder.springjwt.models.Client;
import com.bezkoder.springjwt.repository.ClientRepository;
import com.bezkoder.springjwt.service.ClientServiceImp;

import lombok.AllArgsConstructor;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/clients")
@AllArgsConstructor
public class ClientController {

	@Autowired
	ClientServiceImp clientServiceImp;
	@Autowired
	ClientRepository clientrepository ;

	@GetMapping("/{idClient}")
	@ResponseBody
	public ResponseEntity<?> getById(@PathVariable("idClient") long idClient) {
		return ResponseEntity.ok(clientServiceImp.getClientById(idClient));
	}
	@GetMapping("/project/{idcli}")
	@ResponseBody
	public ResponseEntity<?> getclientproject(@PathVariable("idcli") Long id ){
		return ResponseEntity.ok(clientServiceImp.getclientproject(id));
	}
	@GetMapping("/getAll")
	@ResponseBody
	public ResponseEntity<?> getAll() {
		List<Client> clients = clientServiceImp.getAll();
		return ResponseEntity.ok(clients);      
	}
        
	@PostMapping("/addClient")
	@ResponseBody
	public ResponseEntity<?> addclient(@RequestBody Client client) {
		return ResponseEntity.ok(clientServiceImp.addClient(client));		
	}

	@DeleteMapping("/deleteClient/{id}")
	@ResponseBody
	public ResponseEntity<?> deleteclient( @PathVariable Long id) {
		clientServiceImp.deleteClient(id);
		return ResponseEntity.ok("client Deleted");
	}
	
	/* 
	@DeleteMapping("/del/{id}")
	public  String  deleteclient (@PathVariable Long id){
		
	//	Optional<Client> c =   clientrepository.findById(id);
				
		clientrepository.deleteById(id);
		return "deleted client";
	}*/
	
	

	@PutMapping("/updateClient")
	public ResponseEntity<?> updateClient(@RequestBody Client client) {
		return ResponseEntity.ok(clientServiceImp.updateClient(client));

	}

	@PostMapping("/addclienttoproject/{idProject}/{idClient}")
	@ResponseBody
	public ResponseEntity<?> addClientToProject(@PathVariable("idProject") long idProject,
			@PathVariable("idClient") long idClient) {
		clientServiceImp.addProjectToClient(idClient, idProject);
		return ResponseEntity.ok("Done!project affect to client");
	}
}
