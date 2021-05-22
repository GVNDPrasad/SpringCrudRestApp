package com.gvp.rest.service;

import java.util.List;

import com.gvp.rest.model.Customers;


public interface CustomersService {
	
	//Save
	public Customers save(Customers cusObj);
	
	//Update
	public Customers update(Integer cid);
	
	//Delete
	public Integer delete(Integer cid);
	
	//List of customers
	public List<Customers> listAllCustomers();

}
