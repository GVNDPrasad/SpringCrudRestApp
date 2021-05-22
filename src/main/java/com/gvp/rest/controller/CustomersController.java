package com.gvp.rest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@GetMapping("/test")
	private String appTest() {
		return "Ur test is success";
	}

	@PostMapping("/save")
	public String save(@RequestBody Customers cusObj) {
        log.info("Started Controller :: CustomersController :: save()");
		
		Customers cus = cusService.save(cusObj);
		String msg = "Hi"+cus.getFname()+"Successfully created your account";
		
		log.info("Ended Controller :: CustomersController :: save()");
		return "GVP APP";

	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("cid") Integer cid, Model model) {
	   log.info("Started Controller :: CustomersController :: delete()");
	   cusService.delete(cid);
	   model.addAttribute("msg", "Deleted Successfull !");
		
	   log.info("Ended Controller :: CustomersController :: delete()");
	   return "GVP APP";	
	}
	
	
	@GetMapping("/list")
	public String listAllCustomers(Model model) {
		log.info("Started Controller :: CustomersController :: listAllCustomers()");
		List<Customers> custList = cusService.listAllCustomers();
		model.addAttribute("allCustomersList", custList);
		log.info("Ended Controller :: CustomersController :: listAllCustomers()");
		return "GVP APP";		
	}
	
	@RequestMapping("/edit")
	public String update(@RequestParam("cid") Integer cid, Model model) {
		log.info("Started Controller :: CustomersController :: update()"+cid);
		Customers customer = cusService.update(cid);
		log.info("Started Controller :: CustomersController :: update()"+customer);
		model.addAttribute("customer", customer);
		return "GVP APP";
	}
	
	

}
