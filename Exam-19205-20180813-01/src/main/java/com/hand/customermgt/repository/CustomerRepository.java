package com.hand.customermgt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hand.customermgt.customer.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
	