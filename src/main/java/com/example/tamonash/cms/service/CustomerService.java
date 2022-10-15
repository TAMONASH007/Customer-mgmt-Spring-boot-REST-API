/*
 * author:tamonash
 */

package com.example.tamonash.cms.service;

import java.util.List;

import com.example.tamonash.cms.model.Customer;

public interface CustomerService {

	Customer saveCustomer(Customer customer);
	List<Customer> getAllCustomers();
	Customer getCustomerById(int id);
	Customer updateCustomer(Customer customer, int id);
	void deleteCustomer(int id);
}
