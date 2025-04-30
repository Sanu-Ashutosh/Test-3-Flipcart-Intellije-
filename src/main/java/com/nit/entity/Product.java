package com.nit.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "PRODUCT_DETAILS")
public class Product {

    @Id
    @Column(length = 20)
    private String productId;

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

    @ManyToOne
    @JoinColumn(name = "categorieID", referencedColumnName = "categoryId", nullable = false)
    @JsonBackReference
    private Category categories;

}
