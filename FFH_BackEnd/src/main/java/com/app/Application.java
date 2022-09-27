package com.app;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	//configure ModelMapper as a spring bean
		@Bean //equivalent to <bean> tag in xml file
		public ModelMapper mapper()
		{
			System.out.println("in mapper");
			return new ModelMapper();
		}
		
//		@Bean 
//		public BCryptPasswordEncoder passwordEncoder()
//		{
//			System.out.println("In password encoder");
//			return new  BCryptPasswordEncoder();			
//		}
	
	

}
