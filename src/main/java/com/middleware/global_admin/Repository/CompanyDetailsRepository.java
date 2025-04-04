package com.middleware.global_admin.Repository;
import com.middleware.global_admin.Entity.CompanyDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyDetailsRepository extends JpaRepository<CompanyDetails,Long>     {
      CompanyDetails findByCompanyDomain(String companyDomain);
      CompanyDetails findByCompanyCode(String companyCode);
      CompanyDetails findByCompanyEmail(String companyEmail);
}
