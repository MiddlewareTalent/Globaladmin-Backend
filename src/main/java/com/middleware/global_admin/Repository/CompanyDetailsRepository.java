package com.middleware.global_admin.Repository;
import com.middleware.global_admin.Entity.CompanyDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CompanyDetailsRepository extends JpaRepository<CompanyDetails,Long>     {
      Optional<CompanyDetails> findByCompanyDomain(String companyDomain);
      Optional<CompanyDetails> findByCompanyCode(String companyCode);
      Optional<CompanyDetails> findByCompanyEmail(String companyEmail);
}
