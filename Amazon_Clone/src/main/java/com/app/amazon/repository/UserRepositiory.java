package com.app.amazon.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.amazon.Entities.User;

@Repository
public interface UserRepositiory extends JpaRepository<User, Long>{

	Optional<User> findByEmail(String userEmail);

}
