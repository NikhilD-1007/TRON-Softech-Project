package com.app.amazon.DTO;

import org.springframework.validation.annotation.Validated;

import com.app.amazon.Entities.Address;
import com.app.amazon.Entities.Role;
import com.app.amazon.Entities.ShoppingCart;
import com.app.amazon.Entities.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Validated
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserDTO {

	@JsonProperty(access = Access.READ_ONLY)
	private Long id;
	
	@Column(nullable = false)
	private Role userRole;
	
	@Column(length = 30, nullable = false)
	private String firstName;
	
	@Column(length = 30, nullable = false)
	private String lastName;
	
	@Column(length = 30, unique = true)
	private String email;
	
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$", message = "Invalid Password")
	@Column(length = 50)
	private String password;
	
	@Column(name = "Mobile_no")
	private Long contactNumber;
}
