package com.application.hirehub.company.dto;

import com.application.hirehub.company.entity.Industry;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class CompanyDTO {
	
	@NotBlank(message = "Name cannot be blank")
	private String name;
	
	@NotBlank(message = "Name cannot be blank")
	private String desc;
	
	@NotBlank(message = "Name cannot be blank")
	@Enumerated(EnumType.STRING)
	private Industry category;
	
	@NotBlank(message = "Name cannot be blank")
	private String website;
	
	@NotBlank(message = "Email cannot be blank")
	@Email(message = "Email needs to be in format")
	private String email;
	
	@NotBlank(message = "Address cannot be blank")
	private String address;

}
