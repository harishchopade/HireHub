package com.application.hirehub.company.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.hirehub.company.dto.CompanyDTO;
import com.application.hirehub.company.exception.ResourceAlreadyExits;
import com.application.hirehub.company.service.CompanyService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api/company")
@RequiredArgsConstructor
public class CompnayController {
	
	private final CompanyService companyService;
	
	@PostMapping
	public ResponseEntity<?> createCompany(@RequestBody CompanyDTO companyDTO){	
		try {
			return new ResponseEntity<>(companyService.createComapny(companyDTO), HttpStatus.CREATED);
		} catch (ResourceAlreadyExits e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getCompanyById(@PathVariable Long id){
		try {
			return new ResponseEntity<>(companyService.getCompanyById(id), HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/name/{name}")
	public ResponseEntity<?> getCompanyByName(@PathVariable String name){	
		try {
			return new ResponseEntity<>(companyService.getCompanyByName(name), HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping
	public ResponseEntity<?> getAllCompanies(){
		return new ResponseEntity<>(companyService.getAllCompanies(), HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateCompany(@PathVariable Long id, @RequestBody CompanyDTO companyDTO){	
		try {
			return new ResponseEntity<>(companyService.updateCompany(id, companyDTO), HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteCompany(@PathVariable Long id){	
		try {
			companyService.deleteCompany(id);
			return new ResponseEntity<>("Company with id "+id+" deleted successfully", HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	
}
