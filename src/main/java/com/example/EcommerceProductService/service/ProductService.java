package com.example.EcommerceProductService.service;

import java.util.List;

import com.example.EcommerceProductService.dto.ProductRequestDTO;
import com.example.EcommerceProductService.dto.ProductResponseDTO;
import com.example.EcommerceProductService.exception.ProductNotFoundException;

public interface ProductService {
	ProductResponseDTO create(ProductRequestDTO p);
	Boolean update(int id, ProductRequestDTO p);
	Boolean remove(int id);
	ProductResponseDTO getProductById(int id) throws ProductNotFoundException;
	List<ProductResponseDTO> getAllProducts();
}
