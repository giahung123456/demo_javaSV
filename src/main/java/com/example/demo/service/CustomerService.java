package com.example.demo.service;

import com.example.demo.model.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();
    Customer insertCustomer(Customer customer);
    Customer updateCustomer(Long cusId,Customer customer);
    boolean deleteCustomer(Long cusId);
    List<Customer> getCustomersByName(String cusName);
    Customer getCustomerById(Long cusId);
}
