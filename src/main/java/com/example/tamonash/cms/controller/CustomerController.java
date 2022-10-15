
/*
 * author:tamonash
 */
package com.example.tamonash.cms.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tamonash.cms.model.Customer;
import com.example.tamonash.cms.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	private CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	//This method will insert data in the database table
	@PostMapping()
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer){
		return new ResponseEntity<Customer>(customerService.saveCustomer(customer), HttpStatus.CREATED);
	}
	
	//This method will fetch all the customer details from the database
	@GetMapping
	public List<Customer> getAllCustomers(){
		return customerService.getAllCustomers();
	}
	
	//This method will fetch customer details by any particular customer ID
	@GetMapping("{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") int id){
		return new ResponseEntity<Customer>(customerService.getCustomerById(id), HttpStatus.OK);
	}
	
	//This method will update customer details for any particular customer ID if at all that customer exists
	@PutMapping("{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable("id") int id,@RequestBody Customer customer){
		return new ResponseEntity<Customer>(customerService.updateCustomer(customer, id), HttpStatus.OK);
	}
	
	
	//This method will delete customer details for any particular customer ID if at all that customer exists
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("id") int id){
		customerService.deleteCustomer(id);
		return new ResponseEntity<String>("Customer has been deleted successfully from the database",HttpStatus.OK);
	}
	
}
