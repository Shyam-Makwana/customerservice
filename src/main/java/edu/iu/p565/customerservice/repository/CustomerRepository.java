package edu.iu.p565.customerservice.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import edu.iu.p565.customerservice.model.Customer;

@Repository
public class CustomerRepository {
    private List<Customer> repository = new ArrayList<>();

    public List<Customer> findAll() {
        return repository;
    }
}