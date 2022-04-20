package cs425.project.moviemail.controller;


import cs425.project.moviemail.model.Admin;
import cs425.project.moviemail.model.Customer;
import cs425.project.moviemail.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = {"/customer"})
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(value = {"/listCustomer"})
    public ModelAndView listCustomers() {
        var modelAndView = new ModelAndView();
        var customers = customerService.getAllCustomer();
        modelAndView.addObject("customers", customers);
        modelAndView.addObject("customersCount", customers.size());
        modelAndView.setViewName("secured/admin/customerList");
        return modelAndView;
    }

    @GetMapping(value = {"/new"})
    public String displayNewCustomerForm(Model model) {
        model.addAttribute("customer", new Customer(null,null,null,null));
        return "secured/admin/customerNew";
    }

    @PostMapping(value = {"/new"})
    public String registerNewAdmin(@Valid @ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        return "redirect:/customer/listCustomer";
    }

    @GetMapping(value = {"/edit/{customerId}"})
    public String editCustomer(@PathVariable Long customerId, Model model) {
        var customer = customerService.getCustomerById(customerId);
        if(customer != null) {
            model.addAttribute("customer", customer);
            return "secured/admin/customerEdit";
        }
        return "redirect:/customer/listCustomer";
    }

    @PostMapping(value = {"/update"})
    public String updateCustomer(@Valid @ModelAttribute("customer") Customer customer,
                              BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("customer", customer);
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "secured/admin/customerEdit";
        }
        customerService.save(customer);
        return "redirect:/customer/listCustomer";
    }

    @GetMapping("/delete/{customerId}")
    public String deleteCustomer(@PathVariable Long customerId) {
        Customer customer = customerService.getCustomerById(customerId);
        customerService.deleteCustomerById(customerId);
        return "redirect:/customer/listCustomer";
    }
}
