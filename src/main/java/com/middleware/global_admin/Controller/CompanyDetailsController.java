package com.middleware.global_admin.Controller;
import com.middleware.global_admin.Entity.CompanyDetails;
import com.middleware.global_admin.Service.CompanyDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/CompanyDetails")
public class CompanyDetailsController {
    @Autowired
    public CompanyDetailsService companyDetailsService;

    @PostMapping("/add")
    public CompanyDetails addCompanyDetails(@RequestBody CompanyDetails companyDetails) {
        return companyDetailsService.saveDetails(companyDetails);
    }
    @GetMapping(produces = "application/json")
    public List<CompanyDetails> getAllCompanyDetails() {
        return companyDetailsService.getAllCompanyDetails();
    }
    @GetMapping("/findByCompanyCode/{companyCode}")
    public CompanyDetails findByCompanyCode(@PathVariable String companyCode) {
        return companyDetailsService.getCompanyDetailsByCompanyCode(companyCode);
    }
    @GetMapping("/findByCompanyDomain")
    public CompanyDetails findByCompanyDomain(@RequestParam String companyDomain) {
        return companyDetailsService.getCompanyDetailsByCompanyDomain(companyDomain);
    }
    @GetMapping("/findByCompanyEmail")
    public CompanyDetails findByCompanyEmail(@RequestParam String companyEmail) {
        return companyDetailsService.getCompanyDetailsByEmail(companyEmail);
    }
    @PutMapping("/{id}")
    public CompanyDetails updateCompanyDetails(@PathVariable Long id, @RequestBody CompanyDetails companyDetails) {
        companyDetails.setId(id);
        return companyDetailsService.updateCompanyDetails(companyDetails);
    }
}


