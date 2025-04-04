package com.middleware.global_admin.Service;

import com.middleware.global_admin.Entity.Admin;
import com.middleware.global_admin.Repository.AdminRepository;
import com.middleware.global_admin.Service.JWT.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class AdminService {

    private final AdminRepository adminRepository;

    private final JWTService jwtService;

    private final AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AdminService(AdminRepository adminRepository, JWTService jwtService, AuthenticationManager authenticationManager) {
        this.adminRepository = adminRepository;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public Admin saveAdmin(Admin admin){
        if (adminRepository.findByEmail(admin.getEmail()).isPresent()) {
            throw new RuntimeException("Admin with this email already exists!");
        }
        String password = admin.getPassword() !=null? admin.getPassword() : UUID.randomUUID().toString().substring(0, 8);
        String hashedPassword = passwordEncoder.encode(password);
        admin.setPassword(hashedPassword);
        Admin savedAdmin = adminRepository.save(admin);
        return savedAdmin;
    }

    public Map<String, Object> loginAdmin(String email, String password) {
        Optional<Admin> adminOptional = adminRepository.findByEmail(email);
        if(adminOptional.isEmpty()){
            throw new  RuntimeException("Invalid email");
        }
        Admin admin = adminOptional.get();
        boolean isPasswordValid= new BCryptPasswordEncoder().matches(password, admin.getPassword());
        if(!isPasswordValid){
            throw new  RuntimeException("Invalid password");
        }
        Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email,password));
        if (!authentication.isAuthenticated()) {
            throw new RuntimeException("Authentication failed");
        }
        String token = jwtService.generateToken(email);
        Map<String,Object> map = new HashMap<>();
        map.put("message", "Login Successful");
        map.put("token",token);
        map.put("admin",admin);
        return map;
    }

}
