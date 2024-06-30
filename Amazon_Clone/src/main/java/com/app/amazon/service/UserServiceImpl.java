package com.app.amazon.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.amazon.DTO.UserDTO;
import com.app.amazon.Entities.User;
import com.app.amazon.repository.UserRepositiory;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepositiory userRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private ModelMapper mapper;

	@Override
	public List<User> getAllUsers() {
		List<User> allUser = userRepo.findAll();
		return allUser;
	}

	@Override
	public User saveNewUser(UserDTO userObj) {
		log.info("In User Service Imple: Save New User");
		userObj.setPassword(passwordEncoder.encode(userObj.getPassword()));
		User user = mapper.map(userObj, User.class);
		user.setPassword(passwordEncoder.encode(user.getPassword()));

		User addNewUser = userRepo.save(user);

		return addNewUser;
	}

	@Override
	public UserDTO getUserByEmail(String userEmail) {
		User user = userRepo.findByEmail(userEmail).orElseThrow(() -> new RuntimeException("User Not Found"));
		return mapper.map(user, UserDTO.class);
	}

}
