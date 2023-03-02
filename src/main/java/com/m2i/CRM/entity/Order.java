package com.m2i.CRM.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
	
	private String typePresta;
	
	private String designation;
	
	private int nbDays;
	
	private float unitPrice;
	
	private int state;
	
	@ManyToOne
	@JoinTable( name = "order_client_association",
				joinColumns =  @JoinColumn(name ="id_order"),
				inverseJoinColumns = @JoinColumn(name = "client_id"))
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
