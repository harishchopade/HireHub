package com.application.hirehub.company.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.application.hirehub.company.dto.CompanyDTO;
import com.application.hirehub.company.entity.Company;
import com.application.hirehub.company.exception.ResourceAlreadyExits;
import com.application.hirehub.company.repository.Companyrepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class CompnayServiceImpl implements CompanyService {
	
	
	private final Companyrepository companyrepository;
	private final ModelMapper mapper;

	@Override
	public List<Company> getAllCompanies() {
		return companyrepository.findAll();
	}

	@Override
	public Company createComapny(CompanyDTO companyDTO) {
		if(companyrepository.existsByName(companyDTO.getName())) {
			throw new ResourceAlreadyExits("Company with name "+companyDTO.getName()+" already exists");
		}
		Company company = mapper.map(companyDTO, Company.class);
		return companyrepository.save(company);
	}

	@Override
	public Company getCompanyById(Long id) {
		return companyrepository.findById(id)
				.orElseThrow(()-> new RuntimeException("Company with id "+id+" not found"));
	}

	@Override
	public Company updateCompany(Long id, CompanyDTO companyDTO) {
		Company existingCompany = companyrepository.findById(id)
				.orElseThrow(()-> new RuntimeException("Company with id "+id+" not found"));
		Company updatedCompany = mapper.map(companyDTO, Company.class);
		updatedCompany.setId(existingCompany.getId());
		return companyrepository.save(updatedCompany);
}

	@Override
	public void deleteCompany(Long id) {
		Company existingCompany = companyrepository.findById(id)
				.orElseThrow(()-> new RuntimeException("Company with id "+id+" not found"));
		companyrepository.delete(existingCompany);
	}

	@Override
	public Company getCompanyByName(String name) {
		return companyrepository.findByName(name)
				.orElseThrow(()-> new RuntimeException("Company with name "+name+" not found"));
				
	}
}
