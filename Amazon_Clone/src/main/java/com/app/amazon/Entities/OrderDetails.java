package com.app.amazon.Entities;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "order_details_tbl")
public class OrderDetails extends BaseEntity{

	@Column(name = "prod_name")
	private String productName;
	
	
	private int quantity;
	
	@Column(name = "unit_price")
	private double unitPriceProduct;
	
	@Column(name = "sub_total")
	private double grossSubTotal;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "order_id",referencedColumnName = "id")
	private  Orders order;
}
