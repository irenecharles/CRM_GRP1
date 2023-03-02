package com.m2i.CRM.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m2i.CRM.entity.Client;
import com.m2i.CRM.repository.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	ClientRepository cRepo;
	
	public List<Client> getAllClients(){
		return cRepo.findAll();
	}
	
	public Client getById(int id) {
		return cRepo.findById(id).orElse(null);
	}
	
	public void addClient(Client client) {
		cRepo.save(client);
	}
	
	public void updateClient(Client client) {
		cRepo.save(client);
	}
	
	public void deleteClient(Client client) {
		cRepo.delete(client);
	}

}
