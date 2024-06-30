package com.app.amazon.Entities;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "cart_items")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CartContainItems extends BaseEntity{

	private int quantity;

	@Column(name = "total_price")
	private double totalPrice;
	
	// Cart 1<---* CartItem
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "cart_id",nullable = false)
	private ShoppingCart shopCart;
	
	//CartItem 1---->1 Product
	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "prod_id")
	private Products product;
	
	// User 1<---* CartItem
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private User user;
	
	@Transient
	public double getGrossTotal()
	{
		return product.getUnitProdPrice() * quantity;
	}
	
}
