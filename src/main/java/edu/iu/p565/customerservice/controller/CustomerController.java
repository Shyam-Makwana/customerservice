package edu.iu.p565.customerservice.controller;

import java.util.List;

import edu.iu.p565.customerservice.repository.CustomerRepository;
import org.springframework.web.bind.annotation.*;
import edu.iu.p565.customerservice.model.Customer;

import javax.validation.Valid;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping
    public List<Customer> findAll(){
        return customerRepository.findAll();
    }

    @PostMapping
    public int create(@Valid @RequestBody Customer customer) {
        return customerRepository.create(customer);
    }

    @PutMapping("/{id}")
    public void update(@Valid @RequestBody Customer customer, @PathVariable int id) {
        customerRepository.update(customer, id);
    }

    @DeleteMapping("/{id}")
    public void update(@PathVariable int id) {
        customerRepository.delete(id);
    }
}
