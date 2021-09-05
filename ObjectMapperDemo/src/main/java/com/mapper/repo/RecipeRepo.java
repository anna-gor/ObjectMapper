package com.mapper.repo;

import com.mapper.domain.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RecipeRepo extends JpaRepository<Recipe, Long>{

}
