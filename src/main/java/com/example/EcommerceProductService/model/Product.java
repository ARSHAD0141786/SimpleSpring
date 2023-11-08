package com.example.EcommerceProductService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name="Product")
@Entity
public class Product extends BaseModel {
    String title;
    String price;
    String category;
    String description;
    String image;
}
