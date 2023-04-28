package com.example.customerservice;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerRestController {

  @Autowired
  CustomerRepository customerRepository;

  @GetMapping("/customers")
  public Collection<Customer> getAllCustomers() {
    return customerRepository.findAll();
  }
}
