package com.gvp.rest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gvp.rest.model.Customers;
import com.gvp.rest.service.CustomersService;

@RestController
@RequestMapping("/customers")
public class CustomersController {

	private static final Logger log = LoggerFactory.getLogger(CustomersController.class);

	@Autowired
	private CustomersService cusService;
	
	ResponseEntity<String> resp = null;
	
	@GetMapping("/test")
	private String appTest() {
		return "Ur test is success";
	}

	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Customers cusObj) {
		
        log.info("Started Controller :: CustomersController :: save()");
		System.out.println("id: "+cusObj.getCusId());
        Customers cus = cusService.save(cusObj);
		//resp = new ResponseEntity<String>("Hi"+cus.getFname()+"Successfully created your account",HttpStatus.OK);
		resp = ResponseEntity.ok("Hi"+cus.getFname()+"Successfully created your account");
		log.info("Ended Controller :: CustomersController :: save()");
		
		return resp;

	}
	
//	@PostMapping("/update/{id}")
//	public ResponseEntity<String> update(@PathVariable("id") Integer id, @PathVariable("name") String name) {
//		
//        log.info("Started Controller :: CustomersController :: save()");
//		
//        Customers cus = cusService.save(cusObj);
//		//resp = new ResponseEntity<String>("Hi"+cus.getFname()+"Successfully created your account",HttpStatus.OK);
//		resp = ResponseEntity.ok("Hi"+cus.getFname()+"Successfully created your account");
//		log.info("Ended Controller :: CustomersController :: save()");
//		
//		return resp;
//
//	}
	
	@RequestMapping("/delete/{cid}")
	public ResponseEntity<String> delete(@PathVariable Integer cid) {
	   log.info("Started Controller :: CustomersController :: delete()");
	   Integer cusID = cusService.delete(cid);
	   resp = new ResponseEntity<String>(cusID+" Deleted customer successfully",HttpStatus.ACCEPTED);
	   log.info("Ended Controller :: CustomersController :: delete()");
	   return resp;	
	}
	
	
	@GetMapping("/list")
	public ResponseEntity<List<Customers>> listAllCustomers() {
		log.info("Started Controller :: CustomersController :: listAllCustomers()");
		
		ResponseEntity<List<Customers>> respAll = null;
		List<Customers> custList = cusService.listAllCustomers();
		respAll = new ResponseEntity<List<Customers>>((List<Customers>) custList,HttpStatus.OK);
		
		log.info("Ended Controller :: CustomersController :: listAllCustomers()");
		return respAll;		
	}
	
	@PutMapping("/edit/{cid}")
	public ResponseEntity<String> update(@PathVariable Integer cid) {
		log.info("Started Controller :: CustomersController :: update()"+cid);
		
		Customers customer = cusService.update(cid);
		resp = new ResponseEntity<String>(customer.getUname()+" data has updated successfully",HttpStatus.OK);
		
		log.info("Started Controller :: CustomersController :: update()"+customer);
		return resp;
	}
	
	

}
