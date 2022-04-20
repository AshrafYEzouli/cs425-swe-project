package cs425.project.moviemail.service;

import cs425.project.moviemail.model.Admin;

import java.util.List;

public interface AdminService {
    public abstract List<Admin> getAllAdmin();
    Admin save(Admin admin);
    public abstract Admin getAdminById(Long adminId);
    public abstract void deleteAdminById(Long adminId);


}
