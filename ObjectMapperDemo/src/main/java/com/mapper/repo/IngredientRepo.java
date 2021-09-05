package com.mapper.repo;

import com.mapper.domain.Ingredient;
import com.mapper.domain.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface IngredientRepo extends JpaRepository<Ingredient, Long>{
    public Optional <Ingredient> findIngredientByName(String name);
    public boolean existsByName(String name);
}
