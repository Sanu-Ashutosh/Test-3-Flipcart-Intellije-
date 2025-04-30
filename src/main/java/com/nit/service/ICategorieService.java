package com.nit.service;

import com.nit.entity.Category;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ICategorieService {

    //Create multiple categories
    List<Category> createCategories(List<Category> categories);

    //Get all categories by pagination
    Page<Category> getAllCategories(int page);

    Category getCategoriesById(String id);

    Category updateCategoriesById(String id, Category category);

    void deleteById(String id);


}
