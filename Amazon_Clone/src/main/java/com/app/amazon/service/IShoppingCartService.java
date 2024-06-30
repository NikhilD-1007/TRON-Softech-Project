package com.app.amazon.service;

import java.util.List;

import com.app.amazon.DTO.ShoppingCartDTO;
import com.app.amazon.Entities.ShoppingCart;
import com.app.amazon.exception.UserHandlingException;

public interface IShoppingCartService {

	int addProduct(Long customerId, Long productId, int quantity) throws UserHandlingException;

	List<ShoppingCart> getAllCartsDeta();

}
