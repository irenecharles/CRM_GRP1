package com.m2i.CRM.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.github.javafaker.Faker;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Client {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "client_id")
	private int id;
	
	private String companyName;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String phone;
	
	private String address;
	
	private String zipCode;
	
	private String city;
	
	private String country;
	
	private int state;

	public Client(Faker f) {

		this.companyName = f.company().name();
		this.firstName = f.name().firstName();
		this.lastName = f.name().lastName();
		this.email = f.internet().emailAddress();
		this.phone = f.phoneNumber().phoneNumber();
		this.address = f.address().streetAddress();
		this.zipCode = f.address().zipCode();
		this.city = f.address().city();
		this.country = f.address().country();
		this.state = f.number().numberBetween(0, 1);
	}
	
	
	
	}
