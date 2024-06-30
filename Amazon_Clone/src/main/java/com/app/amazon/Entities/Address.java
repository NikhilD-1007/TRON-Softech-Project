package com.app.amazon.Entities;

import org.springframework.validation.annotation.Validated;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Validated
public class Address extends BaseEntity{

	@Column(length = 100)
	@NotNull
	private String addr_line1;
	
	@Column(length = 100)
	@NotNull
	private String addr_line2;
	
	@Column(length = 50)
	@NotNull
	private String city;
	
	@Column(length = 50)
	@NotNull
	private String state;
	
	@Column(length = 10,name = "pin_code")
	@NotNull
	private int pinCode;
	
	
}
