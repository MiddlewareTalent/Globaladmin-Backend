package com.middleware.global_admin.Controller;

import com.middleware.global_admin.Entity.Admin;
import com.middleware.global_admin.Exception.ResourceNotFoundException;
import com.middleware.global_admin.Service.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/saveAdmin")
    public ResponseEntity<Admin> saveAdmin(@RequestBody Admin admin) {
        Admin adminSave = adminService.saveAdmin(admin);
        return ResponseEntity.ok(adminSave);
    }


    @PostMapping(value = "/login", produces = "application/json")
    public ResponseEntity<Map<String, Object>> loginAdmin(@RequestBody Admin admin) {

        try {
            Map<String, Object> response = adminService.loginAdmin(admin.getEmail(), admin.getPassword());
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("error", e.getMessage()));
        }
    }
}
