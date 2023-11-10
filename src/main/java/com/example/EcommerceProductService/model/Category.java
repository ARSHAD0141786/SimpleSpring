package com.example.EcommerceProductService.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Category extends BaseModel {
	private String category;
	
	@OneToMany(mappedBy = "category")
	List<Product> products;
}
