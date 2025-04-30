package com.nit.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class ProductDTO {

    private String productId;
    private String productName;
    private Double productPrice;

}
