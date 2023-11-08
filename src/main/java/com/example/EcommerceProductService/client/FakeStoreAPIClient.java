package com.example.EcommerceProductService.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.EcommerceProductService.dto.FakeProductRequestDTO;
import com.example.EcommerceProductService.dto.FakeProductResponseDTO;

@Component
public class FakeStoreAPIClient {
	
	RestTemplateBuilder restTemplateBuilder;
	
	@Value("${fakestore.api.url}")
	private String fakeStoreAPIUrl;
	
	private String fakeStoreAPIProductPath;
	
	@Autowired
	public FakeStoreAPIClient(RestTemplateBuilder restTemplateBuilder,
			@Value("${fakestore.api.path.product}") String fakeStoreAPIProductPath) {
		this.restTemplateBuilder = restTemplateBuilder;
		this.fakeStoreAPIProductPath = fakeStoreAPIProductPath;
	}
	
	public FakeProductResponseDTO getFakeProductById(int id) {
		String getFakeStoreProductUrl = fakeStoreAPIUrl + fakeStoreAPIProductPath+"/" + id;
		RestTemplate restTemplate = restTemplateBuilder.build();
		ResponseEntity<FakeProductResponseDTO> result = restTemplate.getForEntity(getFakeStoreProductUrl, FakeProductResponseDTO.class);
		return result.getBody();
	}
	
	public void updateFakeProduct(int id, FakeProductRequestDTO fakeProductRequestDTO) {
		String getFakeStoreProductUrl = fakeStoreAPIUrl + fakeStoreAPIProductPath+"/" + id;
		RestTemplate restTemplate = restTemplateBuilder.build();
		restTemplate.put(getFakeStoreProductUrl, fakeProductRequestDTO);
	}
	
	public List<FakeProductResponseDTO> getFakeProducts() {
		String getFakeStoreProductUrl = fakeStoreAPIUrl + fakeStoreAPIProductPath;
		RestTemplate restTemplate = restTemplateBuilder.build();
		ResponseEntity<FakeProductResponseDTO[]> result = restTemplate.getForEntity(getFakeStoreProductUrl, FakeProductResponseDTO[].class);
		List<FakeProductResponseDTO> fakeProducts = new ArrayList<>();
		for(FakeProductResponseDTO fakeProduct : result.getBody()) {
			fakeProducts.add(fakeProduct);
		}
		return fakeProducts;
	}
	
	public FakeProductResponseDTO createFakeProduct(FakeProductRequestDTO fakeProduct) {
		String getFakeStoreProductUrl = fakeStoreAPIUrl + fakeStoreAPIProductPath;
		RestTemplate restTemplate = restTemplateBuilder.build();
		ResponseEntity<FakeProductResponseDTO> result = restTemplate.postForEntity(getFakeStoreProductUrl, fakeProduct, FakeProductResponseDTO.class);
		return result.getBody();
	}
	
	public void deleteFakeProduct(int id) {
		String getFakeStoreProductUrl = fakeStoreAPIUrl + fakeStoreAPIProductPath+"/" + id;
		RestTemplate restTemplate = restTemplateBuilder.build();
		restTemplate.delete(getFakeStoreProductUrl);
	}
}
