package com.nit.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.nit.entity.Category;

public interface ICategorieService {
	
	 //Create multiple categories
	 public List<Category> createCategories(List<Category> categories);
	 
	 //Get all categories by pagination
	 public Page<Category> getAllCategories(int page);
	 
	 public Category getCategoriesById(Long id);
	 
	 public Category updateCategoriesById(Long id,Category category);
	 
	 public void deleteById(Long id);
	 
	 
}
