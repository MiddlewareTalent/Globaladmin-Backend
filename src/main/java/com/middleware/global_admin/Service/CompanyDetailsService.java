package com.middleware.global_admin.Service;
import com.middleware.global_admin.Entity.CompanyDetails;
import com.middleware.global_admin.Exceptions.OrganisationNotFoundException;
import com.middleware.global_admin.Repository.CompanyDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyDetailsService {
    @Autowired
    CompanyDetailsRepository companyDetailsRepository;

    public List<CompanyDetails> getAllCompanyDetails() {
        return companyDetailsRepository.findAll();
    }

    public CompanyDetails saveDetails(CompanyDetails companyDetails) {
        return companyDetailsRepository.save(companyDetails);
    }

    public CompanyDetails updateCompanyDetails(CompanyDetails companyDetails) {
        return companyDetailsRepository.save(companyDetails);
    }

    public CompanyDetails getCompanyDetailsByCompanyDomain(String CompanyDomain) {
        Optional<CompanyDetails> CompanyDetails = companyDetailsRepository.findByCompanyDomain(CompanyDomain);
        return CompanyDetails.orElseThrow(() -> new OrganisationNotFoundException("Organisation not found with domain: " + CompanyDomain));
    }

    public CompanyDetails getCompanyDetailsByCompanyCode(String CompanyCode) {
        Optional<CompanyDetails> CompanyDetails = companyDetailsRepository.findByCompanyCode(CompanyCode);
        return CompanyDetails.orElseThrow(() -> new OrganisationNotFoundException("Organisation not found with Company code: " + CompanyCode));
    }

    public CompanyDetails getCompanyDetailsByEmail(String CompanyEmail) {
        Optional<CompanyDetails> CompanyDetails = companyDetailsRepository.findByCompanyEmail(CompanyEmail);
        return CompanyDetails.orElseThrow(() -> new OrganisationNotFoundException("Organisation not found with email: " + CompanyEmail));
    }
}

