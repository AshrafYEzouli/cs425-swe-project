package cs425.project.moviemail.controller;

import cs425.project.moviemail.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"/customer"})
public class CustomerController {

    @GetMapping(value = {"/new"})
    public String displayNewStudentForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "secured/addNewCustomer";
    }

    public void checkout() {

    }

    public void getAllRecords() {

    }
}
