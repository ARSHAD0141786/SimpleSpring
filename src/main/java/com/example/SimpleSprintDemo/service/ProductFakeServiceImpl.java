package com.example.SimpleSprintDemo.service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.SimpleSprintDemo.dto.ProductRequestDTO;
import com.example.SimpleSprintDemo.dto.ProductResponseDTO;

/**
 * This class with call a third party APIs, to manipulate products.
 */

@Service("fakeStoreProductService")
public class ProductFakeServiceImpl implements ProductService {

	@Autowired
	RestTemplateBuilder restTemplateBuilder;
	
	@Override
	public void create(ProductRequestDTO p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(ProductRequestDTO p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(ProductRequestDTO p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ProductResponseDTO getProductById(int id) {
		String getAllProductsUrl = "https://fakestoreapi.com/products/" + id;
		RestTemplate restTemplate = restTemplateBuilder.build();
		ResponseEntity<ProductResponseDTO> product = restTemplate.getForEntity(getAllProductsUrl, ProductResponseDTO.class);
		
		return product.getBody();
	}

	@Override
	public List getAllProducts() {
		String getAllProductsUrl = "https://fakestoreapi.com/products";
		RestTemplate restTemplate = restTemplateBuilder.build();
		ResponseEntity<ProductResponseDTO[]> productsList = restTemplate.getForEntity(getAllProductsUrl, ProductResponseDTO[].class);
		
		List<ProductResponseDTO> allProducts = new ArrayList<>();
		
		for(ProductResponseDTO eachProduct : productsList.getBody()) {
			allProducts.add(eachProduct);
		}
		return allProducts;
	}

}
