package com.example.SimpleSprintDemo.service;

import java.util.List;

import com.example.SimpleSprintDemo.dto.ProductRequestDTO;
import com.example.SimpleSprintDemo.dto.ProductResponseDTO;

public interface ProductService {
	void create(ProductRequestDTO p);
	void update(ProductRequestDTO p);
	void remove(ProductRequestDTO p);
	ProductResponseDTO getProductById(int id);
	List<ProductResponseDTO> getAllProducts();
}
