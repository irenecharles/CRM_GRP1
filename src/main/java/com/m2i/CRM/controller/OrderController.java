package com.m2i.CRM.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.javafaker.Faker;
import com.m2i.CRM.entity.Client;
import com.m2i.CRM.entity.Order;
import com.m2i.CRM.repository.OrderRepository;
import com.m2i.CRM.service.ClientService;
import com.m2i.CRM.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	
	@Autowired
	OrderService oService;
	
	@Autowired
	ClientService cService;
	
	@Autowired
	OrderRepository repo;
	
	
	@GetMapping
	public List<Order> findAll(){
		return oService.getAllOrders();
	}
	
	@GetMapping("/{id}")
	public Order findById(@PathVariable("id")int id) {
		return oService.getById(id);
	}
	
	@GetMapping("/allOrders/{page}/{nombre}")
	public Page<Order> getOrders(@PathVariable("page")int page, @PathVariable("nombre")int nombre) {
		return oService.findAllWithPagination(page, nombre);
	}
	
	@PostMapping
	public void createOrder(@RequestBody Order o) {
		oService.addOrder(o);
	}
	
	@PostMapping("/{id}")
	public void createOrder2(@RequestBody Order o, @PathVariable("id")int id) {
		Client c = cService.getById(id);
		o.setClient(c);
		oService.addOrder(o);
	}
	
	@PutMapping("/{id}")
	public void updateOrder(@PathVariable("id")int id, @RequestBody Order o) {
		o.setId(id);
		
		oService.updateOrder(o);
	}
	
	@DeleteMapping("/{id}")
	public void deleteOrder(@PathVariable("id")int id) {
		Order o = oService.getById(id);
		oService.deleteOrder(o);
	}
	
	@GetMapping("/fake/{number}")
	public void fakeOrder(@PathVariable("number")int nb) {
		Faker f = new Faker();
		List<Client> clients = cService.getAllClients();
		for (int i =0; i<nb; i++) {

			int nbClients = (int)(Math.random()*clients.size());
			
			Client c = clients.get(nbClients);
			Order o = new Order(f, c);			
			repo.save(o);
		}
		
	}

}
