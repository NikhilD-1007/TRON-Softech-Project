package com.app.amazon.Entities;



import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "user_tbl")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User extends BaseEntity{

	@Column(length = 40, name = "user_role")
	@Enumerated(EnumType.STRING)
	private Role userRole;
	
	@Length(min=4,max=20,message = "Invalid or Blank first name!!!!!!")
	@Column(length = 30, nullable = false, name = "first_name")
	private String firstName;
	@Column(length = 30, nullable = false, name = "last_name")
	private String lastName;
	
	@Column(length = 60, unique = true)
	@Email
	private String email;
	
	@Column(length = 100,nullable = false)
	private String password;
	
	@Column(name = "Mobile_no")
	private Long contactNumber;
	
	@Column(name = "user_status")
	@Enumerated(EnumType.STRING)
	private Status userStatus;
	
	@JsonProperty(access = Access.WRITE_ONLY) //New change
	@OneToOne(mappedBy = "shoopingCartOwner",cascade = CascadeType.ALL,orphanRemoval = true)
	private ShoppingCart shoppingCart;
	
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "user_address_Id")
	private Address address;
	
	// helper method : to add cart to invoking user obj
	public void addCart(ShoppingCart shoppingCart)
	{
		this.shoppingCart = shoppingCart;
		shoppingCart.setShoopingCartOwner(this);
	}
}
