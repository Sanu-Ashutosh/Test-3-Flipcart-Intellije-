package com.nit.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.nit.entity.Category;
import com.nit.entity.Product;
import com.nit.model.ProductModel;
import com.nit.repositary.ICategorieRepositary;
import com.nit.repositary.IProductRepositary;

@Service
public class ProductServiceIMPL implements IProductService {

	@Autowired
	private IProductRepositary repo;

	@Autowired
	private ICategorieRepositary catrepo;

	@Override
	public List<Product> createProduct(List<ProductModel> data) {
		// TODO Auto-generated method stub
		List<Product> savedProducts = data.stream().map(pdata -> {
			Product product = new Product();
			product.setProductName(pdata.getProductName());
			product.setProductprice(pdata.getProductprice());

			// Fetch the category and handle the case where it might not exist
			Category category = catrepo.findById(pdata.getCategoriesId()).orElse(null);
			if (category != null) {
				product.setCategories(category);
			} else {
				// Handle the case where the category is not found, e.g. throw an exception or
				// log
				throw new IllegalArgumentException("Category with ID " + pdata.getCategoriesId() + " not found");
			}

			return repo.save(product); // Save and return the product
		}).collect(Collectors.toList()); // Collect into a list

		return savedProducts;
	}

	@Override
	public Page<Product> getAllByPage(int page) {
		// TODO Auto-generated method stub
		Page<Product> all = repo.findAll(PageRequest.of(page, 4));
		return all;
	}

	@Override
	public Product getProductById(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}

	@Override
	public Product updateProductById(Long id,Product product) {
		// TODO Auto-generated method stub
		Product productById = getProductById(id);
		productById.setProductName(product.getProductName());
		productById.setProductprice(product.getProductprice());
		return repo.save(productById);
	}

	@Override
	public void deleteProductById(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

}
