package com.example.EcommerceProductService.dto;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDTO {
	UUID id;
    String title;
    String price;
    String category;
    String description;
    String image;
}
