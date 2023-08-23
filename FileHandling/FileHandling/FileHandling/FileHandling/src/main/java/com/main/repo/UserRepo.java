package com.main.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, String> {

	Optional<User> findByEmail(String email);
}
