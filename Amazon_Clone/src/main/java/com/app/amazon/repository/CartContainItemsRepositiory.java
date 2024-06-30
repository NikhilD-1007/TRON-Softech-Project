package com.app.amazon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.amazon.Entities.CartContainItems;
import com.app.amazon.Entities.Products;
import com.app.amazon.Entities.User;

@Repository
public interface CartContainItemsRepositiory  extends JpaRepository<CartContainItems, Long>{

	CartContainItems findByUserAndProduct(User customer, Products product);

	
}
