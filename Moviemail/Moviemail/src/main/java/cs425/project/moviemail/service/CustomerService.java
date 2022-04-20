package cs425.project.moviemail.service;

import cs425.project.moviemail.model.Customer;

import java.util.List;

public interface CustomerService {
    public abstract List<Customer> getAllCustomer();
    Customer save(Customer customer);
    public abstract Customer getCustomerById(Long customerId);
    public abstract void deleteCustomerById(Long customerId);
}
