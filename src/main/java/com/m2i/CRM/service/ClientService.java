package com.m2i.CRM.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.m2i.CRM.entity.Client;
import com.m2i.CRM.entity.Order;
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
	
	public Page<Order> findAllWithPagination(int page, int nombre, int id){
		 Pageable pageable = PageRequest.of(page, nombre);
		 
		 return cRepo.findByOrderByClient(id, pageable);
			}
	
	public Client findByEmail(String email) {
		return cRepo.findByEmail(email);
	}

}
