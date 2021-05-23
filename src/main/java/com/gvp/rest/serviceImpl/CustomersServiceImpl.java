package com.gvp.rest.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.gvp.rest.model.Customers;
import com.gvp.rest.repository.CustomersDAO;
import com.gvp.rest.service.CustomersService;


@Service
public class CustomersServiceImpl implements CustomersService {

	private static final Logger log = LoggerFactory.getLogger(CustomersServiceImpl.class);
	
	@Autowired
	private CustomersDAO cusDao;

	@Override
	public Customers save(Customers cusObj) {
		log.info("Started ServiceImpl :: CustomersServiceImpl :: save()");
		Customers cus = cusDao.save(cusObj);
		log.info("Ended ServiceImpl :: CustomersServiceImpl :: save()");
		return cus;
	}

	@Override
	public List<Customers> listAllCustomers() {
		log.info("Started ServiceImpl :: CustomersServiceImpl :: listAllCustomers()");
		Sort sort = Sort.by(Direction.DESC, "cusId");
		List<Customers> cuslist = cusDao.findAll(sort);
		log.info("Ended ServiceImpl :: CustomersServiceImpl :: listAllCustomers()");
		return cuslist;
	}

	@Override
	public Integer delete(Integer cid) {
		log.info("Started ServiceImpl :: CustomersServiceImpl :: delete()");
		cusDao.deleteById(cid);;
		log.info("Ended ServiceImpl :: CustomersServiceImpl :: delete()");
		return cid;
	}

	
    @Override
	public Customers get(Integer cid) {
		log.info("Started ServiceImpl :: CustomersServiceImpl :: update()"+cid);
		Customers customer = cusDao.findById(cid).get();
		log.info("Ended ServiceImpl :: CustomersServiceImpl :: update()"+customer);
		return customer;
	}

	@Override
	public void update(Integer cid,Customers cusObj) {
		log.info("Started ServiceImpl :: CustomersServiceImpl :: update()");
		Customers c = new Customers();
		c.setCusId(cid);
		c.setFname(cusObj.getFname());
		c.setLname(cusObj.getLname());
		c.setUname(cusObj.getUname());
		c.setPassword(cusObj.getPassword());
		c.setEmail(cusObj.getEmail());
		c.setPhone(cusObj.getPhone());
		c.setAddress(cusObj.getAddress());
		cusDao.save(c);
		
		log.info("Ended ServiceImpl :: CustomersServiceImpl :: update()"+c);
	}

	@Override
	public Optional<Customers> getCust(Integer cid) {
		log.info("Started ServiceImpl :: CustomersServiceImpl :: getCust()");
		Optional<Customers> cusObj = cusDao.findById(cid);
		log.info("Ended ServiceImpl :: CustomersServiceImpl :: getCust()"+cusObj);
		return cusObj;
	}

}
