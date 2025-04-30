package com.nit.model;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ProductModel {

    @NotBlank(message = "Name is Required")
    @Size(min = 4, max = 20)
    private String productName;

    @Positive
    @NotNull
    private Double productprice;

    @Email
    @NotBlank
    @Column(name = "COMPANTEMAIL", unique = true)
    private String companyEmail;

    private String categoriesId;

}
