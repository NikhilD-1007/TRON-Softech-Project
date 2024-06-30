package com.app.amazon.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.app.amazon.DTO.CategoryDTO;
import com.app.amazon.Entities.Categories;
import com.app.amazon.exception.resourceNotFoundException;

public interface ICategoryService {

	List<Categories> getAllCategories();

	ResponseEntity<String> addNewCategory(CategoryDTO newCateObj);

	ResponseEntity<String> updateCategory(CategoryDTO updtCate) throws resourceNotFoundException;

	ResponseEntity<String> deleteCategoryById(Long cateId) throws resourceNotFoundException;
}
