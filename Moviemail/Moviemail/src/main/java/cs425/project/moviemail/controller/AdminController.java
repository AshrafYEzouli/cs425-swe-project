package cs425.project.moviemail.controller;

import cs425.project.moviemail.model.Customer;
import cs425.project.moviemail.service.CustomerService;
import cs425.project.moviemail.service.impl.AdminServiceImpl;
import cs425.project.moviemail.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"/admin"})
public class AdminController {

    @Autowired
    private AdminServiceImpl adminService;

    @Autowired
    private CustomerService customerService;

    public void addAdmin() {

    }

    public void Login() {

    }

    @PostMapping(value = {"/customer/new"})
    public void addCustomer(Customer customer) {
        customerService.addCustomer(customer);
    }

    public void getAllCustomers() {

    }

    public void addMovie() {

    }

    public void getAllMovies() {

    }
}
