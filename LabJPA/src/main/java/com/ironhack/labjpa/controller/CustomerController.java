package com.ironhack.labjpa.controller;

import com.ironhack.labjpa.model.Customer;
import com.ironhack.labjpa.model.enums.CustomerStatus;
import com.ironhack.labjpa.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getAll() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Customer getById(@PathVariable Integer id) {
        return customerService.getCustomerById(id);
    }

    @GetMapping("/status/{status}")
    public List<Customer> getByStatus(@PathVariable CustomerStatus status) {
        return customerService.findByStatus(status);
    }

    @GetMapping("/miles/{minMiles}")
    public List<Customer> getByMileage(@PathVariable int minMiles) {
        return customerService.findByMileageGreaterThan(minMiles);
    }
}
