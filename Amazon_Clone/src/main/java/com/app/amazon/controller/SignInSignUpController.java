package com.app.amazon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.amazon.DTO.UserDTO;
import com.app.amazon.Entities.AuthRequest;
import com.app.amazon.Entities.AuthResp;
import com.app.amazon.Jwt_utils.JwtUtils;
import com.app.amazon.service.IUserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/auth")
public class SignInSignUpController {

	@Autowired
	private IUserService userService;

	// dep : Auth mgr

//	@Autowired
//	private AuthenticationManager manager;

	@Autowired
	private JwtUtils utils;

	@PostMapping("/user/signup")
	public ResponseEntity<?> newUserRegistration(@RequestBody @Valid UserDTO userObj) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveNewUser(userObj));
	}

//	@PostMapping("/signin")
//	public ResponseEntity<?> validateUserCreateTokan(@RequestBody @Valid AuthRequest request) {
//		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(request.getEmail(),
//				request.getPassword());
//		try {
//			Authentication authenticationDetails = manager.authenticate(authToken);
//			UserDTO user = userService.getUserByEmail(authenticationDetails.getName());
//			return ResponseEntity
//					.ok(new AuthResp("Auth successful!", utils.generateJwtToken(authenticationDetails), user));
//
//		} catch (BadCredentialsException e) { // TODO: handle exception
//			System.out.println("Error " + e);
//			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
//		}
//	}
	
	@PostMapping("/signin")
	public ResponseEntity<?> validateUserCreateTokan(@RequestBody @Valid UserDTO request) {
		try {
			UserDTO user = userService.getUserByEmail(request.getEmail());
			return ResponseEntity.status(HttpStatus.OK).body(user);
		} catch (BadCredentialsException  e) {
			System.out.println("Error " + e);
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
		}
	}
	

}
