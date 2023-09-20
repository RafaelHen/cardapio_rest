package com.example.cardapio.food.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cardapio.modal.Food;

public interface FoodRepository extends JpaRepository<Food, Long> {

}
