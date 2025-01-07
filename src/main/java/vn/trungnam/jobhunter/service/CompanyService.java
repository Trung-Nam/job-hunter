package vn.trungnam.jobhunter.service;

import org.springframework.stereotype.Service;
import vn.trungnam.jobhunter.domain.Company;
import vn.trungnam.jobhunter.repository.CompanyRepository;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Company handleCreateCompany(Company company){
        return this.companyRepository.save(company);
    }
}
