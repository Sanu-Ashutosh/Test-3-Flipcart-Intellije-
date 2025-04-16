package com.nit.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.entity.Category;

public interface ICategorieRepositary extends JpaRepository<Category, Long> {
	
;
}
