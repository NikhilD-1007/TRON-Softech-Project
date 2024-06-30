package com.app.amazon.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.amazon.DTO.CategoryDTO;
import com.app.amazon.Entities.Categories;
import com.app.amazon.exception.resourceNotFoundException;
import com.app.amazon.repository.CategoryRepositiory;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CategoryServiceImpl implements ICategoryService {


	@Autowired
	private CategoryRepositiory categoryRepo;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public List<Categories> getAllCategories() {
		
		return categoryRepo.findAll();
	}

	@Override
	public ResponseEntity<String> addNewCategory(CategoryDTO newCateObj) {
		Categories cate =mapper.map(newCateObj, Categories.class);
		categoryRepo.save(cate);
		String msg ="Category added successfully";
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> updateCategory(CategoryDTO updtCate) throws resourceNotFoundException {
		String msg = "Category details have been updated successfully";
		Categories cate = categoryRepo.findById(updtCate.getCategoryID()).orElseThrow(()-> new resourceNotFoundException("Category not found"));
		cate.setCategoryDescription(updtCate.getCategoryDescription());
		cate.setCategoryName(updtCate.getCategoryName());
		cate.setCategoryStatus(updtCate.getCategoryStatus());
		cate.setImageUrl(updtCate.getImageUrl());
		categoryRepo.save(cate);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> deleteCategoryById(Long cateId) throws resourceNotFoundException {
		Categories catObj = categoryRepo.findById(cateId).orElseThrow(()-> new resourceNotFoundException("Category Not found"));
		categoryRepo.deleteById(cateId);
		String msg = "Category Deleted Successfully";
		
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
}
