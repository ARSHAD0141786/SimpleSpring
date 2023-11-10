package com.example.EcommerceProductService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.EcommerceProductService.dto.ProductRequestDTO;
import com.example.EcommerceProductService.dto.ProductResponseDTO;
import com.example.EcommerceProductService.exception.ProductNotFoundException;
import com.example.EcommerceProductService.service.ProductService;

@RestController
@Controller
public class ProductController {
	
	private ProductService productService;
	
	
	public ProductController(@Qualifier("productServiceImpl") ProductService ps) {
		this.productService = ps;
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<ProductResponseDTO> getProduct(@PathVariable("id") Integer id) throws ProductNotFoundException {
		return ResponseEntity.ok(this.productService.getProductById(id));
	}
	
	@GetMapping("/products")
	public ResponseEntity<List> getAllProducts() {
		List<ProductResponseDTO> products = this.productService.getAllProducts();
		return ResponseEntity.ok(products);
	}
	
	@PostMapping("/products")
	public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductRequestDTO product){
		return ResponseEntity.ok(this.productService.create(product));
	}
	
	@PutMapping("/products/{id}")
	public ResponseEntity<Boolean> updateProduct(@PathVariable("id") Integer id, @RequestBody ProductRequestDTO product){
		return ResponseEntity.ok(true);
	}
	
	@DeleteMapping("/products/{id}")
	public ResponseEntity<Boolean> removeProduct(@PathVariable("id") Integer id){
		this.productService.remove(id);
		return ResponseEntity.ok(true);
	}
}
