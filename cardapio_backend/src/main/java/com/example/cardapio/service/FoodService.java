package com.example.cardapio.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.cardapio.dto.FoodDTO;
import com.example.cardapio.food.repository.FoodRepository;
import com.example.cardapio.modal.Food;
import com.example.cardapio.controller.MapperConfiguration;

@Service
public class FoodService {

	private Logger logger = Logger.getLogger(FoodService.class.getName());

	@Autowired
	ModelMapper mapper;

	@Autowired
	FoodRepository foodRepository;

	public List<FoodDTO> getAll() {
		List<Food> food = foodRepository.findAll();
		List<FoodDTO> foodDTO = new ArrayList<FoodDTO>();
		for (Food food2 : food) {
			FoodDTO dto = mapper.map(food2, FoodDTO.class);
			foodDTO.add(dto);
		}
		
		return foodDTO;
	}

	public FoodDTO create (FoodDTO data) {
		logger.info("Comida registrada!");	
		Food food = mapper.map(data, Food.class);
		foodRepository.save(food);
		return data;
		
	}

}
