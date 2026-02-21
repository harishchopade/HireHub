package com.application.hirehub.service;

import java.util.List;

import com.application.hirehub.company.dto.CompanyDTO;
import com.application.hirehub.company.entity.Company;

public interface CompanyService {

	public List<Company> getAllCompanies();
	public Company createComapny(CompanyDTO companyDTO);
}
