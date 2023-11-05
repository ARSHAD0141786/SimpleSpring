package com.example.SimpleSprintDemo.service;

import java.util.List;

import com.example.SimpleSprintDemo.dto.ProductRequestDTO;
import com.example.SimpleSprintDemo.dto.ProductResponseDTO;
import com.example.SimpleSprintDemo.exception.ProductNotFoundException;

public interface ProductService {
	ProductResponseDTO create(ProductRequestDTO p);
	Boolean update(int id, ProductRequestDTO p);
	Boolean remove(int id);
	ProductResponseDTO getProductById(int id) throws ProductNotFoundException;
	List<ProductResponseDTO> getAllProducts();
}
