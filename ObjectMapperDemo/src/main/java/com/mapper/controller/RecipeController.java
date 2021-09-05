package com.mapper.controller;

import java.util.List;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mapper.domain.Recipe;
import com.mapper.repo.RecipeRepo;

@RestController
public class RecipeController {

	@Autowired private RecipeRepo repo;
	
	@GetMapping("/findAllStudent")
	@SneakyThrows
	public List<Recipe> getAllStudent() {
		List<Recipe> recipes = repo.findAll();
		return recipes;
	}
	
//	@GetMapping("/findAllStudent/new")
//	public ResponseEntity<?> getAllStudents() throws JsonProcessingException{
//		List<Student> students = repo.findAll();
//
//		ObjectMapper mapper = new ObjectMapper();
//		mapper.addMixIn(Student[].class, StudentIgnoreMixin[].class);
//
//		String jsonString = mapper.writeValueAsString(students);
//
//
//		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(jsonString);
//	}
	
}
