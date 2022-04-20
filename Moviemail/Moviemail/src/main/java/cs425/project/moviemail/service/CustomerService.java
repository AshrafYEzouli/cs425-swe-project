package cs425.project.moviemail.service;

import cs425.project.moviemail.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomer();
    Customer save(Customer customer);
    Customer getCustomerById(Long customerId);
    void deleteCustomerById(Long customerId);
}
