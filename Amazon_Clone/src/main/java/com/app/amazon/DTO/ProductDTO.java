package com.app.amazon.DTO;

import com.app.amazon.Entities.Categories;
import com.app.amazon.Entities.Status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProductDTO {

	private Long id;
	private String productName;
	private String productDescription;
	private double unitProdPrice;
	private int prodQuantity;
	private String prodImgUrl;
	private Status prodStatus;
}
