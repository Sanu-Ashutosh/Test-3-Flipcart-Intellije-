package com.nit.controller;

import com.nit.entity.Product;
import com.nit.model.ProductModel;
import com.nit.service.IProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("V1/product")
public class productRestContrroller {

    @Autowired
    private IProductService service;

    @PostMapping("/add")
    public ResponseEntity<String> addAllCatgories(@Valid @RequestBody List<@Valid ProductModel> product) {


        if (product != null) {
            service.createProduct(product);
            return new ResponseEntity<String>("Product added sucessfully", HttpStatus.OK);
        }

        return new ResponseEntity<String>("Internal Server ERROR!!!!", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/pagging")
    public ResponseEntity<?> getAllProduct(@RequestParam(defaultValue = "0") int page) {
        System.out.println("ashu");
        Page<Product> allByPage = service.getAllByPage(page);
        return allByPage != null ? new ResponseEntity<>(allByPage, HttpStatus.OK)
                : new ResponseEntity<>("No Data found", HttpStatus.NO_CONTENT);
    }

    @GetMapping("/find")
    public ResponseEntity<?> getById(@RequestParam String id) {
        Product productById = service.getProductById(id);
        return productById != null ? new ResponseEntity<>(productById, HttpStatus.OK)
                : new ResponseEntity<>("Category not found!!!!!!", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateById(@RequestParam String id, @RequestBody Product product) {
        Product updateProductById = service.updateProductById(id, product);
        return updateProductById != null ? new ResponseEntity<>("Update Sucessful", HttpStatus.OK)
                : new ResponseEntity<>("Category not found", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/delete")
    public ResponseEntity<?> deleteById(@RequestParam String id) {

        service.deleteProductById(id);
        return new ResponseEntity<>("Delete Successful----", HttpStatus.OK);
    }


}
