package com.application.hirehub.company.service;

import java.util.List;

import com.application.hirehub.company.dto.CompanyDTO;
import com.application.hirehub.company.entity.Company;

public interface CompanyService {
	List<Company> getAllCompanies();
	Company createComapny(CompanyDTO companyDTO);
	Company getCompanyById(Long id);
	Company updateCompany(Long id, CompanyDTO companyDTO);
	void deleteCompany(Long id);
	Company getCompanyByName(String name);
}
