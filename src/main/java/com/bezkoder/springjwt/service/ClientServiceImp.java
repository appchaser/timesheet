package com.bezkoder.springjwt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bezkoder.springjwt.models.Client;
import com.bezkoder.springjwt.models.Project;
import com.bezkoder.springjwt.repository.ClientRepository;
import com.bezkoder.springjwt.repository.ProjectRepository;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class ClientServiceImp  {
	private ClientRepository clientRepository;
	private ProjectServiceImp projectServiceImp;


	public List<Client> getAll() {
		return clientRepository.findAll();
	}

	public Optional<Client> getClientById(long id) {
		return clientRepository.findById(id);
	}

	public Client addClient(Client client) {
		return clientRepository.save(client);
	}

	public Client updateCliebt(Client client) {
		return clientRepository.save(client);
	}

	public void deleteClient(Client client) {
		clientRepository.delete(client);
	}

	public void addProjectToClient(long idClient, long idProject) {
		Client client = this.getClientById(idClient).orElse(null);
		Project project = projectServiceImp.getProjectById(idProject).orElse(null);
		List<Project> projects = client.getProjects();
		projects.add(project);
		this.updateCliebt(client);
		List<Client> clients = project.getClients();
		clients.add(client);
		projectServiceImp.updateProject(project);

	}
}