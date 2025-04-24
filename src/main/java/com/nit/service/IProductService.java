package com.nit.service;

import com.nit.entity.Product;
import com.nit.model.ProductModel;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IProductService {

    List<Product> createProduct(List<ProductModel> product);

    Page<Product> getAllByPage(int page);

    Product getProductById(Long id);

    Product updateProductById(Long id, Product product);

    void deleteProductById(Long id);
}
