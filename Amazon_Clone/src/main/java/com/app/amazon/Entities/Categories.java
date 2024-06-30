package com.app.amazon.Entities;



import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="category_tbl")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Categories {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	@Column(name = "cate_id")
	private Long categoryID;
	
	@Column(name="cat_Name",length = 80,nullable = false,unique = true)
	private String categoryName;
	
	@Column(name = "cat_Desc", length = 200, nullable = false)
	private String categoryDescription;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "cat_Status")
	private Status categoryStatus;
	
	@Column(length = 150)
	private String imageUrl;
	//Before Relations 
	//cate_id, cat_desc, cat_name, cat_status, image_url
	
	//@JsonIgnore
	@JsonProperty(access = Access.WRITE_ONLY)
	@OneToMany(mappedBy = "productCategory",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Products> productList = new ArrayList<>();
	
	//Helper method to add New Product in category
	public void addNewProduct(Products prodObj)
	{
		this.productList.add(prodObj);
	}
}
	