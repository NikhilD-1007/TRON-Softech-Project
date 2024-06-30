package com.app.amazon.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.amazon.DTO.ShoppingCartDTO;
import com.app.amazon.Entities.CartContainItems;
import com.app.amazon.Entities.Products;
import com.app.amazon.Entities.ShoppingCart;
import com.app.amazon.Entities.User;
import com.app.amazon.exception.UserHandlingException;
import com.app.amazon.repository.CartContainItemsRepositiory;
import com.app.amazon.repository.ProductRepositiory;
import com.app.amazon.repository.ShoppingCartRepositiory;
import com.app.amazon.repository.UserRepositiory;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ShoppingCartServiceImpl implements IShoppingCartService {

	@Autowired
	private ShoppingCartRepositiory shopCartRepo;
	
	@Autowired
	private UserRepositiory custRepo;
	
	@Autowired
	private ProductServiceImpl prodService;
	
	@Autowired
	private CartContainItemsRepositiory cartRepo;
	
	@Autowired
	private ModelMapper mapper;
	

	@Override
	public int addProduct(Long customerId, Long productId, int quantity) throws UserHandlingException {
		// TODO Auto-generated method stub
		Optional<User> optionalCustomer=custRepo.findById(customerId);
		User customer = new User();
		if(optionalCustomer !=null)
		{
			customer = mapper.map(optionalCustomer, User.class);
		}else
		{
			throw new UserHandlingException("NO cart details are found for given customer id");
		}
		Products product = mapper.map(prodService.getProductByProductId(productId), Products.class);
		
		CartContainItems cartItem = cartRepo.findByUserAndProduct(customer,product);
		int updateQuantity = quantity;
		
		if(cartItem != null)
		{
			updateQuantity = cartItem.getQuantity() + quantity;
			
			if(updateQuantity < 0) {
				throw new UserHandlingException("Invalid quanity");
			}
			//Customer can take MAX 10 items only
			if(updateQuantity > 10) {
				throw new UserHandlingException("Could not add more " + quantity + " item(s)"
						+ " because there's already " + cartItem.getQuantity() + " item(s) "
						+ "in your shopping cart. Maximum allowed quantity is 10.");
			}
		}else
		{
			cartItem = new CartContainItems();
			cartItem.setUser(customer);
			cartItem.setProduct(product);
		}
		
		cartItem.setQuantity(updateQuantity);
		cartRepo.save(cartItem);
		return updateQuantity ;
	}


	@Override
	public List<ShoppingCart> getAllCartsDeta() {
		
		return shopCartRepo.findAll();
	}
}
