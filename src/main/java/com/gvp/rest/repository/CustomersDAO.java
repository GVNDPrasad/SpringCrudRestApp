package com.gvp.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gvp.rest.model.Customers;


public interface CustomersDAO extends JpaRepository<Customers, Integer> {
	
    //Automatically CRUD operations
	
}
