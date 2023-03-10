package com.m2i.CRM.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.javafaker.Faker;
import com.m2i.CRM.entity.Client;
import com.m2i.CRM.entity.Order;
import com.m2i.CRM.repository.ClientRepository;
import com.m2i.CRM.repository.OrderRepository;
import com.m2i.CRM.service.ClientService;
import com.m2i.CRM.service.OrderService;

@RestController
@RequestMapping("/client")
public class ClientController {
	
	@Autowired
	ClientService cService;
	
	@Autowired
	ClientRepository repo;
	
	@Autowired
	OrderRepository oRepo;
	
	@Autowired
	OrderService oService;
	
	@GetMapping
	public List<Client> findAll(){
		return cService.getAllClients();
	}
	
	@GetMapping("/{id}")
	public Client findById(@PathVariable("id")int id) {
		return cService.getById(id);
	}
	
	@GetMapping("/{id}/allOrders/{page}/{nombre}")
	public Page<Order> getOrderByClient(@PathVariable("page")int page, @PathVariable("nombre")int nombre, @PathVariable("id")int id) {
		return cService.findAllWithPagination(page, nombre, id);
	}
	
	@GetMapping("/email")
	public Client getClientByEmail(@RequestParam("mail") String mail) {
		return cService.findByEmail(mail);
	}
	
	@PostMapping
	public void createClient(@RequestBody Client c) {
		cService.addClient(c);
	}
	
	@PutMapping("/{id}")
	public void updateClient(@PathVariable("id")int id, @RequestBody Client c) {
		c.setId(id);
		cService.updateClient(c);
	}
	
	@DeleteMapping("/{id}")
	public void deleteClient(@PathVariable("id")int id) {	
		Client c = cService.getById(id);
		List<Order> orders = oRepo.findByClient(c);
		for(Order o : orders) {
			oService.deleteOrder(o);
		}
		cService.deleteClient(c);
	}
	
	@GetMapping("/fake/{number}")
	public void fakeClient(@PathVariable("number")int nb) {
		Faker f = new Faker();
		for (int i =0; i<nb; i++) {			
			Client c = new Client(f);			
			repo.save(c);
		}
		
	}

}
