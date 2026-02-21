package com.application.hirehub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.hirehub.company.entity.Company;


@Repository
public interface Companyrepository extends JpaRepository<Company,Long> {
	
	boolean existsByName(String email);

}
