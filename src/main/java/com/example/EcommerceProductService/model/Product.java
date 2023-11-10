package com.example.EcommerceProductService.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel {
    String title;
    String description;
    String image;
    
    @ManyToOne
    @JoinColumn(name = "category_id")
    Category category; 
    
    @OneToOne
    Price price;
    
    @ManyToMany(mappedBy = "products")
    List<Orders> orders;
    
}

/*
 * Product Category
 * M       1        -> ManyToOne
 * 
 */