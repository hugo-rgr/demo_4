package com.example.demo.security.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    private AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository){
        this.adminRepository = adminRepository;
    }

    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public Optional<Admin> getAdminById(Long id) {
        return adminRepository.findById(id);
    }

    public Optional<Admin> findAdminByLogin(String login) {
        return adminRepository.findByLogin(login);
    }


    public Admin updateAdmin(Long id, Admin adminDetails) {
        Optional<Admin> admin = adminRepository.findById(id);
        if (admin.isPresent()) {
            Admin existingAdmin = admin.get();
            existingAdmin.setLogin(adminDetails.getLogin());
            existingAdmin.setPass(adminDetails.getPass());
            return adminRepository.save(existingAdmin);
        }
        return null;
    }

    public void deleteAllAdmins() {
        adminRepository.deleteAll();
    }

    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }

}
