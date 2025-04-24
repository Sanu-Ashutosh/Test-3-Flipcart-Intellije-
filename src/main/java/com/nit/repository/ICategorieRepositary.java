package com.nit.repository;

import com.nit.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategorieRepositary extends JpaRepository<Category, Long> {

}
