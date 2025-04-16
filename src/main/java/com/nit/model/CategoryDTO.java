package com.nit.model;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class CategoryDTO {
	
	private Long categoryId;
    private String categoryName;
    private List<ProductDTO> allProduct;
    
}
