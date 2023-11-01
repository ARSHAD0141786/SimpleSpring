package com.example.SimpleSprintDemo.service;

import java.util.List;

import com.example.SimpleSprintDemo.dto.ProductRequestDTO;
import com.example.SimpleSprintDemo.dto.ProductResponseDTO;

public interface ProductService {
	ProductResponseDTO create(ProductRequestDTO p);
	void update(int id, ProductRequestDTO p);
	void remove(int id);
	ProductResponseDTO getProductById(int id);
	List<ProductResponseDTO> getAllProducts();
}
