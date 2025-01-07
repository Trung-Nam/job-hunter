package vn.trungnam.jobhunter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.trungnam.jobhunter.domain.Company;


public interface CompanyRepository extends JpaRepository<Company, Long> {
}
