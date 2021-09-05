package com.mapper.startup;

import com.mapper.domain.Ingredient;
import com.mapper.domain.Recipe;
import com.mapper.repo.IngredientRepo;
import com.mapper.repo.RecipeRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Component
public class RecipeService {
    private static final Logger log = LoggerFactory.getLogger(StartupUility.class);

    private final RecipeRepo repo;
    private final IngredientRepo ingredientRepo;

    public RecipeService(RecipeRepo repo, IngredientRepo ingredientRepo) {
        this.repo = repo;
        this.ingredientRepo = ingredientRepo;
    }

    @Transactional
    public void saveRecipes(Recipe[] recipes) {

        for (Recipe s : recipes) {
            ArrayList<Ingredient> ingredientArrayList = new ArrayList<Ingredient>();
//                for (Ingredient ingredient : s.getIngredients()) {
//                    Optional<Ingredient> ingredientByName = ingredientRepo.findIngredientByName(ingredient.getName());
//                    ingredientByName.ifPresent(value -> ingredient.setId(value.getId()));
//                }
            for (Ingredient ingredient : s.getIngredients()) {
                if (ingredientRepo.existsByName(ingredient.getName())) {
                    ingredientArrayList.add(ingredient);
                } else {
                    Ingredient save = ingredientRepo.save(ingredient);
                    ingredientArrayList.add(save);
                }
            }
            s.setIngredients(ingredientArrayList);
            log.info("Preloading " + repo.save(s));
            ingredientRepo.saveAllAndFlush(s.getIngredients());
        }
    }
}
