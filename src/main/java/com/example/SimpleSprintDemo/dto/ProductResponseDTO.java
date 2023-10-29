package com.example.SimpleSprintDemo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDTO {
	int id;
    String title;
    String price;
    String category;
    String description;
    String image;
}
