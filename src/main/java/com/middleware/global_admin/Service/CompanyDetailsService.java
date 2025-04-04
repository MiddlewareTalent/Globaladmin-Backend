package com.middleware.global_admin.Service;
import com.middleware.global_admin.Entity.CompanyDetails;
import com.middleware.global_admin.Repository.CompanyDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class CompanyDetailsService {

    @Autowired
    public CompanyDetailsRepository companyDetailsRepository;

    public List<CompanyDetails> getAllCompanyDetails() {
        return companyDetailsRepository.findAll();
    }
    public CompanyDetails saveDetails(CompanyDetails companyDetails) {
        return companyDetailsRepository.save(companyDetails);
    }
    public CompanyDetails getCompanyDetailsByCompanyDomain(String companyDomain) {
        return companyDetailsRepository.findByCompanyDomain(companyDomain);
    }
    public CompanyDetails getCompanyDetailsByCompanyCode(String companyCode) {
        return companyDetailsRepository.findByCompanyCode(companyCode);
    }
    public CompanyDetails getCompanyDetailsByCompanyEmail(String companyEmail) {
        return companyDetailsRepository.findByCompanyEmail(companyEmail);
    }
}


