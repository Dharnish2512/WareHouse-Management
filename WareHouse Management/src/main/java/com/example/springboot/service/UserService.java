package com.example.springboot.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.springboot.model.inventory;
import com.example.springboot.model.user;
import com.example.springboot.web.dto.UserRegistrationDto;
import com.example.springboot.web.dto.inventorymanagementDto;

public interface UserService extends UserDetailsService{
	user save(UserRegistrationDto registrationDto);
	
	inventory save(inventorymanagementDto managementDto);

}
