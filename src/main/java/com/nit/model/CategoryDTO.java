package com.nit.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class CategoryDTO {

    private String categoryId;
    private String categoryName;
    private List<ProductDTO> allProduct;

}
