package com.example.EcommerceProductService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "ECommProduct")
public class Product extends BaseModel {
    String title;
    String description;
    String image;
    
    @ManyToOne
    Category category;
    
    @OneToOne
    Price price;
}
