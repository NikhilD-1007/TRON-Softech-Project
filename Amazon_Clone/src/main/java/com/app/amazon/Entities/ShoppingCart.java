package com.app.amazon.Entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "shooping_cart")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ShoppingCart extends BaseEntity {

	/*
	 * @Id
	 * 
	 * @GeneratedValue(strategy =GenerationType.IDENTITY )
	 * 
	 * @Column(name = "shop_cart_id") private Long shoppingCartId;
	 */

	@Column(name = "total_items")
	private int totalItems;

	@Column(name = "total_items_price")
	private double totalPrice;

	@CreationTimestamp
	@Column(name = "created_on")
	private LocalDate cartCreatedOn;

	@UpdateTimestamp
	@Column(name = "last_updated_on")
	private LocalDate lastUpdatedOn;

	// Cart HAS-A Customer Cart ----> User
	// Cart : one , child , owning
	@OneToOne
	@JoinColumn(name = "userId", nullable = false)
	private User shoopingCartOwner;
	
	//Cart ---> CartItems : one to many
	@JsonIgnore
	@OneToMany(mappedBy = "shopCart",orphanRemoval = true,cascade = CascadeType.ALL) 
	private List<CartContainItems> cartItems = new ArrayList<>();


}
