
package com.app.amazon.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.app.amazon.Entities.User;

@SuppressWarnings("serial")
public class CustomerUserDetails implements UserDetails {

	private User user;

	@Override
	public String toString() {
		return user.toString();
	}

	public CustomerUserDetails(User user) {
		super();
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// Meaning : This method should ret Collection(List) of granted authorities ,
		// for a specific user --which will be later stored in Auth obj
		// SimpleGrantedAuthority(String roleName) imple GrantedAuthority
		// UserEntity ---> Role
		List<SimpleGrantedAuthority> list = new ArrayList<SimpleGrantedAuthority>();
		list.add(new SimpleGrantedAuthority(user.getUserRole().name()));
		return list;
		
//		  user.getRole() // Set<Role> .stream() // Stream<Role> .map(role -> new
//		  SimpleGrantedAuthority(role.getRoleName().name())) //
//		  Stream<SimpleGrantedAuthority> .collect(Collectors.toList());
		 
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
