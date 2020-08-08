package com.example.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.model.user;

@Repository
public interface UserRepository extends JpaRepository<user, Long>{
	user findByEmail(String email);
}
