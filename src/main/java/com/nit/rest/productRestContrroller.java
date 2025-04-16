package com.nit.rest;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nit.entity.Category;
import com.nit.entity.Product;
import com.nit.model.ProductModel;
import com.nit.service.IProductService;

@RestController
@RequestMapping("/product")
public class productRestContrroller {
	
	@Autowired
	private IProductService service;

	@PostMapping("/add")
	public ResponseEntity<String> addAllCatgories(@RequestBody List<ProductModel> product){


		if(product!=null) {
			service.createProduct(product);
			return new ResponseEntity<String>("Product added sucessfully", HttpStatus.OK);
		}
		
		return new ResponseEntity<String>("Internal Server ERROR!!!!", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("/pagging")
	public ResponseEntity<?> getAllProduct(@RequestParam(defaultValue = "0") int page){
		System.out.println("ashu");
		Page<Product> allByPage = service.getAllByPage(page);
		return allByPage != null ? new ResponseEntity<>("allByPage1", HttpStatus.OK)
				: new ResponseEntity<>("No Data found", HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/find")
	public ResponseEntity<?> getById(@RequestParam Long id) {
		 Product productById = service.getProductById(id);
		return productById != null ? new ResponseEntity<>(productById, HttpStatus.OK)
				: new ResponseEntity<>("Category not found", HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/update")
	public ResponseEntity<String> updateById(@RequestParam Long id,@RequestBody Product product) {
		 Product updateProductById = service.updateProductById(id,product);
		return updateProductById != null ? new ResponseEntity<>("Update Sucessful", HttpStatus.OK)
				: new ResponseEntity<>("Category not found", HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/delete")
	public ResponseEntity<?> deleteById(@RequestParam Long id) {

		service.deleteProductById(id);
		return  new ResponseEntity<>("Delete Sucessful", HttpStatus.OK);
	}


}
