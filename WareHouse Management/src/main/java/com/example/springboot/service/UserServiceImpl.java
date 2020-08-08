package com.example.springboot.service;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.example.springboot.model.user;
import com.example.springboot.model.inventory;
import com.example.springboot.model.role;
import com.example.springboot.repository.InventoryRepository;
import com.example.springboot.repository.UserRepository;
import com.example.springboot.web.dto.UserRegistrationDto;
import com.example.springboot.web.dto.inventorymanagementDto;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private InventoryRepository inventoryRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public user save(UserRegistrationDto registrationDto) {
		//if(registrationDto.getRoles().compareTo("WarehouseManager")==0) {
			user user = new user(registrationDto.getFirstName(), 
				registrationDto.getLastName(), registrationDto.getEmail(),
				passwordEncoder.encode(registrationDto.getPassword()), Arrays.asList(new role("WarehouseManager")));
		
		return userRepository.save(user);
		/*}
		else {
			user user = new user(registrationDto.getFirstName(), 
					registrationDto.getLastName(), registrationDto.getEmail(),
					passwordEncoder.encode(registrationDto.getPassword()), Arrays.asList(new role("DeliveryAgent")));
			
			return userRepository.save(user);
		}*/
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		user user = userRepository.findByEmail(username);
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));		
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<role> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

	@Override
	public inventory save(inventorymanagementDto managementDto) {
		inventory inventory = new inventory(managementDto.getIProduct(),managementDto.getCount(),
				managementDto.getIDate());
		return inventoryRepository.save(inventory);
	}
	
}