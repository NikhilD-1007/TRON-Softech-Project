package com.app.amazon.Entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_tbl")
public class Orders extends BaseEntity{

	@CreationTimestamp
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate orderPlacedDate;
	
	// one user can put many orders
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User customer;
	
	// one order can have one delivery address
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cust_delivery_addre_id")
	private Address custDeliveryAddress;
	
	//@JsonIgnore
	@OneToMany(mappedBy = "order",cascade = CascadeType.ALL,orphanRemoval = true)
	private Set<OrderDetails> orderDetails = new HashSet<>();
	
	
}
