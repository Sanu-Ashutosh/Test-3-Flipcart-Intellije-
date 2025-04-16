package com.nit.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.entity.Product;

public interface IProductRepositary extends JpaRepository<Product, Long> {

}
