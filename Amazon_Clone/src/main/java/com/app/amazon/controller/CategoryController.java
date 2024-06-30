package com.app.amazon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.app.amazon.DTO.CategoryDTO;
import com.app.amazon.Entities.Categories;
import com.app.amazon.exception.resourceNotFoundException;
import com.app.amazon.service.ICategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
	
	@Autowired
	private ICategoryService cateService;
	
	@GetMapping
	public List<Categories> getAllCategories()
	{
		return cateService.getAllCategories();
	}
	
	@PostMapping
	public ResponseEntity<String> addNewCategory(@RequestBody CategoryDTO newCateObj)
	{
		return cateService.addNewCategory(newCateObj);
	}
	
	@PutMapping
	public ResponseEntity<String> updateCategory(@RequestBody CategoryDTO updtCate) throws resourceNotFoundException
	{
		return cateService.updateCategory(updtCate);
	}
	
	@DeleteMapping("/{cateId}")
	public ResponseEntity<String> deleteCategory(@PathVariable Long cateId ) throws resourceNotFoundException
	{
		return cateService.deleteCategoryById(cateId);
	}
}
