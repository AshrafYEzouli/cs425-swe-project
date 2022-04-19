package cs425.project.moviemail.service.impl;

import cs425.project.moviemail.model.Customer;
import cs425.project.moviemail.repository.CustomerRepository;
import cs425.project.moviemail.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
