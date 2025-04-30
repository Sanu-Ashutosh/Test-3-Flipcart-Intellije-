package com.nit.repository;

import com.nit.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepositary extends JpaRepository<Product, String> {

}
