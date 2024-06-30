package com.app.amazon.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.amazon.DTO.ProductDTO;
import com.app.amazon.Entities.Categories;
import com.app.amazon.Entities.Products;
import com.app.amazon.exception.resourceNotFoundException;
import com.app.amazon.repository.CategoryRepositiory;
import com.app.amazon.repository.ProductRepositiory;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements IProductService{

	@Autowired
	private ProductRepositiory prodRepo;
	
	@Autowired
	private CategoryRepositiory cateRepo;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public List<Products> getAllProductsDetails() {
		
		return prodRepo.findAll();
	}

	@Override
	public ResponseEntity<String> addNewProductDetails(Products prodObj, Long cateId ) {
		Categories category = cateRepo.findById(cateId).get();
		if(category != null)
		{
			category.addNewProduct(prodObj);
			prodObj.addNewCategory(category);
			//prodRepo.save(prodObj);
			String msg = "DONE. New Product added.";
			return new ResponseEntity<String>(msg,HttpStatus.CREATED);
		}
		
		//Products prod = mapper.map(prodObj, Products.class);
		//prodRepo.save(prod);
		return new ResponseEntity<String>("Error !!! New Product does not added",HttpStatus.NO_CONTENT);
		
	}

	@Override
	public ResponseEntity<String> updateProduct(ProductDTO prodObj) {
		
		if(prodRepo.existsById(prodObj.getId()))
		{
			Products updtProd = mapper.map(prodObj, Products.class);
			prodRepo.save(updtProd);
			String msg = "Product updated successfully";
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}else
		{
			return new ResponseEntity<String>("Product not found",HttpStatus.BAD_REQUEST);
		}
		
	}

	@Override
	public String deleteProductById(Long prodId) {
		String msg = "Product deleted.";
		if(prodRepo.existsById(prodId))
		{
			prodRepo.deleteById(prodId);
			return msg;
		}
		return "Product not found";
	}

	@Override
	public List<Products> getAllProductsByCategoryName(String cateName) {
		
		Categories cateObj = cateRepo.findByCategoryNameIgnoreCase(cateName).get(); //here .get is imp 
		
		
		return prodRepo.findByProductCategory(cateObj);
	}

	@Override
	public Products getProductByProductId(Long prodId) {
		Products prod = prodRepo.findById(prodId).get();
		
		return prod;
	}
}
