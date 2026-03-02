package com.application.hirehub.company.dto;

import com.application.hirehub.company.entity.Industry;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDTO {
	@NotBlank(message = "Company name is required")
	private String name;
	
	@NotBlank(message = "Company email is required")
	@Email(message = "Invalid email format")
	private String email;
	
	@NotBlank(message = "Company website is required")
	private String website;
	
	@NotBlank(message = "Company description is required")
	private String descp;
	
	@NotBlank(message = "Company address is required")
	private String address;
	
	@Enumerated(EnumType.STRING)
	private Industry industry;

}
