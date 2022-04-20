package cs425.project.moviemail.controller;

import cs425.project.moviemail.model.Admin;
import cs425.project.moviemail.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = {"/admin"})
public class AdminController {

    private AdminService adminService;


    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping(value = {"/list"})
    public ModelAndView listAdmins() {
        var modelAndView = new ModelAndView();
        var admins = adminService.getAllAdmin();
        modelAndView.addObject("admins", admins);
        modelAndView.addObject("adminsCount", ((List)admins).size());
        modelAndView.setViewName("secured/admin/adminList");
        return modelAndView;
    }
    @GetMapping(value = {"/new"})
    public String displayNewAdminForm(Model model) {
        model.addAttribute("admin", new Admin(null,null,null,null));
        return "secured/admin/adminNew";
    }
    @PostMapping(value = {"/new"})
    public String registerNewAdmin(@Valid @ModelAttribute("admin") Admin admin,
                                     BindingResult bindingResult, Model model) {

        adminService.save(admin);
        return "redirect:/admin/list";
    }

    @GetMapping(value = {"/edit/{adminId}"})
    public String editAdmin(@PathVariable Long adminId, Model model) {
        var admin = adminService.getAdminById(adminId);
        if(admin != null) {
            model.addAttribute("admin", admin);
            return "secured/admin/adminEdit";
        }
        return "redirect:/admin/list";
    }

    @PostMapping(value = {"/update"})
    public String updateAdmin(@Valid @ModelAttribute("admin") Admin admin,
                                  BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("admin", admin);
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "secured/admin/adminEdit";
        }
        adminService.save(admin);
        return "redirect:/admin/list";
    }
    @GetMapping("/delete/{adminId}")
    public String deleteAdmin(@PathVariable Long adminId) {
        Admin admin = adminService.getAdminById(adminId);
        adminService.deleteAdminById(adminId);
        return "redirect:/admin/list";
    }


}
