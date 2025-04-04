package com.middleware.global_admin.Service.JWT;

import com.middleware.global_admin.Entity.Admin;
import com.middleware.global_admin.Entity.AdminPrinciple;
import com.middleware.global_admin.Repository.AdminRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminDetailsService implements UserDetailsService {

    private final AdminRepository adminRepository;

    public AdminDetailsService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Admin> adminOptional = adminRepository.findByEmail(username);

        if (adminOptional.isEmpty()) {
            throw new UsernameNotFoundException("Admin not found with email: " + username);
        }

        return new AdminPrinciple(adminOptional.get());
    }
}
