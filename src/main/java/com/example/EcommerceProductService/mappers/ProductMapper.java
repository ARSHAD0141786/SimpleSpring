package com.example.EcommerceProductService.mappers;

import com.example.EcommerceProductService.dto.FakeProductRequestDTO;
import com.example.EcommerceProductService.dto.FakeProductResponseDTO;
import com.example.EcommerceProductService.dto.ProductRequestDTO;
import com.example.EcommerceProductService.dto.ProductResponseDTO;

public class ProductMapper {
	
	public static FakeProductRequestDTO productReqDTOToFakeProductReqDTO(ProductRequestDTO product) {
		FakeProductRequestDTO fakeProduct = new FakeProductRequestDTO();
		fakeProduct.setId(product.getId());
		fakeProduct.setTitle(product.getTitle());
		fakeProduct.setPrice(product.getPrice());
		fakeProduct.setCategory(product.getCategory());
		fakeProduct.setDescription(product.getDescription());
		fakeProduct.setImage(product.getImage());
		
		return fakeProduct;
	}
	
	public static ProductResponseDTO fakeProductResDTOToProductResDTO(FakeProductResponseDTO fakeProduct) {
		ProductResponseDTO product = new ProductResponseDTO();
		product.setId(fakeProduct.getId());
		product.setTitle(fakeProduct.getTitle());
		product.setPrice(fakeProduct.getPrice());
		product.setCategory(fakeProduct.getCategory());
		product.setDescription(fakeProduct.getDescription());
		product.setImage(fakeProduct.getImage());
		
		return product;
	}
}
