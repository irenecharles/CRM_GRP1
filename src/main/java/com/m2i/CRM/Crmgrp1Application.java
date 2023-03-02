package com.m2i.CRM;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Crmgrp1Application {

	public static void main(String[] args) {
		SpringApplication.run(Crmgrp1Application.class, args);
	}

}
