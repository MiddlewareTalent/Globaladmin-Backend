package com.middleware.global_admin.Controller;
import com.middleware.global_admin.Entity.CompanyDetails;
import com.middleware.global_admin.Service.CompanyDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/CompanyDetails")
public class CompanyDetailsController {

    @Autowired
    public CompanyDetailsService companyDetailsService;

    @PostMapping("/add")
    public ResponseEntity<CompanyDetails> addCompanyDetails(@RequestBody CompanyDetails companyDetails) {
        CompanyDetails company = companyDetailsService.saveDetails(companyDetails);
        return ResponseEntity.ok(company);
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<CompanyDetails>> getAllCompanyDetails() {
        List<CompanyDetails> company = companyDetailsService.getAllCompanyDetails();
        return ResponseEntity.ok(company);
    }
    @GetMapping("/findByCompanyCode/{companyCode}")
    public CompanyDetails findByCompanyCode(@PathVariable String companyCode) {
        return companyDetailsService.getCompanyDetailsByCompanyCode(companyCode);
    }
    @GetMapping("/findByDomain")
    public CompanyDetails findByCompanyDomain(@RequestParam String companyDomain) {
        return companyDetailsService.getCompanyDetailsByCompanyDomain(companyDomain);
    }
    @GetMapping("/findByCompanyEmail")
    public CompanyDetails findByCompanyEmail(@RequestParam String companyEmail) {
        return companyDetailsService.getCompanyDetailsByCompanyEmail(companyEmail);
    }

}
