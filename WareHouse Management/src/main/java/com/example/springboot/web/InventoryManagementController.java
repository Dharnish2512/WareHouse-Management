package com.example.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.springboot.service.UserService;
import com.example.springboot.web.dto.inventorymanagementDto;

@Controller
@RequestMapping(("/index"))
public class InventoryManagementController {
	private UserService userService;
	public InventoryManagementController(UserService userService) {
		super();
		this.userService=userService;
	}
	
	@ModelAttribute("inventory")
	public inventorymanagementDto inventorymanagementDto() {
		return new inventorymanagementDto();
	}
	
	@GetMapping
	public String showRegistrationForm() {
		return "index";
	}
	
	@PostMapping
	public String registerStringUserAccount(@ModelAttribute("inventory") inventorymanagementDto inventorymanagementDto) {
		userService.save(inventorymanagementDto);
		return "redirect:/index?success";
	}
}
