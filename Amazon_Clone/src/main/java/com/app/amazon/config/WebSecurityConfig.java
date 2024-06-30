/*
package com.app.amazon.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.app.amazon.filters.JWTRequestFilter;

@EnableMethodSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfiguration {

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private JWTRequestFilter filter;

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

		authProvider.setUserDetailsService(userDetailsService);
		authProvider.setPasswordEncoder(encoder);

		return authProvider;
	}

	@Bean 
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.cors()
		.and()
		.csrf()
		.disable().authorizeRequests().requestMatchers("/**").permitAll()
//		.antMatchers("/admin/**").hasRole("ADMIN")
//		.antMatchers("/buyer/**").hasAnyRole("BUYER", "ADMIN")
//		.antMatchers("/owner/**").hasAnyRole("OWNER", "ADMIN")
//		.antMatchers("/user/**").hasAnyRole("OWNER","BUYER", "ADMIN")
//	    .antMatchers("/api/category**").hasAnyRole("CUSTOMER","ADMIN")
//	    .antMatchers("/api/api/seller/**").hasAnyRole("SUPPLIER","ADMIN")
//	    .antMatchers("/api/deliboy/**").hasAnyRole("DELIVERYBOY")
//	    .antMatchers("/api/user/delete").hasAnyRole("DELIVERYBOY","CUSTOMER","ADMIN","SUPPLIER")
//	    .antMatchers("/api/home","/api/auth/**","/report/**","/api/user/newpassword").permitAll() 
//	    .and().
//		 authorizeRequests()
//		.antMatchers("/api/prod/add").hasRole("ADMIN")
//		.antMatchers("/api/product/{prodId}").hasRole("ADMIN")
//		.antMatchers("/api/product/purchase").hasRole("CUSTOMER")
//		.antMatchers("/api/product/{catName}", "/auth/**","/report/**").permitAll()
		// enabling
		// global
		// access to
		// all urls
		// with
		// /api/auth
		// only for JS clients (react / angular)
		.requestMatchers(HttpMethod.OPTIONS).permitAll().and().sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
		.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
  
  return http.build(); }

	// configure auth mgr bean : to be used in Auth REST controller

	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return authenticationManagerBean();
	}
}
*/
