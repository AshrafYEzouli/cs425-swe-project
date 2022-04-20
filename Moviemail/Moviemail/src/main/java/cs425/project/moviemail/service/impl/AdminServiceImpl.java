package cs425.project.moviemail.service.impl;


import cs425.project.moviemail.model.Admin;
import cs425.project.moviemail.repository.AdminRepository;
import cs425.project.moviemail.repository.CustomerRepository;
import cs425.project.moviemail.service.AdminService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {


    private AdminRepository adminRepository;

    private CustomerRepository customerRepository;

    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }


    @Override
    public List<Admin> getAllAdmin() {
        return adminRepository.findAll();
    }

    @Override
    public Admin save(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public Admin getAdminById(Long adminId) {
        return adminRepository.findById(adminId).orElse(null);
    }

    @Override
    public void deleteAdminById(Long adminId) {
        adminRepository.deleteById(adminId);

    }



}
