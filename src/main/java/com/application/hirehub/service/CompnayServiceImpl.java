package com.application.hirehub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.hirehub.company.dto.CompanyDTO;
import com.application.hirehub.company.entity.Company;
import com.application.hirehub.exception.ResourceAlreadyExits;
import com.application.hirehub.repository.Companyrepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class CompnayServiceImpl implements CompanyService {
	
	
	private final Companyrepository companyrepository;
	
	@Override
	public List<Company> getAllCompanies() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Company createComapny(CompanyDTO companyDTO) {
		
		if(companyrepository.existsByName(companyDTO.getName())) {
			throw new ResourceAlreadyExits("Comapny with " +companyDTO.getName() + " this mail already exits please try different mail" );
		}
		
		
		
		
	}

}
