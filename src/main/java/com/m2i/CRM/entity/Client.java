package com.m2i.CRM.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.javafaker.Faker;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Client {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "client_id")
	private int id;
	
	@NotBlank
	private String companyName;
	
	@NotBlank
	private String firstName;
	
	@NotBlank
	private String lastName;
	
	@NotBlank
	@Column(unique = true)
	@Email
	private String email;
	
	@NotBlank
	@Column(unique = true)
	private String phone;
	
	@NotBlank
	private String address;
	
	@NotBlank
	private String zipCode;
	
	@NotBlank
	private String city;
	
	@NotBlank
	private String country;
	
	@NotNull
	@Range(min = 0, max = 1)
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
