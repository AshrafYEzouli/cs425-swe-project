package cs425.project.moviemail.controller;


import cs425.project.moviemail.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = {"/customer"})
public class CustomerController {
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(value = {"/listCustomer"})
    public ModelAndView listCustomers() {
        var modelAndView = new ModelAndView();
        var customers = customerService.getAllCustomer();
        modelAndView.addObject("customers", customers);
        modelAndView.addObject("customers", ((List)customers).size());
        modelAndView.setViewName("secured/admin/customerList");
        return modelAndView;
    }


}
