package com.m2i.CRM.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m2i.CRM.entity.Order;
import com.m2i.CRM.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository oRepo;
	
	public List<Order> getAllOrders(){
		return oRepo.findAll();
	}
	
	public Order getById(int id) {
		return oRepo.findById(id).orElse(null);
	}
	
	public void addOrder(Order order) {
		oRepo.save(order);
	}
	
	public void updateOrder(Order order) {
		oRepo.save(order);
	}
	
	public void deleteOrder(Order order) {
		oRepo.delete(order);
	}

}
