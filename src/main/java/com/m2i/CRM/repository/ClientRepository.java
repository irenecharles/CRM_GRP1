package com.m2i.CRM.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.m2i.CRM.entity.Client;
import com.m2i.CRM.entity.Order;

public interface ClientRepository extends JpaRepository<Client, Integer>{
	@Query(value = "SELECT o FROM Order o WHERE client_id= ?1")
	Page<Order> findByOrderByClient(int id, Pageable p);
	Client findByEmail(String email);

}
