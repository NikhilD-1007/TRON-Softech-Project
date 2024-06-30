package com.app.amazon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.amazon.DTO.ProductDTO;
import com.app.amazon.Entities.Products;
import com.app.amazon.service.IProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	private IProductService prodService;
	
	@GetMapping
	public List<Products> getAllProducts()
	{
		return prodService.getAllProductsDetails();
	}
	
	// Here why we use Product and not ProductDTO? 
	//Why we get category name also?
	// How to category should be get?
	@PostMapping("/add/{cateId}")
	public ResponseEntity<String> addNewProduct(@RequestBody Products prodObj,@PathVariable Long cateId)
	{
		return prodService.addNewProductDetails(prodObj,cateId);
	}
	
	@PutMapping
	public ResponseEntity<String> updateProduct(@RequestBody ProductDTO prodObj)
	{
		return prodService.updateProduct(prodObj);
	}
	
	@DeleteMapping("/{prodId}")
	public String deleteProduct(@PathVariable Long prodId)
	{
		return prodService.deleteProductById(prodId);
	}
	
	@GetMapping("/{cateName}")
	public List<Products> getProductsByCategoryName(@PathVariable String cateName)
	{
		return prodService.getAllProductsByCategoryName(cateName);
	}
	
	@GetMapping("/get/{prodId}")
	public Products getProductById(@PathVariable Long prodId)
	{
		return prodService.getProductByProductId(prodId);
	}
}
