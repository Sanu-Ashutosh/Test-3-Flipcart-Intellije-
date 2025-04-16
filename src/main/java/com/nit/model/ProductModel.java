package com.nit.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ProductModel  {
	
	private String productName;
	private Double productprice;
	private Long categoriesId;

}
