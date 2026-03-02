package com.application.hirehub.company.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.hirehub.company.entity.Company;


@Repository
public interface Companyrepository extends JpaRepository<Company,Long> {
	boolean existsByName(String name);
	Optional<Company> findByName(String name);
}
