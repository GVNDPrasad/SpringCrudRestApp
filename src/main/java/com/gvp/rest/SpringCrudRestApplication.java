package com.gvp.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringCrudRestApplication {
	
	private static final Logger log = LoggerFactory.getLogger(SpringCrudRestApplication.class);

    public static void main(String[] args) {
		SpringApplication.run(SpringCrudRestApplication.class, args);
		log.info("It's a Springboot REST based CRUD Application");
	}

}
