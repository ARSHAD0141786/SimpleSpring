package com.example.SimpleSprintDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.SimpleSprintDemo.dto.ProductResponseDTO;
import com.example.SimpleSprintDemo.exception.ProductNotFoundException;
import com.example.SimpleSprintDemo.service.ProductService;

@RestController
@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	public ProductController(@Qualifier("fakeStoreProductService") ProductService ps) {
		this.productService = ps;
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<ProductResponseDTO> getProduct(@PathVariable("id") int id) throws ProductNotFoundException {
		return ResponseEntity.ok(this.productService.getProductById(id));
	}
	
	@GetMapping("/products")
	public ResponseEntity<List> getAllProducts() {
		List<ProductResponseDTO> products = this.productService.getAllProducts();
		return ResponseEntity.ok(products);
	}
}
