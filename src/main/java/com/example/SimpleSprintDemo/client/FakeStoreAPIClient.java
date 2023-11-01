package com.example.SimpleSprintDemo.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.SimpleSprintDemo.dto.FakeProductRequestDTO;
import com.example.SimpleSprintDemo.dto.FakeProductResponseDTO;

@Component
public class FakeStoreAPIClient {
	
	RestTemplateBuilder restTemplateBuilder;
	
	@Autowired
	public FakeStoreAPIClient(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplateBuilder = restTemplateBuilder;
	}
	
	public FakeProductResponseDTO getFakeProductById(int id) {
		String getFakeStoreProductUrl = "https://fakestoreapi.com/products/" + id;
		RestTemplate restTemplate = restTemplateBuilder.build();
		ResponseEntity<FakeProductResponseDTO> result = restTemplate.getForEntity(getFakeStoreProductUrl, FakeProductResponseDTO.class);
		return result.getBody();
	}
	
	public void updateFakeProduct(int id, FakeProductRequestDTO fakeProductRequestDTO) {
		String getFakeStoreProductUrl = "https://fakestoreapi.com/products/" + id;
		RestTemplate restTemplate = restTemplateBuilder.build();
		restTemplate.put(getFakeStoreProductUrl, fakeProductRequestDTO);
	}
	
	public List<FakeProductResponseDTO> getFakeProducts() {
		String getFakeStoreProductUrl = "https://fakestoreapi.com/products";
		RestTemplate restTemplate = restTemplateBuilder.build();
		ResponseEntity<FakeProductResponseDTO[]> result = restTemplate.getForEntity(getFakeStoreProductUrl, FakeProductResponseDTO[].class);
		List<FakeProductResponseDTO> fakeProducts = new ArrayList<>();
		for(FakeProductResponseDTO fakeProduct : result.getBody()) {
			fakeProducts.add(fakeProduct);
		}
		return fakeProducts;
	}
	
	public FakeProductResponseDTO createFakeProduct(FakeProductRequestDTO fakeProduct) {
		String getFakeStoreProductUrl = "https://fakestoreapi.com/products";
		RestTemplate restTemplate = restTemplateBuilder.build();
		ResponseEntity<FakeProductResponseDTO> result = restTemplate.postForEntity(getFakeStoreProductUrl, fakeProduct, FakeProductResponseDTO.class);
		return result.getBody();
	}
	
	public void deleteFakeProduct(int id) {
		String getFakeStoreProductUrl = "https://fakestoreapi.com/products/" + id;
		RestTemplate restTemplate = restTemplateBuilder.build();
		restTemplate.delete(getFakeStoreProductUrl);
	}
}
