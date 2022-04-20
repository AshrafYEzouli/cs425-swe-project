package cs425.project.moviemail.controller;

import cs425.project.moviemail.model.Admin;
import cs425.project.moviemail.service.AdminService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "admin/api")
public class AdminRestController {
    private AdminService adminService;

    public AdminRestController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping(value="/new")
    public Admin addNewAdmin(@Valid @RequestBody Admin admin){
        return adminService.save(admin);
    }

}
