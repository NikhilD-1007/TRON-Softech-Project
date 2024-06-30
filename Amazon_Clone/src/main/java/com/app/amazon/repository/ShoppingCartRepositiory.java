package com.app.amazon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.amazon.Entities.ShoppingCart;

public interface ShoppingCartRepositiory extends JpaRepository<ShoppingCart, Long>{

}
