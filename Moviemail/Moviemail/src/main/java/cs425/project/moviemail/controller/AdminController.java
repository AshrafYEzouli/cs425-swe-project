package cs425.project.moviemail.controller;

import cs425.project.moviemail.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"/admin"})
public class AdminController {

    @Autowired
    private AdminService adminService;

    public void addAdmin() {

    }

    public void Login() {

    }

    public void addCustomer() {

    }

    public void getAllCustomers() {

    }

    public void addMovie() {

    }

    public void getAllMovies() {

    }
}
