package com.example.cardapio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cardapio.dto.FoodDTO;
import com.example.cardapio.service.FoodService;

@RestController
@RequestMapping("food") // endpoint
public class FoodController {

	@Autowired
	FoodService foodService;

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<FoodDTO> findAll() {
		return foodService.getAll();
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping
	public FoodDTO create(@RequestBody FoodDTO data) {
		return foodService.create(data);
	}

}
