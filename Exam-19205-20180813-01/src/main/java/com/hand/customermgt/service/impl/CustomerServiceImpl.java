package com.hand.customermgt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hand.customermgt.customer.Customer;
import com.hand.customermgt.repository.CustomerRepository;
import com.hand.customermgt.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public void save(Customer customer) {
		customerRepository.save(customer);
	}

	@Override
	public void update(Customer customer) {
		customerRepository.saveAndFlush(customer);
	}


	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	
	@Override
	public void delete(Customer customer) {
		
	}

	@Override
	public Customer find(Long id) {
		return customerRepository.findOne(id);
	}

	public CustomerRepository getCustomerRepository() {
		return customerRepository;
	}

	public void setCustomerRepository(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	
}
