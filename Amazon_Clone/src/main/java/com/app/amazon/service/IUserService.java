package com.app.amazon.service;

import java.util.List;

import com.app.amazon.DTO.UserDTO;
import com.app.amazon.Entities.User;

import jakarta.validation.Valid;

public interface IUserService {

	User saveNewUser(@Valid UserDTO userObj); 
	
	UserDTO getUserByEmail(String userEmail);

	List<User> getAllUsers();
}
