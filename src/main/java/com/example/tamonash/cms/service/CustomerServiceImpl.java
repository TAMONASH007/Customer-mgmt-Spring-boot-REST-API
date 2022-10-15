/*
 * author:tamonash
 */

package com.example.tamonash.cms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.tamonash.cms.exception.DataNotFoundException;
import com.example.tamonash.cms.model.Customer;
import com.example.tamonash.cms.repository.CustomerRepository;



@Service
public class CustomerServiceImpl implements CustomerService {

	
	private CustomerRepository customerRepository;
	
	
	
	
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}




	@Override
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	
	@Override
	public List<Customer> getAllCustomers(){
		return customerRepository.findAll();	}




	@Override
	public Customer getCustomerById(int id) {
		
		Optional<Customer> customer = customerRepository.findById(id);
		if(customer.isPresent()) {
			return customer.get();
		}else {
			throw new DataNotFoundException("Customer", "Id", id);
		}
	}




	@Override
	public Customer updateCustomer(Customer customer, int id) {
		Customer existingCustomer = customerRepository.findById(id).orElseThrow(()-> new DataNotFoundException("Customer", "id", id));
		
		existingCustomer.setFirstName(customer.getFirstName());
		existingCustomer.setLastName(customer.getLastName());
		existingCustomer.setEmailAddress(customer.getEmailAddress());
		
		customerRepository.save(existingCustomer);
		
		return existingCustomer;
		
	}




	@Override
	public void deleteCustomer(int id) {
		customerRepository.findById(id).orElseThrow(()-> new DataNotFoundException("Customer", "id", id));
		customerRepository.deleteById(id);
		
	}
	
	

	
}
