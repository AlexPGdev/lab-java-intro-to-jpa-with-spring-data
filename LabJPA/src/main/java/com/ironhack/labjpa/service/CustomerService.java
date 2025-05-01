package com.ironhack.labjpa.service;

import com.ironhack.labjpa.model.Customer;
import com.ironhack.labjpa.model.enums.CustomerStatus;
import com.ironhack.labjpa.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository repository) {
        this.customerRepository = repository;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Integer id) {
        return customerRepository.findById(id).orElse(null);
    }

    public List<Customer> findByStatus(CustomerStatus status) {
        return customerRepository.findByCustomerStatus(status);
    }

    public List<Customer> findByMileageGreaterThan(int mileage) {
        return customerRepository.findByTotalCustomerMileageGreaterThan(mileage);
    }

}
