package com.m2i.CRM.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.javafaker.Faker;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
public class Order {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_order")
	private int id;
	
	@NotBlank
	private String typePresta;
	
	@NotBlank
	private String designation;
	
	@Positive
	private int nbDays;
	
	@Positive
	private float unitPrice;
	
	@NotNull
	@Range(min = 0, max = 2)
	private int state;
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	@NotNull
	private Client client;

	public Order(Faker f, Client client) {

		this.typePresta = f.job().field();
		this.designation = f.job().keySkills();
		this.nbDays = f.number().numberBetween(1, 30);
		this.unitPrice = (float) f.number().randomDouble(2, 0, 100000);
		this.state = f.number().numberBetween(0, 2);
		this.client = client;
	}
	
	

}
