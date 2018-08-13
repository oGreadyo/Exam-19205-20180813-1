package com.hand.customermgt.service;

import java.util.List;

import com.hand.customermgt.customer.Customer;


public interface CustomerService {
	
	/**
	 * 添加一个用户(用户注册)
	 * @param customer
	 */
	public void save(Customer customer);

	/**
	 * 更新一个用户
	 * @param customer
	 */
	public void update(Customer customer);
	
	/**
	 * 删除一个用户
	 * @param customer
	 */
	public void delete(Customer customer);
	
	/**
	 * 通过id找到相应的用户
	 * @param id
	 * @return
	 */
	public Customer find(Long id);
	
	/**
	 * 得到所有的用户
	 * @return
	 */
	public List<Customer> findAll();
}
