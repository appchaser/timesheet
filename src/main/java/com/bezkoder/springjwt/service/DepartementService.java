package com.bezkoder.springjwt.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.management.j2ee.statistics.JavaMailStats;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezcoder.springjwt.dto.DepartementDTO;
import com.bezcoder.springjwt.dto.UserDTO;
import com.bezkoder.springjwt.models.Departement;
import com.bezkoder.springjwt.models.Role;

import com.bezkoder.springjwt.repository.DepartementRepository;
import com.bezkoder.springjwt.repository.ProjectRepository;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class DepartementService {
	@Autowired
	private DepartementRepository departementRepository;
	
	//private JavaMailStats mailsender;

	public List<Departement> getAll() {
		return departementRepository.findAll();
	}

	public DepartementDTO getDepartementById(int id){
		Departement dep = departementRepository.findById(id).get();
		DepartementDTO depDto = new DepartementDTO();
       
       depDto.setUsers(dep.getUsers().stream()
		.map(e-> new UserDTO(e.getUsername(), e.getEmail(),e.getRoles())).collect(Collectors.toList()));
   
       
		depDto.setDepartname(dep.getName());
		depDto.setId(dep.getId());
		
		return depDto;  
		}
	
	
	
	
	public Optional<Departement> getDepartementById2(int id) {
	
	return departementRepository.findById(id);
	}
			
		
	
	

	public Departement addDepartement(Departement departement) {
		return departementRepository.save(departement);
	}

	public Departement updateDepartement(Departement departement) {
		return departementRepository.save(departement);
	}

	public void deleteDepartement(Departement departement) {
		departementRepository.delete(departement);
	}
}
