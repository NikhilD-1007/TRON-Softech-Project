package com.app.amazon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.amazon.Entities.Categories;
import com.app.amazon.Entities.Products;

@Repository
public interface ProductRepositiory  extends JpaRepository<Products, Long>{

	List<Products> findByProductCategory(Categories cateObj);

	
}
