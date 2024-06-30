package com.app.amazon.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.app.amazon.DTO.ProductDTO;
import com.app.amazon.Entities.Products;

public interface IProductService {

	List<Products> getAllProductsDetails();

	ResponseEntity<String> addNewProductDetails(Products prodObj, Long cateId);

	ResponseEntity<String> updateProduct(ProductDTO prodObj);

	String deleteProductById(Long prodId);

	List<Products> getAllProductsByCategoryName(String cateName);

	Products getProductByProductId(Long prodId);

}
