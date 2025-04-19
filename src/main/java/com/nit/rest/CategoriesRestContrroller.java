package com.nit.rest;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nit.entity.Category;
import com.nit.service.ICategorieService;

@RestController
@RequestMapping("/V1/categories")
public class CategoriesRestContrroller {

	@Autowired
	private ICategorieService service;

	@PostMapping("/add")
	public ResponseEntity<String> addAllCatgories(@RequestBody List<Category> allcategories) {

		if (allcategories != null) {
			service.createCategories(allcategories);
			return new ResponseEntity<String>("All categories are added", HttpStatus.OK);
		}

		return new ResponseEntity<String>("Internal Server ERROR!!!!", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping("/pagging")
	public ResponseEntity<?> getAllCategories(@RequestParam(defaultValue = "0") int page) {
		Page<Category> allCategories = service.getAllCategories(page);
		return allCategories != null ? new ResponseEntity<>(allCategories, HttpStatus.OK)
				: new ResponseEntity<>("No Data found", HttpStatus.NO_CONTENT);
	}

	@GetMapping("/find")
	public ResponseEntity<?> getById(@RequestParam Long id) {
		Category categoriesById = service.getCategoriesById(id);
		return categoriesById != null ? new ResponseEntity<>(categoriesById, HttpStatus.OK)
				: new ResponseEntity<>("Category not found", HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/update")
	public ResponseEntity<String> updateById(@RequestParam Long id,@RequestBody Category category) {
		Category categoriesById = service.updateCategoriesById(id,category);
		return categoriesById != null ? new ResponseEntity<>("Update Sucessful", HttpStatus.OK)
				: new ResponseEntity<>("Category not found", HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/delete")
	public ResponseEntity<?> deleteById(@RequestParam Long id) {
		System.out.println(LocalDateTime.now());
		 service.deleteById(id);
		return  new ResponseEntity<>("Delete Sucessful", HttpStatus.OK);
	}
	

}
