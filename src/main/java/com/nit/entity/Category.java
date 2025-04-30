package com.nit.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "CATAGORY_DETAILS")
public class Category {
    @Id
    @Column(length = 20)
    private String categoryId;

    @NotBlank(message = "Name is Required")
    @Size(min = 4, max = 30)
    private String categoryName;

    @OneToMany(mappedBy = "categories", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Product> allProduct;
}
