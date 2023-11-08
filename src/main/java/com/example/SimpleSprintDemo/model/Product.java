package com.example.SimpleSprintDemo.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel {
    String title;
    String price;
    String category;
    String description;
    String image;
}
