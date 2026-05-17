package com.example.demo.service.impl;

import com.example.demo.model.entity.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer insertCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Long cusId, Customer customer) {
        customerRepository.findById(cusId).orElseThrow(() -> new RuntimeException("Customer not found with id: " + cusId));
        return customerRepository.save(customer);
    }

    @Override
    public boolean deleteCustomer(Long cusId) {
        customerRepository.findById(cusId).orElseThrow(() -> new RuntimeException("Customer not found with id: " + cusId));
        customerRepository.deleteById(cusId);
        return true;
    }

    @Override
    public List<Customer> getCustomersByName(String cusName) {
        return customerRepository.findCustomerByCusNameContaining(cusName);
    }

    @Override
    public Customer getCustomerById(Long cusId) {
        return customerRepository.findById(cusId).orElseThrow(() -> new RuntimeException("Customer not found with id: " + cusId));
    }
}
