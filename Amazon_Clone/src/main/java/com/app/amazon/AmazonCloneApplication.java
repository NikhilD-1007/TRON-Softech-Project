package com.app.amazon;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class AmazonCloneApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmazonCloneApplication.class, args);
	}
	
	//Understand this terminology from Ajya n Pritam
	
	@Bean //Bean --> equivalent to <bean id.../> in xml file
	public ModelMapper configureMapper()
	{
		System.out.println("in config mapper!");
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapper;
	}

	
	
	  @Bean public PasswordEncoder encoder() { 
		  return new BCryptPasswordEncoder();
	  }
	 
	 
	
}
