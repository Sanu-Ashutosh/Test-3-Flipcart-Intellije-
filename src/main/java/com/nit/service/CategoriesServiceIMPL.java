package com.nit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.nit.entity.Category;
import com.nit.repositary.ICategorieRepositary;

@Service
public class CategoriesServiceIMPL implements ICategorieService {
	@Autowired
	private ICategorieRepositary repo;

	@Override
	public List<Category> createCategories(List<Category> categories) {
		// TODO Auto-generated method stub
		List<Category> saveAll = repo.saveAll(categories);
		return saveAll;
	}

	@Override
	public Page<Category> getAllCategories(int page) {
		// TODO Auto-generated method stub
		Page<Category> all = repo.findAll(PageRequest.of(page, 4));
		System.out.println(all);
		return all;
	}

	@Override
	public Category getCategoriesById(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}

	@Override
	public Category updateCategoriesById(Long id,Category category) {
		// TODO Auto-generated method stub
		Category categoriesById = getCategoriesById(id);
		categoriesById.setCategoryName(category.getCategoryName());		
		return repo.save(categoriesById);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
		repo.deleteById(id);
	}
}
