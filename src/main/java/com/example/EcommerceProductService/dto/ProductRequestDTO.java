package com.example.EcommerceProductService.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDTO {
	int id;
    String title;
    String price;
    String category;
    String description;
    String image;
}
