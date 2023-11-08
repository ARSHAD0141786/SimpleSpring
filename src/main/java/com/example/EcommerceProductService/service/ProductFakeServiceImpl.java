package com.example.EcommerceProductService.service;

import java.util.List;

import static com.example.EcommerceProductService.mappers.ProductMapper.fakeProductResDTOToProductResDTO;
import static com.example.EcommerceProductService.mappers.ProductMapper.productReqDTOToFakeProductReqDTO;
import static com.example.EcommerceProductService.util.ProductUtils.isNull;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.EcommerceProductService.client.FakeStoreAPIClient;
import com.example.EcommerceProductService.dto.FakeProductResponseDTO;
import com.example.EcommerceProductService.dto.ProductRequestDTO;
import com.example.EcommerceProductService.dto.ProductResponseDTO;
import com.example.EcommerceProductService.exception.ProductNotFoundException;

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
	public Boolean update(int id, ProductRequestDTO p) {
		fakeStoreApiClient.updateFakeProduct(id, productReqDTOToFakeProductReqDTO(p));
		return true;
	}

	@Override
	public Boolean remove(int id) {
		fakeStoreApiClient.deleteFakeProduct(id);
		return true;
	}

	@Override
	public ProductResponseDTO getProductById(int id) throws ProductNotFoundException {
		FakeProductResponseDTO fakeProduct = fakeStoreApiClient.getFakeProductById(id);
		if(isNull(fakeProduct)){
            throw new ProductNotFoundException("Product not found with id : " + id);
        }
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
