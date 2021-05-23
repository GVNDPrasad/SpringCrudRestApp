package com.gvp.rest.service;

import java.util.List;
import java.util.Optional;

import com.gvp.rest.model.Customers;


public interface CustomersService {
	
	//Save
	public Customers save(Customers cusObj);
	
	//Update
	public void update(Integer cid,Customers cusObj);
	
	//Delete
	public Integer delete(Integer cid);
	
	//Get customer id
	public Customers get(Integer cid);
	
	//List of customers
	public List<Customers> listAllCustomers();
	
	//Get single customer details
	public Optional<Customers> getCust(Integer cid);

}
