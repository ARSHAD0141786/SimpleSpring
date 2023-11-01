package com.example.SimpleSprintDemo.service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.SimpleSprintDemo.client.FakeStoreAPIClient;
import com.example.SimpleSprintDemo.dto.FakeProductResponseDTO;
import com.example.SimpleSprintDemo.dto.ProductRequestDTO;
import com.example.SimpleSprintDemo.dto.ProductResponseDTO;

import static com.example.SimpleSprintDemo.mappers.ProductMapper.fakeProductResDTOToProductResDTO;
import static com.example.SimpleSprintDemo.mappers.ProductMapper.productReqDTOToFakeProductReqDTO;;

/**
 * This class with call a third party APIs, to manipulate products.
 */

@Service("fakeStoreProductService")
public class ProductFakeServiceImpl implements ProductService {

	@Autowired
	RestTemplateBuilder restTemplateBuilder;
	
	@Autowired
	FakeStoreAPIClient fakeStoreApiClient;
	
	@Override
	public ProductResponseDTO create(ProductRequestDTO p) {
		FakeProductResponseDTO fakeProduct = fakeStoreApiClient.createFakeProduct(productReqDTOToFakeProductReqDTO(p));
		return fakeProductResDTOToProductResDTO(fakeProduct);	
	}

	@Override
	public void update(int id, ProductRequestDTO p) {
		fakeStoreApiClient.updateFakeProduct(id, productReqDTOToFakeProductReqDTO(p));
	}

	@Override
	public void remove(int id) {
		fakeStoreApiClient.deleteFakeProduct(id);
	}

	@Override
	public ProductResponseDTO getProductById(int id) {
		FakeProductResponseDTO fakeProduct = fakeStoreApiClient.getFakeProductById(id);
		return fakeProductResDTOToProductResDTO(fakeProduct);
	}

	@Override
	public List getAllProducts() {
		List<FakeProductResponseDTO> fakeProducts = fakeStoreApiClient.getFakeProducts();
		
		List<ProductResponseDTO> allProducts = new ArrayList<>();
		
		for(FakeProductResponseDTO eachProduct : fakeProducts) {
			allProducts.add(fakeProductResDTOToProductResDTO(eachProduct));
		}
		return allProducts;
	}

}
