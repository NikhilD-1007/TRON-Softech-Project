package com.app.amazon.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.amazon.Entities.Categories;

@Repository
public interface CategoryRepositiory extends JpaRepository<Categories, Long> {

	Optional<Categories> findByCategoryNameIgnoreCase(String cateName);

	

}
