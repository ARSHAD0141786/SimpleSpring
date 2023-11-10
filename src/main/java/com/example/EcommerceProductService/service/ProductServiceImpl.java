package com.example.EcommerceProductService.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.EcommerceProductService.dto.ProductRequestDTO;
import com.example.EcommerceProductService.dto.ProductResponseDTO;
import com.example.EcommerceProductService.exception.ProductNotFoundException;
import com.example.EcommerceProductService.model.Product;
import com.example.EcommerceProductService.repository.PriceRepository;
import com.example.EcommerceProductService.repository.ProductRepository;

import static com.example.EcommerceProductService.mappers.ProductMapper.productToProductResponseDTO; 

@Service(value="productServiceImpl")
public class ProductServiceImpl implements ProductService {

	private ProductRepository productRepo;
	
	public ProductServiceImpl(ProductRepository pRepo) {
		this.productRepo = pRepo;
	}
	@Override
	public ProductResponseDTO create(ProductRequestDTO p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean update(int id, ProductRequestDTO p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean remove(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductResponseDTO getProductById(int id) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductResponseDTO> getAllProducts() {
		List<Product> products = productRepo.findAll();
		List<ProductResponseDTO> result = new ArrayList<ProductResponseDTO>();
		for(Product p : products) {
			result.add(productToProductResponseDTO(p));
		}
		return result;
	}

}
