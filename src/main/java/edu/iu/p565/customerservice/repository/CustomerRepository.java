package edu.iu.p565.customerservice.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import edu.iu.p565.customerservice.model.Customer;

@Repository
public class CustomerRepository {
    private List<Customer> customers = new ArrayList<>();

    public List<Customer> findAll() {
        return customers;
    }

    public int create(Customer customer) {
        int id = customers.size() + 1;
        customer.setId(id);
        customers.add(customer);
        return id;
    }

    public void update(Customer customer, int id){
        Customer c = getCustomerById(id);
        if(c != null){
            c.setName(customer.getName());
            c.setEmail(customer.getEmail());
        }
        else{
            throw new IllegalStateException("Customer with this id was not found.");
        }
    }

    public void delete(int id){
        Customer c = getCustomerById(id);
        if(c != null){
            customers.remove(c);
        }
        else{
            throw new IllegalStateException("Customer with this id was not found.");
        }
    }

    public Customer getCustomerById(int id){
        return customers.stream().filter(c -> c.getId() == id).findAny().orElse(null);
    }
}