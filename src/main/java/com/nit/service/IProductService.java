package com.nit.service;



import java.util.List;

import org.springframework.data.domain.Page;

import com.nit.entity.Product;
import com.nit.model.ProductModel;

public interface IProductService {

	public List<Product> createProduct(List<ProductModel> product);
	
	public Page<Product> getAllByPage(int page);
	
	public Product getProductById(Long id);
	
	public Product updateProductById(Long id,Product product);
	
	public void deleteProductById(Long id);
}
