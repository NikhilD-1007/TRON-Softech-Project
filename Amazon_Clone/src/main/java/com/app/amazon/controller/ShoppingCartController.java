package com.app.amazon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.amazon.DTO.ShoppingCartDTO;
import com.app.amazon.Entities.ShoppingCart;
import com.app.amazon.exception.UserHandlingException;
import com.app.amazon.service.IShoppingCartService;

@RestController
@RequestMapping("/api/shopping_cart")
public class ShoppingCartController {

	@Autowired
	private IShoppingCartService cartService;

	@PostMapping("/add")
	public ResponseEntity<?> addProductsInCart(@RequestBody ShoppingCartDTO cartDTO) throws UserHandlingException {
		cartService.addProduct(cartDTO.getCustomerId(), cartDTO.getProductId(), cartDTO.getQuantity());
		return new ResponseEntity<>("Product Added into cart Successfully", HttpStatus.OK);
	}

	@GetMapping("/allData")
	public List<ShoppingCart> getAllShoCart() {
		return cartService.getAllCartsDeta();
	}
}
