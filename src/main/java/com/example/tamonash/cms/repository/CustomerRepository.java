/*
 * author:tamonash
 */

package com.example.tamonash.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tamonash.cms.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer > {

}
