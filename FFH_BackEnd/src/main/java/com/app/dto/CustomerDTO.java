package com.app.dto;

import com.app.pojos.HomeMaker;
import com.app.pojos.PlanPackage;
import com.app.pojos.PlanType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class CustomerDTO{
	
	private Integer id;	
	private String name;
//	@Email(message = "Invalid Email")
	private String email;
//	@NotBlank(message = "password is required")
	private String password;	
	private String confirmPassword;	
	private String phoneNo;	
	private String city;	
	private String pincode;	
//	@NotBlank(message = "address is required")
	private String primaryAddress;	
	private String state;	
	private String country;	
	private PlanPackage planPackage;	
	private PlanType planType;	
	private HomeMaker homeMaker;
		
}
