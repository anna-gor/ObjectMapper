package com.mapper.startup;

import com.mapper.domain.Ingredient;
import com.mapper.domain.Recipe;
import com.mapper.repo.IngredientRepo;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mapper.repo.RecipeRepo;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

@Configuration
class StartupUility {

    private static final Logger log = LoggerFactory.getLogger(StartupUility.class);
    @Autowired
    private RecipeRepo repo;
    @Autowired
    private IngredientRepo ingredientRepo;
    //@Value("${demo.json.string}")
    @Autowired
    private RecipeService recipeService;


    @Bean
    @SneakyThrows
    @Transactional
    public CommandLineRunner initDatabase(RecipeRepo repo) {

        final ObjectMapper objectMapper = new ObjectMapper();


        Recipe[] lags = objectMapper.readValue(new File("src/main/resources/test.json"), Recipe[].class);
        return args -> {
            recipeService.saveRecipes(lags);
        };
    }
}

//@Component
//@Log
//public class StartupUility implements CommandLineRunner{
//
//
//	@Value("${demo.json.string}") private String json;
//	@Autowired private StudentRepo repo;
//
//	@Bean
//	CommandLineRunner initDatabase(StudentRepo repo) {
//
//		return args -> {
//			final ObjectMapper objectMapper = new ObjectMapper();
//		Student[] lags = objectMapper.readValue(json, Student[].class);
//		for (Student s:lags){
//
//			log.info("Preloading " + repo.save(s));
//		}
//
//		};
//	}
//
//
////	@Override
////	public void run(String... args) throws Exception {
////
////
//////		ObjectMapper mapper =new ObjectMapper();
//////		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
////
//////		Student value = mapper.readValue(json, Student.class);
//////		Student save = repo.save(value);
////
////		final ObjectMapper objectMapper = new ObjectMapper();
////		Student[] lags = objectMapper.readValue(json, Student[].class);
////		Arrays.stream(lags).forEach(x->System.out.println(x));
////
////		//log.info(" Student info "+save.toString());
////
////	}
//
//
//}
