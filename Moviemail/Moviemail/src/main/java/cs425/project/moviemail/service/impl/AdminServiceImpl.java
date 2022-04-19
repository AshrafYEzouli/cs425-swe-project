package cs425.project.moviemail.service.impl;

import cs425.project.moviemail.model.Customer;
import cs425.project.moviemail.repository.AdminRepository;
import cs425.project.moviemail.repository.CustomerRepository;
import cs425.project.moviemail.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
