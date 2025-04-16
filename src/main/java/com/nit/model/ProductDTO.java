package com.nit.model;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class ProductDTO {
	
	private Long productId;
    private String productName;
    private Double productPrice;
    
}
