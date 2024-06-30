package com.app.amazon.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "product_tbl")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Products extends BaseEntity{


	@Column(name = "prod_Name", length = 200, nullable = false)
	private String productName;
	
	@Column(name = "prod_Desc",length = 500, nullable = false)
	private String productDescription;
	
	@Column(name = "prod_Price")
	private double unitProdPrice;
	
	@Column(name = "prod_Quantity")
	private int prodQuantity;
	
	@Column(length = 150)
	private String prodImgUrl;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "prod_Status")
	private Status prodStatus;
	//Before Relations 
	//id, prod_img_url, prod_quantity, prod_status, prod_desc, prod_name, prod_price
	
	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "Category_Cid")
	private Categories productCategory;
	
	//After Relations 
	//id, prod_img_url, prod_quantity, prod_status, prod_desc, prod_name, prod_price, category_cid
	
	// hepler method for adding seed category
	public void addNewCategory(Categories cateObj)
	{
		this.setProductCategory(cateObj);
	}
	
}
