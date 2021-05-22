package com.gvp.rest.serviceImpl;

import java.util.List;

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
	public Customers update(Integer cid) {
		log.info("Started ServiceImpl :: CustomersServiceImpl :: update()"+cid);
		Customers customer = cusDao.findById(cid).get();
		log.info("Ended ServiceImpl :: CustomersServiceImpl :: update()"+customer);
		return customer;
	}

}
