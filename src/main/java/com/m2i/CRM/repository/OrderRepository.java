package com.m2i.CRM.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.m2i.CRM.entity.Client;
import com.m2i.CRM.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{
	
	Page<Order> findAll(Pageable p);
	
	List<Order> findByClient(Client c);
	
}
